package com.epam.page.element;

import org.openqa.selenium.WebElement;

public class Draft extends AbstractPageElement {
    public Draft(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        return getWebElement().getText();
    }

    public void click() {
        getWebElement().click();
    }
}
