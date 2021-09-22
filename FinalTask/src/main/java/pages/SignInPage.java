package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;

public class SignInPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class,'a-button-text')]")
    private WebElement createNewAccountButton;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[contains(@name,'email')]")
    private WebElement emailField;
    @FindBy(xpath = "//input[contains(@name,'password')]")
    private WebElement passwordField;
    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement signInButton;
    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@name='passwordCheck']")
    private WebElement reEnterPasswordField;
    @FindBy(xpath = "//a[contains(.,'Forgot your password?')]")
    private WebElement forgotPasswordLink;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void setCreateNewAccountButton() {
        continueButton.click();
    }

    public void clickCreateNewAccountButton() {
        createNewAccountButton.click();
    }

    public void navigateBackAndRefresh() {
        navigateBack();
        refreshPage();
    }

    public void verifyNewAccountPageURLAndFields(String URL) {
        verifyURL(URL);
        nameField.isDisplayed();
        emailField.isDisplayed();
        passwordField.isDisplayed();
        reEnterPasswordField.isDisplayed();
        continueButton.isDisplayed();
    }

    public void fillEmailFieldAndContinue(String username) {
        emailField.sendKeys(username);
        continueButton.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void fillPasswordFieldAndContinue(String password) {
        passwordField.sendKeys(password);
        continueButton.click();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
