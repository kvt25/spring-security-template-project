package com.wizeline.testingframework.event.registration;

import com.wizeline.testingframework.persistence.model.UserModel;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Registration Complete Event object
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private final String appUrl;
    private final Locale locale;
    private final UserModel userModel;

    public OnRegistrationCompleteEvent(final UserModel userModel, final Locale locale, final String appUrl) {
        super(userModel);
        this.userModel = userModel;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public UserModel getUserModel() {
        return userModel;
    }
}
