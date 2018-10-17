package ru.cedra.landingbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.postaddict.instagram.scraper.Instagram;
import me.postaddict.instagram.scraper.model.Account;
import me.postaddict.instagram.scraper.model.Media;
import me.postaddict.instagram.scraper.model.PageObject;
import net.logstash.logback.encoder.org.apache.commons.lang.StringEscapeUtils;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ScraperService {

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    RestTemplate restTemplate;

    protected static final String GROUP_NAME = "json";
    private static final Pattern JSON_PATTERN = Pattern.compile(
        String.format("window\\._sharedData = (?<%s>.+);</script>", GROUP_NAME));

    private static final HttpEntity REQUEST_ENTITY;
    static {
        HttpHeaders headers = new HttpHeaders();
        headers.set("authority", "socialblade.com");
        headers.set("accept", "ext/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.set("upgrade-insecure-requests", "1");
        headers.set("Accept-Language", "en");
        headers.set("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
        REQUEST_ENTITY = new HttpEntity(headers);
    }
    public List<String> extractInstagramGallery(String instagramUrl, int count) throws IOException {

        String pageContent = restTemplate.exchange("https://www.instagram.com/" + getAccountName(instagramUrl) + "/", HttpMethod.GET, REQUEST_ENTITY, String.class).getBody();

        String val = getFieldValueFromPage(pageContent, JSON_PATTERN);
        HashMap<String,Object> result =
            new ObjectMapper().readValue(val, HashMap.class);
        return new ArrayList<>();

    }

    private String getAccountName(String instagramUrl) {
        String baseUrl = "instagram.com/";
        if (!instagramUrl.contains(baseUrl)) {
            return instagramUrl;
        }
        String name = instagramUrl.substring(instagramUrl.indexOf(baseUrl) + baseUrl.length()).replace("/", "");
        return name;

    }
    private final String getFieldValueFromPage(String pageContent, Pattern pattern) {
        return Optional.of(pattern.matcher(pageContent))
            .filter(Matcher::find)
            .map(matcher -> matcher.group(GROUP_NAME))
            .orElse("");
    }
}
