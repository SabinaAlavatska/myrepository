import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.pickles.PickleRow;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {
    private static final String jsCommand = "return document.readyState";
    private static final String complete = "complete";
    private static final String driverName = "webdriver.chrome.driver";
    private static final String pathToDriver = "/src/test/chromedriver";
    public static final String userDir = "user.dir";
    private WebDriver driver;
    WebDriverWait wait;

    public Steps(){
        System.setProperty(driverName, System.getProperty(userDir) + pathToDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    StartPage startPage;
    VacanciesPage vacanciesPage;
    JobSearchPage jobSearchPage;
    SearchResultPage searchResultPage;
    AppliedVacancyPage appliedVacancyPage;

    @Given("^User is not an EPAM employee.$")
    public void doNothing(){
    }

    @When("^User go to website '(.*)'.$")
    public void navigateToWebSite(String webSite){
        driver.get(webSite);
    }

    @When("^User select region '(.*)' at location dropdown.$")
    public void selectRegion(String location){
        startPage = new StartPage(driver);
        startPage.locationButton.click();
        startPage.ukraineEnglish.click();
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript(jsCommand).equals(complete));
    }

    @When("^User go to '(.*)' tab.$")
    public void selectTab(String tabName){
        vacanciesPage = new VacanciesPage(driver);
        vacanciesPage.vacanciesButton.click();
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript(jsCommand).equals(complete));
    }

    @When("^User fill the search field '(.*)' with value '(.*)'.$")
    public void fillSearchField(String fieldName, String fieldKeys){
        jobSearchPage = new JobSearchPage(driver);
        jobSearchPage.keywordsField.sendKeys(fieldKeys);
    }

    @When("^User select location '(.*)' from location dropdown.$")
    public void pickOptionInLocationDropdown(String dropdownOption){
        jobSearchPage.locationSelectField.click();
        jobSearchPage.dropdownKyiv.click();
    }

    @When("^User tick '(.*)' in '(.*)' dropdown.$")
    public void pickOptionInSkillsDropdown(String skillsDropdownOprion, String dropdownName){
        jobSearchPage.skillsField.click();
        jobSearchPage.steOption.click();
    }

    @When("^User click '(.*)' button.$")
    public void clickFindButton (String buttonName){
        jobSearchPage.findButton.click();
    }

    @When("^User sees list of job openings related to above criteria.$")
    public void     doNothing2 (){
    }

    @When("^User select first vacancy and click 'Apply' button.$")
    public void applyToVacancy (){
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.applyButton.click();
    }

    @Then("^User sees description of selected vacancy.$")
    public void getDescriptionText (){
        appliedVacancyPage = new AppliedVacancyPage(driver);
        String descriptionText = appliedVacancyPage.descriptionText.getText();
        Assert.assertTrue("Vacancy description is not displayed", !descriptionText.equals(""));
    }

    @Then("^User sees next blocks:$")
    public void checkHeaders(DataTable dataTable){
        List<String> expectedHeaders = new ArrayList<>();
        for (int i = 0; i < dataTable.getPickleRows().size(); i++) {
            PickleRow row = dataTable.getPickleRows().get(i);
            String header = row.getCells().get(0).getValue();
            expectedHeaders.add(header);
        }
        List<String> actualHeaders = new ArrayList<>();
        for (WebElement webElement : appliedVacancyPage.headerArray) {
            String header = webElement.getText();
            actualHeaders.add(header);
            System.out.println(header);
        }
    Assert.assertEquals("Headers on WebPage are not as expected", expectedHeaders, actualHeaders);
    }

    @Then("^User sees item '(.*)' at '(.*)' block$")
    public void getTextLine (String textLine, String blockName){
        boolean isTextLineElementDisplayed = appliedVacancyPage.textLine.isDisplayed();
        Assert.assertTrue("Textline on WebPage is  not displayed", isTextLineElementDisplayed);
    }
}
