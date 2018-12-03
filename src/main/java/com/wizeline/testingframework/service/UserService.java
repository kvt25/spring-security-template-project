package com.wizeline.testingframework.service;

import com.wizeline.testingframework.persistence.model.UserModel;
import com.wizeline.testingframework.web.data.UserData;
import com.wizeline.testingframework.web.exception.UserAlreadyExistException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * The interface for business logic regarding user
 */
public interface UserService {

    UserModel registerNewUserAccount(UserData accountDto) throws UserAlreadyExistException;

    void createVerificationTokenForUser(UserModel user, String token);
}
