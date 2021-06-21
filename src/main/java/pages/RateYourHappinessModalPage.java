package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RateYourHappinessModalPage {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String UPDATE_MOOD_BUTTON = ".ButtonUpdate";
    public static final String WHATS_HAPPENING_FIELD_CSS = "#TextBoxUpdateMoodTag";
    public static final String CALENDAR_DROPDOWN_CSS = "#Advanced > img";
    public static final String SELECT_YEAR_DROPDOWN_CSS = ".ui-datepicker-year";
    public static final String SELECT_MONTH_DROPDOWN_CSS = ".ui-datepicker-month";
    public static final String SELECT_VALUE_OF_YEAR_MONTH_DROPDOWN_CSS = "*[value='%s']";
    public static final String ALL_AVAILABLE_DAYS_IN_TABLE = "#ui-datepicker-div tr td a";
    public static final String UPDATE_MOOD_TABLE_CSS = "#ui-datepicker-div";
    public static final String CLOSE_BUTTON_CSS = ".modal-header .close";
    public static final String CANCEL_BUTTON_CSS = ".modal-footer .pull-left";


    /**
     * This method generates random number for mood.
     * @return int randomMoodValue
     */
    public int generateRandomMood(){
        int randomMoodValue = (int) (Math.random() * 10);
        return randomMoodValue;
    }

    /**
     * This method changes value of mood.
     * @param moodValue
     * @return RateYourHappinessModalPage
     */
    public RateYourHappinessModalPage changeMoodLevelTo(int moodValue) {
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue){
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue){
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue != defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        return new RateYourHappinessModalPage();
    }

    /**
     * This method writes description for mood.
     * @param input
     * @return RateYourHappinessModalPage
     */
    public RateYourHappinessModalPage writeDescriptionForMood(String input){
        $(WHATS_HAPPENING_FIELD_CSS).sendKeys(input);
        return new RateYourHappinessModalPage();
    }

    /**
     * This method helps you to choose date of the comment you want to send.
     * @param year
     * @param month
     * @param day
     * @return
     */
        public RateYourHappinessModalPage chooseDate(int year, int month, String day){
        $(CALENDAR_DROPDOWN_CSS).click();
        waitForUpdateDateTableIsVisible();
        $(String.format(SELECT_YEAR_DROPDOWN_CSS,year)).click();
        $(String.format(SELECT_VALUE_OF_YEAR_MONTH_DROPDOWN_CSS,year)).click();
        $(String.format(SELECT_MONTH_DROPDOWN_CSS,month)).click();
        $(String.format(SELECT_VALUE_OF_YEAR_MONTH_DROPDOWN_CSS,month-1)).click();
        chooseDayFromTheCalendar(day);
        return this;
    }

    /**
     * This method waits until the date table should be visible.
     * @return RateYourHappinessModalPage
     */
    public RateYourHappinessModalPage waitForUpdateDateTableIsVisible() {
        $(UPDATE_MOOD_TABLE_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    /**
     * This method chooses a day from the calendar.
     * @param day
     * @return RateYourHappinessModalPage
     */
    public RateYourHappinessModalPage chooseDayFromTheCalendar(String day){
        $$(ALL_AVAILABLE_DAYS_IN_TABLE).findBy(Condition.text(day)).click();
        return this;
    }

    /**
     * This method clicks on "Update mood to number" button
     * @return MoodUpdatedModalPage
     */
    public MoodUpdatedModalPage clickOnUpdateMoodToNumberButton() {
        $(UPDATE_MOOD_BUTTON).click();
        return new MoodUpdatedModalPage();
    }

    /**
     * This method clicks on "close" button.
     * @return FeedPage
     */
    public FeedPage clickCloseButton(){
        $(CLOSE_BUTTON_CSS).click();
        return new FeedPage();
    }

    /**
     * This method clicks on "cancel" button.
     * @return
     */
    public FeedPage clickCancelButton(){
        $(CANCEL_BUTTON_CSS).click();
        return new FeedPage();
    }
}
