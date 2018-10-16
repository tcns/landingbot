package ru.cedra.landingbot.service.template;

import io.bit3.jsass.CompilationException;
import io.bit3.jsass.Compiler;
import io.bit3.jsass.Options;
import io.bit3.jsass.Output;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cedra.landingbot.config.ApplicationProperties;
import ru.cedra.landingbot.domain.MainPage;
import ru.cedra.landingbot.service.util.DirectoryUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by TIMUR on 20.11.2017.
 */
@Service
public class RenderService {
    Logger logger = Logger.getLogger(RenderService.class.getName());

    @Autowired
    VelocityEngine engine;
    @Autowired
    ApplicationProperties applicationProperties;

    public  void renderMain (MainPage page) throws IOException {
        Template template = engine.getTemplate(applicationProperties.getTemplatePath() + "/index-template.html", "UTF-8");

        VelocityContext velocityContext = new VelocityContext();

        velocityContext.put("page", page);

        Path dirPath = DirectoryUtil.createAndGet(applicationProperties.getExportPath()+
            "/"+page.getChatUser().getTelegramChatId()+"/"+page.getId());
        String directory = dirPath.toAbsolutePath().toString();
        if (!Files.exists(Paths.get(directory+"/"+"index.html"))) {
            FileUtils.deleteDirectory(DirectoryUtil.getResource(applicationProperties.getTemplatePath()));
        }
        FileUtils.copyDirectory(DirectoryUtil.getResource(applicationProperties.getTemplatePath()),
            dirPath.toFile());
        File file = new File(directory + "/" +
            "index.html");
        String path = file.getAbsolutePath();
        logger.info("file saved " + path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        template.merge(velocityContext, writer);
        writer.flush();
        writer.close();
        Compiler compiler = new Compiler();
        URI inputFile = new File(directory + "/sass/main.sass").toURI();
        URI outputFile = new File(directory + "/css/main.css").toURI();
        try {
            Output output = compiler.compileFile(inputFile, outputFile, new Options());
            FileUtils.forceDelete(new File(directory + "/css/main.min.css"));
            FileUtils.writeStringToFile(new File(directory + "/css/main.min.css"), output.getCss(), Charset.forName("UTF-8"));
            logger.info("Compiled successfully");
        } catch (CompilationException e) {
            logger.log(Level.SEVERE, "Compile failed");
        }
    }
}
