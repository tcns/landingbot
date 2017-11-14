package ru.cedra.landingbot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.cedra.landingbot.anno.Step;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MainPage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    @Step()
    private String name;

    @Column
    private String logo;

    @Column
    private String color;

    @Column
    private String desc;

    @Column
    private String keywordDesc;

    @Column
    private String title;

    @Column
    private String secondTitle;

    @Column
    private String phone;

    @Column
    private String vk;

    @Column
    private String instagram;

    @Column
    private String formTitle;

    @Column
    private boolean hasFormClientName;

    @Column
    private boolean  hasFormClientEmail;

    @Column
    private boolean hasFormClientForm;

    @Column
    private boolean formButtonText;

    @Column
    private String address;

    @Column
    private String yaCounterName;

    @Column
    private String gaCounterName;

    @Column
    private String pic;

    @JsonIgnore
    @ManyToOne
    private ChatUser chatUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(ChatUser chatUser) {
        this.chatUser = chatUser;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKeywordDesc() {
        return keywordDesc;
    }

    public void setKeywordDesc(String keywordDesc) {
        this.keywordDesc = keywordDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public boolean isHasFormClientName() {
        return hasFormClientName;
    }

    public void setHasFormClientName(boolean hasFormClientName) {
        this.hasFormClientName = hasFormClientName;
    }

    public boolean isHasFormClientEmail() {
        return hasFormClientEmail;
    }

    public void setHasFormClientEmail(boolean hasFormClientEmail) {
        this.hasFormClientEmail = hasFormClientEmail;
    }

    public boolean isHasFormClientForm() {
        return hasFormClientForm;
    }

    public void setHasFormClientForm(boolean hasFormClientForm) {
        this.hasFormClientForm = hasFormClientForm;
    }

    public boolean isFormButtonText() {
        return formButtonText;
    }

    public void setFormButtonText(boolean formButtonText) {
        this.formButtonText = formButtonText;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYaCounterName() {
        return yaCounterName;
    }

    public void setYaCounterName(String yaCounterName) {
        this.yaCounterName = yaCounterName;
    }

    public String getGaCounterName() {
        return gaCounterName;
    }

    public void setGaCounterName(String gaCounterName) {
        this.gaCounterName = gaCounterName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
