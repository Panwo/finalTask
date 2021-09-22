package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    private String itemTittle;
    private String quantity;

    @FindBy(xpath = "//span[@class = 'a-truncate-cut']")
    private WebElement itemTitle;

    @FindBy(xpath = "//span[contains(@id,'sc-subtotal-label-activecart')]")
    private WebElement itemCountTitle;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyThatItemTitleCorrect() {
        itemTitle.getText().toLowerCase().contains(itemTittle);
    }

    public void verifyThatItemsCountIsCorrect() {
        itemCountTitle.getText().toLowerCase().contains(quantity);
    }

    public void setItemTittle(String itemTittle) {
        this.itemTittle = itemTittle;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
