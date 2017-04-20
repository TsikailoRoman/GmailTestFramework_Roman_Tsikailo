package com.epam.page;

import com.epam.page.element.Button;
import com.epam.page.element.IFrame;
import com.epam.page.element.InputText;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {
    @FindBy(xpath = "//div[@gh='cm']")
    private Button compose;

    @FindBy(xpath = "//textarea[@name='to']")
    private InputText recipients;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private InputText subject;

    @FindBy(xpath = "//div[@command='docs']")
    private Button attachDoc;

    @FindBy(xpath = "//iframe[@class='KA-JQ']")
    private IFrame googleDoc;

    @FindBy(xpath = "//div[@class='Si-gk-lj-O-ro-so']")
    private Button pickFile;

    @FindBy(id = "picker:ap:0")
    private Button sendFile;

    @FindBy(xpath = "//img[@data-tooltip='Зберегти та закрити']")
    private Button closeMessageWindow;

    @FindBy(xpath = "//a[contains(@href, 'drafts')]")
    private Button drafts;

    public Button getCompose() {
        return compose;
    }

    public InputText getRecipients() {
        return recipients;
    }

    public InputText getSubject() {
        return subject;
    }

    public Button getAttachDoc() {
        return attachDoc;
    }

    public IFrame getGoogleDoc() {
        return googleDoc;
    }

    public Button getPickFile() {
        return pickFile;
    }

    public Button getSendFile() {
        return sendFile;
    }

    public Button getCloseMessageWindow() {
        return closeMessageWindow;
    }

    public Button getDrafts() {
        return drafts;
    }
}
