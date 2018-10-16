package ru.cedra.landingbot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import ru.cedra.landingbot.anno.Cast;
import ru.cedra.landingbot.anno.CastMethod;
import ru.cedra.landingbot.anno.Step;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MainPage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Step(ChatSteps.NAME_STEP)
    private String name;

    @Column
    @Step(ChatSteps.LOGO_STEP)
    private String logo;

    @Column
    @Step(ChatSteps.MAIN_COLOR_STEP)
    private String color;

    @Column
    @Step(ChatSteps.DESC_STEP)
    private String desc;

    @Column
    @Step(ChatSteps.KEYWORD_DESC_STEP)
    private String keywordDesc;

    @Column
    @Step(ChatSteps.TITLE_STEP)
    private String title;

    @Column
    @Step(ChatSteps.SECOND_TITLE_STEP)
    private String secondTitle;

    @Column
    @Step(ChatSteps.PHONE_STEP)
    private String phone;

    @Column
    @Step(ChatSteps.VK_STEP)
    private String vk;

    @Column
    @Step(ChatSteps.INSTAGRAM_STEP)
    private String instagram;

    @Column
    @Step(ChatSteps.FORM_TITLE_STEP)
    private String formTitle;

    @Column
    @Step(ChatSteps.HAS_FORM_CLIENT_NAME_STEP)
    @Cast(CastMethod.BOOLEAN)
    private boolean hasFormClientName;

    @Column
    @Step(ChatSteps.HAS_FORM_CLIENT_EMAIL_STEP)
    @Cast(CastMethod.BOOLEAN)
    private boolean  hasFormClientEmail;

    @Column
    @Step(ChatSteps.HAS_FORM_CLIENT_PHONE_STEP)
    @Cast(CastMethod.BOOLEAN)
    private boolean  hasFormClientPhone;

    @Column
    @Step(ChatSteps.FORM_BUTTON_TEXT_STEP)
    @Cast(CastMethod.BOOLEAN)
    private boolean formButtonText;

    @Column
    @Step(ChatSteps.ADDRESS_STEP)
    private String address;

    @Column
    @Step(ChatSteps.YA_COUNTER_STEP)
    private String yaCounterName;

    @Column
    @Step(ChatSteps.GA_COUNTER_STEP)
    private String gaCounterName;

    @Column
    @Step(ChatSteps.PIC_STEP)
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

    public boolean isHasFormClientPhone() {
        return hasFormClientPhone;
    }

    public void setHasFormClientPhone(boolean hasFormClientPhone) {
        this.hasFormClientPhone = hasFormClientPhone;
    }

    @Override
    public String toString() {
        return "MainPage{" +
            "name='" + name + '\'' +
            ", logo='" + logo + '\'' +
            ", color='" + color + '\'' +
            ", desc='" + desc + '\'' +
            ", keywordDesc='" + keywordDesc + '\'' +
            ", title='" + title + '\'' +
            ", secondTitle='" + secondTitle + '\'' +
            ", phone='" + phone + '\'' +
            ", vk='" + vk + '\'' +
            ", instagram='" + instagram + '\'' +
            ", formTitle='" + formTitle + '\'' +
            ", hasFormClientName=" + hasFormClientName +
            ", hasFormClientEmail=" + hasFormClientEmail +
            ", hasFormClientPhone=" + hasFormClientPhone +
            ", formButtonText=" + formButtonText +
            ", address='" + address + '\'' +
            ", yaCounterName='" + yaCounterName + '\'' +
            ", gaCounterName='" + gaCounterName + '\'' +
            ", pic='" + pic + '\'' +
            ", chatUser=" + chatUser +
            '}';
    }
}
