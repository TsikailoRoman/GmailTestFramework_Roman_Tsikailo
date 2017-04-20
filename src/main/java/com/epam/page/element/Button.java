package com.epam.page.element;

import org.openqa.selenium.WebElement;

public class Button extends AbstractPageElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        getWebElement().click();
    }
}
