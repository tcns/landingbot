package ru.cedra.landingbot.service.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.cedra.landingbot.config.ApplicationProperties;
import ru.cedra.landingbot.domain.ChatSteps;
import ru.cedra.landingbot.domain.ChatUser;
import ru.cedra.landingbot.domain.Commands;
import ru.cedra.landingbot.service.ChatUserService;
import ru.cedra.landingbot.service.UserService;


/**
 * Created by tignatchenko on 22/04/17.
 */
@Service
public class LandingBot extends TelegramLongPollingBot {
    @Autowired
    ApplicationProperties applicationProperties;
    @Autowired
    LandingService landingService;
    @Autowired
    UserService userService;
    @Autowired
    ChatUserService chatUserService;
    @Autowired
    ChatStateService chatStateService;

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }

    public void sendMessageExternal (SendMessage sendMessage) {
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            int chatStep = chatStateService.getCurrentStep(chatId);
            SendMessage message = new SendMessage();
            if (callbackData.startsWith(Commands.GET_LANDING)) {
                message = landingService.getMetricDefinition(chatId,
                                                            Long.parseLong(callbackData.substring(Commands.GET_LANDING.length())));
            } else if (callbackData.startsWith(Commands.DELETE_ONE_LANDING)) {
                message = landingService.deleteMetric(chatId,
                                                            Long.parseLong(callbackData.substring(Commands.DELETE_ONE_LANDING.length())));
            } else if (callbackData.startsWith(Commands.EDIT_ONE_LANDING)) {
                message = landingService.editMetric(chatId,
                                                     Long.parseLong(callbackData.substring(Commands.EDIT_ONE_LANDING.length())));
            } else if (callbackData.startsWith(Commands.EDIT_ONE_PARAM)) {
                String signature = callbackData.substring(Commands.EDIT_ONE_PARAM.length());
                String[] kv = signature.split("-");
                message = landingService.initEdition(chatId, Integer.parseInt(kv[1]), kv[0]);
            } else if (callbackData.startsWith(Commands.STAT_ONE_LANDING)) {
                message = landingService.getMetricReportNow(chatId,
                                                  Long.parseLong(callbackData.substring(Commands.STAT_ONE_LANDING.length())));
            } else if (callbackData.startsWith(Commands.DEALS_EDIT)) {
            } else if (callbackData.startsWith(Commands.DEALS_DATE)) {
                message = landingService.editDeals(chatId, callbackData.substring(Commands.DEALS_EDIT.length()));
            } else  {
                switch (chatStep) {
                    case ChatSteps.COUNT_STEP:
                    case ChatSteps.GOAL_STEP:
                        message = landingService.handleInput(callbackData, chatId);
                        break;

                }
            }

            try {
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            String input = update.getMessage().getText();
            if (chatUserService.getChatUser(chatId) == null) {
                input = Commands.START;
            }
            switch (input.toLowerCase()) {
                case Commands.START:
                    ChatUser chatUser = chatUserService.createOrReturnChatUser(chatId);
                    break;
                case Commands.ADD_LANDING:
                    chatStateService.updateChatStep(0, chatId);
                    message = landingService.initConversation(update.getMessage().getChatId());
                    break;
                case Commands.MAIN:
                    chatStateService.updateChatStep(0, chatId);
                    message = getMainMenu(chatId);
                    break;
                default:
                    int chatStep = chatStateService.getCurrentStep(chatId);
                    switch (chatStep) {
                        case 0: message = getDefaultMessage(chatId);
                            break;
                        default:
                             message = landingService.handleInput(update.getMessage().getText(), chatId);
                            break;
                    }
                    break;
            }

            try {
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return applicationProperties.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return applicationProperties.getBotToken();
    }



    public SendMessage getDefaultMessage(Long chatId) {
        SendMessage sendMessage = new SendMessage().
            setChatId(chatId)
            .setText("Введите команду");
        return sendMessage;
    }

    public SendMessage getMainMenu(Long chatId) {
        SendMessage sendMessage = new SendMessage().
                                                       setChatId(chatId)
                                                   .setText(Commands.ADD_LANDING + " добавить лендинг\n" +
                                                                Commands.DELETE_LANDING + " удалить лендинг\n" +
                                                                Commands.LANDING_LIST + " список лендингов\n" +
                                                                Commands.EDIT_LANDING + " редактировать\n" +
                                                                Commands.MAIN + " главное меню\n" +
                                                                Commands.START + " редактировать");
        return sendMessage;
    }

}
