package ru.cedra.landingbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cedra.landingbot.domain.MainPage;
import ru.cedra.metrics.domain.Metric;

import java.util.Set;


/**
 * Created by tignatchenko on 24/04/17.
 */
public interface MainPageRepository extends JpaRepository<MainPage, Long> {
    Set<MainPage> findByChatUser_TelegramChatId(Long chatId);
}