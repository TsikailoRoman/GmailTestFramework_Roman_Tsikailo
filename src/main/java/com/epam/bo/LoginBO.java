package com.epam.bo;


import com.epam.model.User;
import com.epam.page.LoginPage;
import com.epam.driver.DriverManager;

import static com.epam.util.Constants.*;
import static com.epam.util.Waiters.waitElementVisible;
import static com.epam.util.Waiters.waitUrl;

public class LoginBO {

    private LoginPage page;

    public LoginBO() {
        page = new LoginPage();
    }

    /**
     * Loads the login page according to the login-url in
     * the configuration file.
     */
    public void loadPage() {
        DriverManager.getInstance().getDriver()
                .get(LOGIN_URL);
    }

    /**
     * Sets user login into the input field, submits and
     * returns resulting url.
     *
     * @param user {@code User} object.
     * @return current url after the submit action.
     */
    public String performLogin(User user) {
        fillEmailAndSubmit(user.getEmail());
        fillPasswordAndSubmit(user.getPassword());

        return DriverManager.getInstance().getDriver().getCurrentUrl();
    }

    /**
     * Sets user email into the input field and submits.
     *
     * @param email email to be inserted.
     */
    private void fillEmailAndSubmit(String email) {
        waitElementVisible(page.getEmail(), 15);
        page.getEmail().fillData(email);
        page.getEmail().triggerEnterKeyEvent();

    }

    /**
     * Sets user password into the input field and submits.
     *
     * @param password password to be inserted.
     */
    private void fillPasswordAndSubmit(String password) {
        waitElementVisible(page.getPassword(), 15);
        page.getPassword().fillData(password);
        page.getPassword().triggerEnterKeyEvent();
        waitUrl(INBOX_URL, 15, 50);
    }

}
