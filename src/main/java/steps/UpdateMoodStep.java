package steps;

import io.qameta.allure.Step;
import pages.FeedPage;
import pages.MoodUpdatedModalPage;
import pages.RateYourHappinessModalPage;

public class UpdateMoodStep {
    FeedPage feedPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    MoodUpdatedModalPage moodUpdatedModalPage;

    public UpdateMoodStep() {
        feedPage = new FeedPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
    }

    /**
     * This step fills with data all fields of the MoodUpdatedModalPage
     * @return MoodUpdatedModalPage
     */
    @Step
    public MoodUpdatedModalPage updateMood(){
        int randomMood = rateYourHappinessModalPage.generateRandomMood();
        String descriptionForMood =  "I'm happy to be here=)";
        feedPage
                .waitForUpdateMoodButtonVisible()
                .clickOnUpdateMoodButton()
                .changeMoodLevelTo(randomMood)
                .writeDescriptionForMood(descriptionForMood)
                .chooseDate(2021, 6, "19");
        return new MoodUpdatedModalPage();
    }
}
