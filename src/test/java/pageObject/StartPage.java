package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    public static final String locationButtonSelector = "[class='location-selector__button']";
    public static final String ukraineEnglishSelector = "//*[text() = 'Ukraine/English' and @class='location-selector__link']";

    public StartPage (WebDriver driver) {
            PageFactory.initElements(driver, this);
    }

        @FindBy(css = locationButtonSelector)
        public WebElement locationButton;

        @FindBy(xpath = ukraineEnglishSelector)
        public WebElement ukraineEnglish;

}
