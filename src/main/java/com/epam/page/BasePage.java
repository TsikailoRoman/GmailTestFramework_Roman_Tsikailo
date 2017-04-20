package com.epam.page;

import com.epam.driver.DriverManager;
import com.epam.page.decorator.ExtendedFieldDecorator;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {

    BasePage() {
        PageFactory.initElements(
                new ExtendedFieldDecorator(
                        DriverManager.getInstance().getDriver()), this);
        DriverManager.getInstance()
                .getDriver()
                .manage()
                .window()
                .maximize();
    }
}
