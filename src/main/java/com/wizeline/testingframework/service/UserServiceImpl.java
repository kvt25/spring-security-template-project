package com.wizeline.testingframework.service;

import com.wizeline.testingframework.persistence.model.UserModel;
import com.wizeline.testingframework.persistence.repository.PrivilegeRepository;
import com.wizeline.testingframework.persistence.repository.RoleRepository;
import com.wizeline.testingframework.persistence.repository.UserRepository;
import com.wizeline.testingframework.web.data.UserData;
import com.wizeline.testingframework.web.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The implementation for {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel registerNewUserAccount(UserData userData) throws UserAlreadyExistException {
        if (emailExist(userData.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + userData.getEmail());
        }
        final UserModel user = new UserModel();

        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setEmail(userData.getEmail());

        return userRepository.save(user);
    }


    @Override
    public void createVerificationTokenForUser(UserModel user, String token) {

    }

    private boolean emailExist(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
