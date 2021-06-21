package tests;

import constants.IConstantsURL;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTests extends BaseTest implements IConstantsURL {

    /**
     * This test checks that the number of mood level appeared on MyDiaryPage.
     */
    @Test(description = "Check that the number of mood level appeared on MyDiaryPage", priority = 1)
    public void enterNewMoodParametersTest(){
        int randomMood = rateYourHappinessModalPage.generateRandomMood();
        String descriptionForMood =  "I'm happy to be here=)";
        loginStep.login(LOGIN,PASSWORD);
        feedPage
                .waitForUpdateMoodButtonVisible()
                .clickOnUpdateMoodButton()
                .changeMoodLevelTo(randomMood)
                .writeDescriptionForMood(descriptionForMood)
                .chooseDate(2021, 6, "19")
                .clickOnUpdateMoodToNumberButton();
        moodUpdatedModalPage
                .clickGoToMyDiaryButton()
                .waitForNumberOfMoodLevelVisible();
        Assert.assertEquals(myDiaryPage.getNumberOfMoodLevelFromLastComment(), String.valueOf(randomMood));
    }

    /**
     * This test checks that the description appeared on MyDiaryPage.
     */
    @Test(description = "Check that the description appeared on MyDiaryPage", priority = 1)
    public void checkMoodDescriptionTest(){
        loginStep.login(LOGIN,PASSWORD);
        updateMoodStep.updateMood();
        rateYourHappinessModalPage.clickOnUpdateMoodToNumberButton();
        moodUpdatedModalPage.clickGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getDescriptionFromLastComment(),"I'm happy to be here=)");
    }

    /**
     * This test checks that the button 'cancel' works.
     */
    @Test(description = "Try to click cancel and go to the FeedPage", priority = 2)
    public void enterNewMoodParametersAndClickCancelTest(){
        loginStep.login(LOGIN,PASSWORD);
        updateMoodStep.updateMood();
        rateYourHappinessModalPage.clickCancelButton();
        Assert.assertEquals(feedPage.getUpdateMoodButtonText(),"Update mood");
    }

    /**
     * This test checks that the button 'close' works.
     */
    @Test(description = "Try to click close and go to the FeedPage", priority = 2)
    public void enterNewMoodParametersAndClickCloseTest(){
        loginStep.login(LOGIN,PASSWORD);
        updateMoodStep.updateMood();
        rateYourHappinessModalPage.clickCloseButton();
        Assert.assertEquals(feedPage.getUpdateMoodButtonText(),"Update mood");
    }

    /**
     * This method checks that the hugs gor yourself have been sent.
     */
    @Test(description = "Check that hugs has been sent", priority = 3)
    public void sendAHugTest(){
        loginStep.login(LOGIN,PASSWORD);
        dropdown.selectMeDropdownOption();
        myDiaryPage.sendHugForYourself();
        Assert.assertEquals(myDiaryPage.getHugText(),"\uD83D\uDC3CHugs - Anastasiya S");
    }

    /**
     * This method checks that the hugs for someone has been sent.
     */
    @Test(description = "Check that hugs has been sent", priority = 3)
    public void sendAHugForSomeoneTest(){
        loginStep.login(LOGIN,PASSWORD);
        worldFeedPage.sendSomeoneAHug();
        Assert.assertEquals(worldFeedPage.getHugText(),"\uD83D\uDC3CHugs - You");
    }

    /**
     * This method checks that the comment for someone has been sent.
     */
    @Test(description = "Check that the comment has been sent", priority = 3)
    public void sendACommentForSomeoneTest(){
        loginStep.login(LOGIN,PASSWORD);
        worldFeedPage.sendSomeoneAComment();
        Assert.assertEquals(worldFeedPage.getCommentText(),"Have a good day!=)");
    }

    /**
     * This method checks that the avatar has been changed.
     */
    @Test(description = "Check that the avatar has been changed", priority = 4)
    public void changeAvatarTest(){
        loginStep.login(LOGIN,PASSWORD);
        dropdown.selectAccountDropdownOption(1);
        avatarPage.changeAvatar();
        Assert.assertEquals(avatarPage.getAvatarChangedText(),"Success!");
    }
}
