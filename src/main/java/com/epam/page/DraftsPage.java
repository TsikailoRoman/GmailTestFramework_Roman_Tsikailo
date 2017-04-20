package com.epam.page;

import com.epam.page.element.Button;
import com.epam.page.element.Draft;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends BasePage {

    @FindBy(xpath = "//div[@class='y6']//span[@class='bog']")
    private List<Draft> drafts;

    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji aoO T-I-atl L3']")
    private Button send;

    public List<Draft> getDrafts() {
        return drafts;
    }

    public Button getSend() {
        return send;
    }
}
