package pages;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public static final String LOGIN_PAGE_CONTAINER_OF_BUTTONS_CSS = ".navbar-right li";

    /**
     * This method gets Login button text.
     * @return text
     */
    public String getLoginButtonText() {
        return $$(LOGIN_PAGE_CONTAINER_OF_BUTTONS_CSS).get(1).getText();
    }
}
