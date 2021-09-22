package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//a[contains(@id,'itemName')]")
    private WebElement wishListItem;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public void checkThatWishedItemContainsKeyWord(String product) {
        checkKeyWord(product);
    }

    private boolean checkKeyWord(String product) {
        return wishListItem.getText().toLowerCase().contains(product);
    }

}
