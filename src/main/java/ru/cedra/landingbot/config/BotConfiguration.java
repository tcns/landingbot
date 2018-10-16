package ru.cedra.landingbot.config;

import com.cloudinary.Cloudinary;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.cedra.landingbot.service.bot.LandingBot;

import javax.annotation.PostConstruct;
import java.util.Properties;


/**
 * Created by tignatchenko on 22/04/17.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BotConfiguration {
    @Autowired
    private LandingBot landingBot;

    @Autowired
    ApplicationProperties applicationProperties;

    Cloudinary cloudinary = new Cloudinary();

    VelocityEngine velocityEngine = new VelocityEngine();

    @PostConstruct
    public void init() throws TelegramApiRequestException {
        cloudinary.config.apiKey = applicationProperties.getCloudinaryApiKey();
        cloudinary.config.cloudName = applicationProperties.getCloudinaryCloudName();
        cloudinary.config.apiSecret = applicationProperties.getCloudinaryApiSecret();
        Properties props = new Properties();
        props.put(RuntimeConstants.RESOURCE_LOADER, "classpath");
        props.put("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init(props);
    }

    @Bean
    Cloudinary cloudinary(){
        return cloudinary;
    }

    @Bean
    VelocityEngine velocityEngine() {
        return velocityEngine;
    }

}
