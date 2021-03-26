package edu.ada.service.library.service;

import edu.ada.service.library.model.dto.RegistrationModel;

public interface AuthenticationService {
    boolean registration(RegistrationModel registrationModel);

    int login(String email, String password);



}
