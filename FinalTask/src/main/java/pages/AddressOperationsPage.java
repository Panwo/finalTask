package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressOperationsPage extends BasePage {
    @FindBy(xpath = "//div[@class='a-section a-spacing-none address-plus-icon aok-inline-block']")
    private WebElement addNewAddressButton;
    @FindBy(xpath = "//span[contains(@class,'a-button-text a-declarative')]")
    private WebElement countrySelector;
    @FindBy(xpath = "//input[contains(@name,'address-ui-widgets-enterAddressPhoneNumber')]")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[contains(@name,'address-ui-widgets-enterAddressLine1')]")
    private WebElement addressField;
    @FindBy(xpath = "//input[contains(@autocomplete,'address-ui-widgets-enterAddressCity')]")
    private WebElement cityField;
    @FindBy(xpath = "//span[@class='a-button-text a-declarative'][contains(.,'Select')]")
    private WebElement stateSelector;
    @FindBy(xpath = "//input[contains(@name,'address-ui-widgets-enterAddressPostalCode')]")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[contains(@class,'a-button-input')]")
    private WebElement addAddressButton;
    @FindBy(xpath = "//div[@class='a-section address-section-no-default']")
    private WebElement additionalAddressBox;



    public void clickAddNewShippingAddressButton (){
       addNewAddressButton.click();
    }

    public void submitNewAddressAdditionForm () {
        addAddressButton.click();
    }

    public void fillShippingAddress (String address) {
        addressField.sendKeys(address);
    }

    public void fillPhoneNumberOnAddressPage (String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterShippingCity (String city) {
        cityField.sendKeys(city);
    }

    public void expandStateSelector () {
        stateSelector.click();
    }

    public void selectCorrespondingState (String state) {
        driver.findElement(By.xpath("//a[contains(.,'"+ state + "')]")).click();
    }

    public void enterCorrespondingZIPCode(String ZIPCode) {
        zipCodeField.sendKeys(ZIPCode);
    }

    public void verifyThatNewAddressAdded (String newAddress) {
        verifyNewAddress(newAddress);
    }


    private boolean verifyNewAddress (String newAddress) {
       if (additionalAddressBox.getText().contains(newAddress)) return true;
       else return false;
    }



    public AddressOperationsPage(WebDriver driver) {
        super(driver);
    }


}
