package ru.cedra.landingbot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by tignatchenko on 25/04/17.
 */
@Entity
public class ChatUser implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String telegramUsername;


    @Column
    private Long telegramChatId;

    @Column
    private String yaToken;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "chatUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private ChatState chatState;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "chatUser")
    private Set<MainPage> landings = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelegramUsername() {
        return telegramUsername;
    }

    public void setTelegramUsername(String telegramUsername) {
        this.telegramUsername = telegramUsername;
    }

    public String getYaToken() {
        return yaToken;
    }

    public void setYaToken(String yaToken) {
        this.yaToken = yaToken;
    }

    public ChatState getChatState() {
        return chatState;
    }

    public void setChatState(ChatState chatState) {
        this.chatState = chatState;
    }

    public Long getTelegramChatId() {
        return telegramChatId;
    }

    public void setTelegramChatId(Long telegramChatId) {
        this.telegramChatId = telegramChatId;
    }

    public Set<MainPage> getLandings() {
        return landings;
    }

    public void setLandings(Set<MainPage> landings) {
        this.landings = landings;
    }
}
