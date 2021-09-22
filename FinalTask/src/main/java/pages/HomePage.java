package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='nav-belt']")
    private WebElement header;
    @FindBy(xpath = "//a[@class='nav-a nav-a-2 a-popover-trigger a-declarative nav-progressive-attribute'][contains(.,'Deliver to')]")
    private WebElement deliverOption;
    @FindBy(xpath = "//input[contains(@name,'field-keywords')]")
    private WebElement searchField;
    @FindBy(xpath = "//div[@id='nav-main']")
    private WebElement lowerHeader;
    @FindBy(xpath = "//div[contains(@id,'gw-card-layout')]")
    private WebElement body;
    @FindBy(xpath = "//div[contains(@class,'a-spacing-large')]")
    private WebElement mainContent;
    @FindBy(xpath = "//div[@class='navLeftFooter nav-sprite-v1']")
    private WebElement footer;
    @FindBy(xpath = "//a[@class='action-button']")
    private WebElement footerSignInButton;
    @FindBy(xpath = "//a[contains(.,'Interest-Based Ads')]")
    private WebElement lastElement;
    @FindBy(xpath = "//span[contains(.,'Account & Lists')]")
    private WebElement headerSignInButton;
    @FindBy(xpath = "//span[contains(@id,'nav-global-location-data-modal-action')]")
    private WebElement deliveryIcon;
    @FindBy(xpath = "//a[@role='navigation'][contains(.,'Manage address book')]")
    private WebElement manageAddressBookLink;

    private final String[] footerCriticalElements = new String[]
            {
                    "Help", "Your Orders", "Returns & Replacements",
                    "Amazon Assistant", "Careers", "Host an Amazon Hub"};


    public void openURL(String URL) {
        driver.get(URL);
    }

    public void checkHeaderAndCriticalElementsVisibility() {
        header.isDisplayed();
        deliverOption.isDisplayed();
        searchField.isDisplayed();
        lowerHeader.isDisplayed();
    }

    public void checkBodyVisibilityAndNumberOfElementsWithin(int number) {
        body.isDisplayed();
        checkNumberOfElements(body, number);
    }

    public void checkFooterAndCriticalElementsVisibility() {
        footer.isDisplayed();
        checkCriticalElementsPresence(footer);

    }

    public void checkMainContentVisibility() {
        mainContent.isDisplayed();
    }

    public boolean checkNumberOfElements(WebElement element, int requiredNumber) {
        if (element.getText().split("\n").length > requiredNumber) return true;
        else return false;
    }

    public boolean checkCriticalElementsPresence(WebElement element) {
        List<String> elementsText = Arrays.asList(element.getText().split("\n"));
        for (String string : footerCriticalElements) {
            if (!elementsText.contains(string))
                return false;
        }
        return true;
    }

    public void clickSignIn() {
        headerSignInButton.click();
    }

    public void clickDeliveryIcon() {
        deliveryIcon.click();
    }

    public void clickManageAddressBookLink() {
        manageAddressBookLink.click();
    }

    public void verifyLoginResult(String accountName) {
        headerSignInButton.getText().contains(accountName);
    }

    public void validateLoginButtonPresenceAndLinkAccuracy() {
        footerSignInButton.isDisplayed();
        footerSignInButton.getAttribute("href").contains("www.amazon.com/ap/signin");
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void scrollDown() {
        scrollToTheElement(lastElement);
    }

    public void waitForLoginButtonVisibility() {
        waitVisibilityOfElement(10, footerSignInButton);
    }

    public void waitForBodyVisibility() {
        waitVisibilityOfElement(30, body);
    }

    public void waitForAddressManagementLinkVisibility() {
        waitVisibilityOfElement(30, manageAddressBookLink);
    }


}
