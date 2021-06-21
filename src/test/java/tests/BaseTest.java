package tests;

import com.codeborne.selenide.Configuration;
import elements.Dropdown;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginStep;
import steps.UpdateMoodStep;
import testConstants.ITestConstants;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest implements ITestConstants {

    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    MyDiaryPage myDiaryPage;
    MoodUpdatedModalPage moodUpdatedModalPage;
    LoginStep loginStep;
    UpdateMoodStep updateMoodStep;
    Dropdown dropdown;
    WorldFeedPage worldFeedPage;
    AvatarPage avatarPage;
    MainPage mainPage;

    /**
     * This method is executed before the test methods.
     */
    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        initPages();
    }

    /**
     * This method executed after test methods and closes browser.
     */
   @AfterMethod
    public void closeBrowser(){
        getWebDriver().quit();
    }

    /**
     * This method inits pages for our project
     */
    public void initPages(){
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        myDiaryPage = new MyDiaryPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
        loginStep =  new LoginStep();
        updateMoodStep = new UpdateMoodStep();
        dropdown = new Dropdown();
        worldFeedPage =  new WorldFeedPage();
        avatarPage = new AvatarPage();
        mainPage = new MainPage();
    }
}
