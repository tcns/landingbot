package ru.cedra.landingbot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


/**
 * Created by tignatchenko on 23/04/17.
 */
@Entity
public class ChatState {
    @GenericGenerator(name = "generator", strategy = "foreign",
                      parameters = @Parameter(name = "property", value = "chatUser"))
    @Id
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column
    private Integer step;

    @Column
    private String data;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private ChatUser chatUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(ChatUser chatUser) {
        this.chatUser = chatUser;
    }
}
