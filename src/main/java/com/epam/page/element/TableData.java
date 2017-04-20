package com.epam.page.element;

import org.openqa.selenium.WebElement;

public class TableData extends AbstractPageElement{
    TableData(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        return getWebElement().getText();
    }
}
