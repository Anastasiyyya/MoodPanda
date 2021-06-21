package pages;

import constants.IConstantsURL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage implements IConstantsURL {

    public static final String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static final String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";

    /**
     * This method opens login page by URL.
     *
     * @return the login page
     */
    public LoginPage openPage() {
        open(LOGIN_URL);
        return this;
    }

    /**
     * This method performs authorization on the site
     * @param email
     * @param password
     * @return the feed page
     */
    public FeedPage login(String email, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }
}
