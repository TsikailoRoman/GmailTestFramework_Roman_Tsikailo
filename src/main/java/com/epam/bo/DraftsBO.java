package com.epam.bo;

import com.epam.driver.DriverManager;
import com.epam.model.User;
import com.epam.page.DraftsPage;
import com.epam.page.element.Draft;

import java.util.concurrent.TimeUnit;

import static com.epam.util.Waiters.*;

public class DraftsBO {
    private DraftsPage page;

    public DraftsBO() {
        page = new DraftsPage();
    }

    /**
     * Returns drafts subject according to the {@code Message}
     * in the {@code User} object or {@code null} if match isn't
     * found.
     */
    public String getDraftSubject(User user) {
        return getDraftBySubject(user).getText();
    }

    /**
     * Sends a draft with a certain subject.
     *
     * @param user model object with contains a subject.
     */
    public void sendDraft(User user) {
        getDraftBySubject(user).click();
        waitElementClickable(page.getSend(), 10);
        page.getSend().click();
        DriverManager.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Iterates over a {@code List<Draft>} and returns
     * a Draft witch text matches the {@code User} subject.
     *
     * @param user model object with contains a subject.
     * @return a certain {@code Draft} object.
     */
    private Draft getDraftBySubject(User user) {
        waitElementVisible(page.getDrafts().get(0), 20);
        return page.getDrafts()
                .stream()
                .filter(d ->
                        d.getText().equals(user.getMessage().getSubject()))
                .findFirst()
                .orElse(null);
    }
}
