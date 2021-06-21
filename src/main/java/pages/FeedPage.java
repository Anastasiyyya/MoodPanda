package pages;

import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;


public class FeedPage {

    public static final String UPDATE_MOOD_BUTTON_CSS = "span.navbar-hidesmalla";

    /**
     * This method clicks on "update mood" button.
     * @return RateYourHappinessModalPage
     */
    public RateYourHappinessModalPage clickOnUpdateMoodButton(){
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModalPage();
    }

    /**
     * This method waits until the "update button" should be visible.
     * @return FeedPage
     */
    public FeedPage waitForUpdateMoodButtonVisible() {
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    /**
     * This method gets text from the "Update mood" button.
     * @return text
     */
    public String getUpdateMoodButtonText() {
        return $(UPDATE_MOOD_BUTTON_CSS).getText();
    }


}
