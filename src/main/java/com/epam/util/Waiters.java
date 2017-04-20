package com.epam.util;


import com.epam.driver.DriverManager;
import com.epam.page.element.AbstractPageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Waiters {

    public static void waitUrl(String url, int timeOut, int polling) {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getInstance().getDriver())
                .withTimeout(timeOut, SECONDS)
                .pollingEvery(polling, MILLISECONDS);
        wait.until(ExpectedConditions.urlMatches(url));
    }

    public static void waitElementVisible(AbstractPageElement element, int timeOut) {
        new WebDriverWait(DriverManager.getInstance().getDriver(), timeOut).until(
                ExpectedConditions.visibilityOf(element.getWebElement()));
    }

    public static void waitElementClickable(AbstractPageElement element, int timeOut) {
        new WebDriverWait(DriverManager.getInstance().getDriver(), timeOut).until(
                ExpectedConditions.elementToBeClickable(element.getWebElement()));
    }
}

