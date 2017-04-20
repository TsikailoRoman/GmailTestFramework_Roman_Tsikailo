package com.epam.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TODO
public class DriverManager {

    private static DriverManager instance = new DriverManager();
    private ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    });

    private DriverManager() {}

    public static DriverManager getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
