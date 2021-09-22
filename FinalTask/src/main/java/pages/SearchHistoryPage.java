package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchHistoryPage extends BasePage {

    @FindBy(xpath = "//div[@id='asin_list']")
    private List<WebElement> searchedItems;


    public SearchHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void verifyThatSearchedItemsListIsNotEmpty() {
        checkSearchedList();
    }

    private boolean checkSearchedList() {
        if (searchedItems.isEmpty()) return false;
        else return true;
    }
}
