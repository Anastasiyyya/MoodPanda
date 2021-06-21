package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyDiaryPage {
    public static final String NUMBER_OF_MOOD_LEVEL_CSS = ".badge.pull-right";
    public static final String DESCRIPTION_FIELD_CSS = ".MoodPostItem";
    public static final String SEND_HUGS_BUTTON_CSS = ".ButtonHug";
    public static final String COMMENT_HUG_CSS = ".label.label-hug";

    /**
     * This method waits until number of mood level should be visible.
     * @return MyDiaryPage
     */
    public MyDiaryPage waitForNumberOfMoodLevelVisible() {
        $(NUMBER_OF_MOOD_LEVEL_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    /**
     * This method gets number of mood level.
     * @return number of mood level as text
     */
    public String getNumberOfMoodLevelFromLastComment() {
        return $$(NUMBER_OF_MOOD_LEVEL_CSS).get(0).getText();
    }

    /**
     * This method gets description.
     * @return text of the description
     */
    public String getDescriptionFromLastComment() {
        return $$(DESCRIPTION_FIELD_CSS).get(0).getText();
    }

    /**
     * This method sends hug for yourself
     * @return MyDiaryPage
     */
    public MyDiaryPage sendHugForYourself() {
        $$(SEND_HUGS_BUTTON_CSS).get(0).click();
        return this;
    }

    /**
     * This method gets text of the last "hug" comment
     * @return text of the last "hug" comment
     */
    public String getHugText() {
        return $(COMMENT_HUG_CSS).getText();
    }
}
