package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobSearchPage {
    public static final String keyword = "Java";
    public static final String keywordsFieldSelector = "[class='recruiting-search__input js-autocomplete']";
    public static final String locationSelectFieldSelector = "//*[@class='recruiting-search__location']/span";
    public static final String locationSelector = "select[name='location']";
    public static final String dropdownKyivSelector = "//*[@class='select2-results__option dropdown-cities']//*[text() = 'Kyiv']";
    public static final String skillsFieldSelector = "[class='default-label']";
    public static final String steOptionSelector = "//*[@class='checkbox-custom-label' and contains(text(),'Software Test Engineering')]";
    public static final String findButtonSelector = "[class='recruiting-search__submit']";

    public JobSearchPage (WebDriver driver){
            PageFactory.initElements(driver, this);
    }
    @FindBy (css = keywordsFieldSelector)
    public WebElement keywordsField;

    @FindBy (xpath = locationSelectFieldSelector)
    public WebElement locationSelectField;

    @FindBy (css = locationSelector)
    public WebElement location;

    @FindBy (xpath = dropdownKyivSelector)
    public WebElement dropdownKyiv;

    @FindBy (css = skillsFieldSelector)
    public WebElement skillsField;

    @FindBy (xpath = steOptionSelector)
    public WebElement steOption;

    @FindBy (css = findButtonSelector)
    public WebElement findButton;
}
