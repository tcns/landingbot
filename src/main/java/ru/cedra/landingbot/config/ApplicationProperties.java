package ru.cedra.landingbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Landingbot.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private String botToken;

    private String botUsername;
    private String cloudinaryCloudName;
    private String cloudinaryApiKey;
    private String cloudinaryApiSecret;
    private String cloudinaryApiUrl;
    private String templatePath;
    private String exportPath;

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getBotUsername() {
        return botUsername;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public String getCloudinaryCloudName() {
        return cloudinaryCloudName;
    }

    public void setCloudinaryCloudName(String cloudinaryCloudName) {
        this.cloudinaryCloudName = cloudinaryCloudName;
    }

    public String getCloudinaryApiKey() {
        return cloudinaryApiKey;
    }

    public void setCloudinaryApiKey(String cloudinaryApiKey) {
        this.cloudinaryApiKey = cloudinaryApiKey;
    }

    public String getCloudinaryApiSecret() {
        return cloudinaryApiSecret;
    }

    public void setCloudinaryApiSecret(String cloudinaryApiSecret) {
        this.cloudinaryApiSecret = cloudinaryApiSecret;
    }

    public String getCloudinaryApiUrl() {
        return cloudinaryApiUrl;
    }

    public void setCloudinaryApiUrl(String cloudinaryApiUrl) {
        this.cloudinaryApiUrl = cloudinaryApiUrl;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getExportPath() {
        return exportPath;
    }

    public void setExportPath(String exportPath) {
        this.exportPath = exportPath;
    }
}
