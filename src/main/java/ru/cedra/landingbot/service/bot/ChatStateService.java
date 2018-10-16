package ru.cedra.landingbot.service.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.cedra.landingbot.domain.ChatState;
import ru.cedra.landingbot.domain.ChatSteps;
import ru.cedra.landingbot.repository.ChatStateRepository;
import ru.cedra.landingbot.service.ChatUserService;

/**
 * Created by tignatchenko on 24/04/17.
 */
@Service
public class ChatStateService {
    @Autowired
    ChatStateRepository chatStateRepository;
    @Autowired
    ChatUserService chatUserService;

    public void updateChatStep(Integer step, Long chatId) {
        updateChatStep(step, chatId, "");
    }
    public void updateChatStep(Integer step, Long chatId, String data) {
        ChatState
            chatState = chatStateRepository.findOneByChatUser_TelegramChatId(chatId);
        if (chatState  == null) {
            chatState = new ChatState();
            chatState.setChatUser(chatUserService.getChatUser(chatId));

        }
        chatState.setStep(step);
        chatState.setData(data);
        chatStateRepository.save(chatState);
    }

    public SendMessage updateStepAndGetMessage (Integer step, Long chatId) {
        return updateStepAndGetMessage(step, chatId, "");
    }

    public SendMessage updateStepAndGetMessage (Integer step, Long chatId, String data) {
        updateChatStep(step, chatId, data);
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(ChatSteps.states.get(step));
        return message;
    }

    public Integer getCurrentStep(Long chatId) {
        ChatState
            chatState = chatStateRepository.findOneByChatUser_TelegramChatId(chatId);
        if (chatState == null) {
            return 0;
        }
        return chatState.getStep();

    }
    public ChatState getCurrentChatState (Long chatId) {
        return chatStateRepository.findOneByChatUser_TelegramChatId(chatId);
    }
}
