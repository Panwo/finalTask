package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BasePage {

    protected WebDriver driver;
    @FindBy(xpath = "//input[@aria-label='Search']")
    protected WebElement searchField;
    @FindBy(xpath = "//input[@value='Go']")
    protected WebElement searchButton;
    protected String lastQuery;
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    protected WebElement dropdownCategoriesListWithinSearchArea;
    @FindBy(xpath = "//span[contains(@id,'nav-cart-count')]")
    protected WebElement cartIcon;
    @FindBy(xpath = "//a[@id='nav-recently-viewed']")
    protected WebElement recentlyViewedLink;
    @FindBy(xpath = "//a[contains(@data-csa-c-slot-id,'nav_cs_0')]")
    protected WebElement customerServiceLink;
    @FindBy(xpath = "//div[@class='s-suggestion']")
    public List<WebElement> suggestionsDropdown;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }



    protected void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void scrollToTheElement(WebElement element) {
        int coordinate = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + coordinate + ")");
    }

    public void clearSearchFieldAndInsertText(String query) {
        searchField.clear();
        searchField.sendKeys(query);
        this.lastQuery = query;
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public String getLastQuery() {
        return lastQuery;
    }

    public void setLastQuery(String lastQuery) {
        this.lastQuery = lastQuery;
    }

    public void verifyURL(String URL) {
        driver.getCurrentUrl().contains(URL);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void expandCategoriesWithinSearchField() {
        dropdownCategoriesListWithinSearchArea.click();
    }

    public void selectCategoryByNumber(int categoryNumber) {
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[" + categoryNumber + "]")).click();
    }


    public void waitForDropdownVisibility() {
        waitVisibilityOfElement(300, suggestionsDropdown.get(0));
    }

    public void verifyDropdownSearchResults() {
        for (WebElement webElement : suggestionsDropdown) {
            if (!webElement.getText().toLowerCase().contains(lastQuery))
                return;
        }
    }

    public void clickRecentlyViewedLink() {
        recentlyViewedLink.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickCustomerServiceLink() {
        customerServiceLink.click();
    }

}
