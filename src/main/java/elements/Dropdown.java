package elements;

import pages.AvatarPage;
import pages.LoginPage;
import pages.MyDiaryPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Dropdown {

    public static final String ME_DROPDOWN_CSS = "#LIMe .dropdown-toggle";
    public static final String ME_DROPDOWN_MENU_CSS = "#LIMe .dropdown-menu a";
    public static final String ACCOUNT_DROPDOWN_CSS = "#Settings .dropdown-toggle";
    public static final String ACCOUNT_MENU_CSS = "#Settings .dropdown-menu a";

    /**
     * This method selects option from "Me" dropdown on the WorldFeedPage.
     * @return MyDiaryPage
     */
    public MyDiaryPage selectMeDropdownOption() {
        $(ME_DROPDOWN_CSS).click();
        $$(ME_DROPDOWN_MENU_CSS).get(0).click();
        return new MyDiaryPage();
    }

    /**
     * This method
     * @param option selects option from "Account" dropdown on the WorldFeedPage.
     * @return AvatarPage
     */
    public AvatarPage selectAccountDropdownOption(int option) {
        $(ACCOUNT_DROPDOWN_CSS).click();
        $$(ACCOUNT_MENU_CSS).get(option).click();
        return new AvatarPage();
    }
}
