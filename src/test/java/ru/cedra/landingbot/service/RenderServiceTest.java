package ru.cedra.landingbot.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.cedra.landingbot.LandingbotApp;
import ru.cedra.landingbot.domain.MainPage;
import ru.cedra.landingbot.service.template.RenderService;

import javax.mail.internet.MimeMessage;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

/**
 * Created by TIMUR on 03.12.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LandingbotApp.class)
@Transactional
@Ignore
public class RenderServiceTest {


    private MainPage mainPage;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mainPage = new MainPage();
        mainPage.setAddress("sdfs");
        mainPage.setColor("sdfsd");
        mainPage.setFormTitle("sddggh");
        mainPage.setSecondTitle("sfhsdhs");
    }

    @Test
    public void testRender() throws IOException {
        RenderService renderService = new RenderService();
        renderService.renderMain(mainPage);
    }


}
