package com.wizeline.testingframework.web.controller;

import com.wizeline.testingframework.service.UserService;
import com.wizeline.testingframework.web.data.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for user related actions
 */
@RestController
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse registerUserAccount(final HttpServletRequest request) {
        LOGGER.debug("user logged in successfully");

        return new GenericResponse("success");
    }

}
