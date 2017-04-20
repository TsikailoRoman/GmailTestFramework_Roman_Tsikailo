package com.epam.page.element;

import org.openqa.selenium.WebElement;

public class InputText extends AbstractPageElement {
    public InputText(WebElement webElement) {
        super(webElement);
    }

    public void fillData(String data) {
        getWebElement().sendKeys(data);
    }

    public void triggerEnterKeyEvent() {
        getWebElement().submit();
    }

    public String getText() {
        return getWebElement().getText();
    }
}
