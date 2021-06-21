package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginStep {
    private LoginPage loginPage;

    public LoginStep() {
        loginPage =  new LoginPage();
    }


    /**
     * Login on the site
     * @param login
     * @param password
     * @return
     */
    @Step
    public LoginStep login(String login, String password){
        loginPage
                .openPage()
                .login(login,password)
                .waitForUpdateMoodButtonVisible();
        return this;
    }
}
