package ru.cedra.landingbot.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.cedra.landingbot.config.ApplicationProperties;
import ru.cedra.landingbot.config.Constants;
import ru.cedra.landingbot.domain.User;
import ru.cedra.landingbot.repository.UserRepository;
import ru.cedra.landingbot.security.AuthoritiesConstants;
import ru.cedra.landingbot.service.MailService;
import ru.cedra.landingbot.service.UserService;
import ru.cedra.landingbot.service.dto.UserDTO;
import ru.cedra.landingbot.service.util.DirectoryUtil;
import ru.cedra.landingbot.web.rest.errors.BadRequestAlertException;
import ru.cedra.landingbot.web.rest.errors.EmailAlreadyUsedException;
import ru.cedra.landingbot.web.rest.errors.LoginAlreadyUsedException;
import ru.cedra.landingbot.web.rest.util.HeaderUtil;
import ru.cedra.landingbot.web.rest.util.PaginationUtil;
import ru.cedra.landingbot.web.rest.vm.ManagedUserVM;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing users.
 * <p>
 * This class accesses the User entity, and needs to fetch its collection of authorities.
 * <p>
 * For a normal use-case, it would be better to have an eager relationship between User and Authority,
 * and send everything to the client side: there would be no View Model and DTO, a lot less code, and an outer-join
 * which would be good for performance.
 * <p>
 * We use a View Model and a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities, because people will
 * quite often do relationships with the user, and we don't want them to get the authorities all
 * the time for nothing (for performance reasons). This is the #1 goal: we should not impact our users'
 * application because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is not a real issue as
 * we have by default a second-level cache. This means on the first HTTP call we do the n+1 requests,
 * but then all authorities come from the cache, so in fact it's much better than doing an outer join
 * (which will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages users, for security reasons, we'd rather have a DTO layer.</li>
 * </ul>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this case.
 */
@RestController
@RequestMapping("/landings")
@Slf4j
public class LandingResource {

    @Autowired
    ApplicationProperties applicationProperties;

    @RequestMapping(value = "/{chat_user}/{landing_name}", method = RequestMethod.GET)
    public void getFile(
        @PathVariable("chat_user") String chatUser, @PathVariable("landing_name") String landingName,
        HttpServletResponse response) {
        try {
            Path dirPath = DirectoryUtil.createAndGet(applicationProperties.getExportPath()+
                "/"+chatUser+"/"+landingName);
            String directory = dirPath.toAbsolutePath().toString();
            File file = new File(directory + "/" +
                "index.html");
            // get your file as InputStream
            InputStream is = new FileInputStream(file);
            // copy it to response's OutputStream
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.setContentType(MediaType.TEXT_HTML.toString());
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }

    }
}
