package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorldFeedPage {

    public static final String BUTTON_HUG_WORLD_FEED_PAGE_CSS = ".ButtonHug";
    public static final String COMMENT_HUG_CSS = ".label.label-hug";
    public static final String COMMENT_FIELD_CSS = "#mcr1";
    public static final String REPLY_BUTTON_CSS = ".input-group-btn";
    public static final String TEXT_OF_THE_COMMENT_CSS = ".media-body-comment-tag p";


    /**
     * This method sends hugs to someone.
      * @return WorldFeedPage
     */
    public WorldFeedPage sendSomeoneAHug(){
        $$(BUTTON_HUG_WORLD_FEED_PAGE_CSS).get(0).click();
        return this;
    }

    /**
     * This method gets text of the hug
     * @return text of the hug
     */
    public String getHugText() {
        return $(COMMENT_HUG_CSS).getText();
    }

    /**
     * This method sends someone a comment
     * @return WorldFeedPage
     */
    public WorldFeedPage sendSomeoneAComment(){
        $(COMMENT_FIELD_CSS).sendKeys("Have a good day!=)");
        $$(REPLY_BUTTON_CSS).get(0).click();
        return this;
    }

    /**
     * This method gets text of the comment
     * @return text of the comment
     */
    public String getCommentText() {
        return $$(TEXT_OF_THE_COMMENT_CSS).get(0).getText();
    }
}
