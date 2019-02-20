package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppliedVacancyPage {
    public static final String textLineSelector = "//*[@class='bullet-list']//*[contains(text(), 'Flexible work hours')]";
    public static final String descriptionTextSelector = "//*[@class='recruiting-page__top-description']";
    public static final String tagName = "h4";

    public AppliedVacancyPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = textLineSelector)
    public WebElement textLine;

    @FindBy(xpath = descriptionTextSelector)
    public WebElement descriptionText;

    @FindBy(tagName = tagName)
    public List<WebElement> headerArray;

}
