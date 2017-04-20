package com.epam.page.element;


import org.openqa.selenium.WebElement;

public class AbstractPageElement implements Element{
    private WebElement webElement;

    AbstractPageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
