package com.epam.page;

import com.epam.page.element.InputText;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "Email")
    private InputText email;

    @FindBy(id = "Passwd")
    private InputText password;

    public InputText getEmail() {
        return email;
    }

    public InputText getPassword() {
        return password;
    }
}
