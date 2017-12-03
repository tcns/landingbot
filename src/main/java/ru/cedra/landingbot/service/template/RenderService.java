package ru.cedra.landingbot.service.template;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cedra.landingbot.config.ApplicationProperties;
import ru.cedra.landingbot.domain.MainPage;

/**
 * Created by TIMUR on 20.11.2017.
 */
@Service
public class RenderService {

    @Autowired
    VelocityEngine engine;
    @Autowired
    ApplicationProperties applicationProperties;

    public  void renderMain (MainPage page, Long chatId) {
        Template template = engine.getTemplate(applicationProperties.getTemplatePath() + "index.php");

        VelocityEngine velocityEngine = new VelocityEngine();

        velocityEngine.addProperty("page", page);



    }
}
