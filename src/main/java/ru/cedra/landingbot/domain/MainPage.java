package ru.cedra.landingbot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import ru.cedra.landingbot.anno.Cast;
import ru.cedra.landingbot.anno.CastMethod;
import ru.cedra.landingbot.anno.Step;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
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

    @Transient
    private List<String> gallery;

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
