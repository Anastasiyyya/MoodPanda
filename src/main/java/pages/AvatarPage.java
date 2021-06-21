package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AvatarPage {

    public static final String AVATAR_CONTAINER_CSS = ".col-lg-12 [type=image]";
    public static final String AVATAR_CHANGED_TEXT_CSS = "#ContentPlaceHolderContent_MessageSuccess strong";

    /**
     * This method changes avatar of the profile to random avatar.
     * @return AvatarPage
     */
    public AvatarPage changeAvatar() {
        int randomAvatar = (int) Math.random() * 17;
        $$(AVATAR_CONTAINER_CSS).get(randomAvatar).click();
        return this;
    }

    /**
     * This method get text that avatar has been successfully changed.
     * @return text
     */
    public String getAvatarChangedText() {
        return $(AVATAR_CHANGED_TEXT_CSS).getText();
    }
}
