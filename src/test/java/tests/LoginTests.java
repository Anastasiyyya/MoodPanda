package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testConstants.ITestConstants;

public class LoginTests extends BaseTest implements ITestConstants {

    /**
     * This test checks the ability to login the site.
     */
    @Test(description = "Authorization on the site")
    public void loginTest() {
        loginPage
                .openPage()
                .login(LOGIN, PASSWORD)
                .waitForUpdateMoodButtonVisible();
        Assert.assertEquals(feedPage.getUpdateMoodButtonText(), "Update mood");
    }

    /**
     * This test checks the ability to leave the site.
     */
    @Test(description = "Logout on the site")
    public void logoutTest() {
        loginPage.openPage()
                .login(LOGIN,PASSWORD);
        dropdown.selectAccountDropdownOption(7);
        Assert.assertEquals(mainPage.getLoginButtonText(), "Login");
    }
}
