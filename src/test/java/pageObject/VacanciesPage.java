package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPage {
    public static final String vacanciesButtonSelector = "//*[text() = 'Vacancies' and @class='top-navigation__item-link']";

    public VacanciesPage (WebDriver driver){
            PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = vacanciesButtonSelector)
    public WebElement vacanciesButton;
}
