package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public AddressOperationsPage getAddressOperationPage() {
        return new AddressOperationsPage(driver);
    }
    public CustomerServicePage getCustomerServicePage() {
        return new CustomerServicePage(driver);
    }
    public HomePage getHomePage() {
        return new HomePage(driver);
    }
    public ItemPage getItemPage() {
        return new ItemPage(driver);
    }
    public SearchHistoryPage getSearchHistoryPage() {
        return new SearchHistoryPage(driver);
    }
    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }
    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }
    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }
    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

}
