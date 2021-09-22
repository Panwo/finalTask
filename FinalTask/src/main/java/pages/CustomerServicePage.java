package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerServicePage extends BasePage {

    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Your Orders')]")
    private WebElement yourOrdersElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Returns & Refunds')]")
    private WebElement returnsAndRefundsElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Get Product Help')]")
    private WebElement getProductHelpElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Digital Services and Device Support')]")
    private WebElement digitalServicesAndDeviceElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Manage Prime')]")
    private WebElement managePrimeElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Payments & Gift Cards')]")
    private WebElement paymentsAndGifCardsElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Your Account')]")
    private WebElement yourAccountElement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Amazon and COVID-19')]")
    private WebElement amazonAndCovid19lement;
    @FindBy(xpath = "//h3[@class='a-spacing-none a-text-normal'][contains(.,'Safe Online Shopping')]")
    private WebElement safeOnlineShoppingElement;
    @FindBy(xpath = "//input[contains(@name,'help_keywords')]")
    private WebElement searchTheHelpLibraryElement;


    public CustomerServicePage(WebDriver driver) {
        super(driver);
    }

    public void verifyElementsPresence(String username) {

        yourOrdersElement.isDisplayed();
        returnsAndRefundsElement.isDisplayed();
        getProductHelpElement.isDisplayed();
        digitalServicesAndDeviceElement.isDisplayed();
        managePrimeElement.isDisplayed();
        paymentsAndGifCardsElement.isDisplayed();
        yourAccountElement.isDisplayed();
        amazonAndCovid19lement.isDisplayed();
        safeOnlineShoppingElement.isDisplayed();
        driver.findElement(By.xpath("//h1[contains(.,'We’re here to help, " + username + "')]"));
    }

    public void verifySearchTheHelpLibraryElementPresence() {
        searchTheHelpLibraryElement.isDisplayed();
    }
}
