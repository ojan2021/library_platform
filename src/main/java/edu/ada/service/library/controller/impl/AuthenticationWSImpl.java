package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.AuthenticationWS;
import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationWSImpl implements AuthenticationWS {

    protected static Logger log = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Autowired
    @Qualifier(value = "DatabaseAuthentication")
    private AuthenticationService authenticationService;


    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password
    ) {

        int result = authenticationService.login(email, password);
        if (result < 0)
            return ResponseEntity.notFound().build();
        else if (result == 0)
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        else
            return ResponseEntity.ok("You have been successfully authorized");

    }

    @Override
    @RequestMapping(value = "/forget", method = RequestMethod.GET) //value = "/forget" and "/forget" are the same
    public ResponseEntity forgetPassword(
            @RequestParam(name = "email", required = true) String email
    ) {
        log.info("Email :: {}", email);
        return null;
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity register(
            @RequestBody RegistrationModel formData
    ) {
        if (authenticationService.registration(formData)) {
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
