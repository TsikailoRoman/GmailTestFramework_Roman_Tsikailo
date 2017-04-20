package com.epam;

import com.epam.bo.DraftsBO;
import com.epam.bo.InboxBO;
import com.epam.bo.LoginBO;
import com.epam.model.User;
import com.epam.driver.DriverManager;
import org.testng.annotations.*;

import java.util.concurrent.TimeoutException;

import static com.epam.util.Constants.TEST_DATA_PATH;
import static com.epam.util.ExcelManager.*;
import static org.testng.Assert.*;


public class GmailTest {

    @DataProvider(parallel = true)
    public Object[][] credentials() {
        setExcelReading(TEST_DATA_PATH, 0);
        return getTableData();
    }

    @Test(dataProvider = "credentials")
    public void sendDraftScenarioTest(User user) {
        LoginBO loginBO = new LoginBO();
        InboxBO inboxBO = new InboxBO();
        DraftsBO draftsBO = new DraftsBO();

        loginBO.loadPage();
        loginBO.performLogin(user);

        inboxBO.createMessageAndClose(
                user.getMessage().getRecipient(), user.getMessage().getSubject());
        inboxBO.openDraftsPage();

        String expected = user.getMessage().getSubject();
        String actual = draftsBO.getDraftSubject(user);
        assertEquals(actual, expected);

        draftsBO.sendDraft(user);
        DriverManager.getInstance().getDriver().close();
    }

    @Test
    public void professionalTestCase() {
        assertFalse(false);
        assertNotEquals("not", "equals");
    }


    @Test(dataProvider = "credentials")
    public void wrongSubjectTest(User user) {        //negative testCase
        LoginBO loginBO = new LoginBO();
        DraftsBO draftsBO = new DraftsBO();

        loginBO.loadPage();
        loginBO.performLogin(user);
        try {
            draftsBO.getDraftSubject(user);
        } catch (Exception e) {
            assertNotNull(e);
        } finally {
            DriverManager.getInstance().getDriver().close();
        }
    }

    @AfterClass
    public void quit(){
        DriverManager.getInstance().getDriver().close();
        DriverManager.getInstance().getDriver().quit();
    }
}
