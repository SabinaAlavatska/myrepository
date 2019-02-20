package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    public static final  String applyButtonSelector = "//*[@class='search-result__list']//*[@class='search-result__item-apply']";

    public SearchResultPage (WebDriver driver) {
            PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = applyButtonSelector)
    public WebElement applyButton;
}
