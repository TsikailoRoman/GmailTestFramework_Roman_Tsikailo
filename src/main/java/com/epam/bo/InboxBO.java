package com.epam.bo;

import com.epam.page.InboxPage;
import com.epam.driver.DriverManager;

import static com.epam.util.Constants.DRAFTS_URL;
import static com.epam.util.Waiters.waitElementVisible;
import static com.epam.util.Waiters.waitUrl;

public class InboxBO {
    private InboxPage page;

    public InboxBO() {
        page = new InboxPage();
    }

    /**
     * Creates message window by clicking on the compose button. Fills the recipient,
     * subject fields and attaches a file. Closes the message window not sending the
     * message.
     *
     * @param to      recipient email address.
     * @param subject the subject of the message.
     */
    public void createMessageAndClose(String to, String subject) {
        waitElementVisible(page.getCompose(), 15);
        page.getCompose().click();

        waitElementVisible(page.getRecipients(), 20);
        page.getRecipients().fillData(to);

        waitElementVisible(page.getSubject(), 20);
        page.getSubject().fillData(subject);

        attachDocument();
        page.getCloseMessageWindow().click();
    }

    /**
     * Clicks on the drafts link and waits for the url redirect.
     */
    public void openDraftsPage() {
        page.getDrafts().click();
        waitUrl(DRAFTS_URL, 10, 20);
    }

    /**
     * Switches the frame and adds a google doc to the message.
     */
    private void attachDocument() {
        page.getAttachDoc().click();

        DriverManager.getInstance()
                .getDriver()
                .switchTo()
                .frame(page.getGoogleDoc()
                        .getWebElement());

        waitElementVisible(page.getPickFile(), 5);
        page.getPickFile().click();

        waitElementVisible(page.getSendFile(), 5);
        page.getSendFile().click();

        DriverManager.getInstance().getDriver().switchTo().defaultContent();
    }
}
