package edu.ada.service.library.service.impl;


import edu.ada.service.library.controller.impl.AuthenticationWSImpl;
import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.model.entity.UserEntity;
import edu.ada.service.library.repository.UserRepository;
import edu.ada.service.library.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "DatabaseAuthentication")
public class AuthenticationServiceImpl implements AuthenticationService {
    protected static Logger log = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registration(RegistrationModel registrationModel) {
        try {
            userRepository.save(new UserEntity(registrationModel));
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public int login(String email, String password) {
        UserEntity user;
        user = userRepository.findFirstByEmail(email);

        if (user != null && user.getId() > 0) {
            user = userRepository.findFirstByEmailAndPassword(email, password);

            if (user != null && user.getId() > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }

    }
}
