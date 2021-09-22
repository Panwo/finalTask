package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sun.plugin.javascript.navig.JSType.URL;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    WishListPage wishListPage;
    ShoppingCartPage shoppingCartPage;
    SearchHistoryPage searchHistoryPage;
    CustomerServicePage customerServicePage;
    AddressOperationsPage addressOperationsPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    //*first scenario*//
    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openURL(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks header and header critical elements visibility")
    public void checkHeaderAndCriticalElementsVisibility() {
        homePage.checkHeaderAndCriticalElementsVisibility();
    }

    @And("User scrolls down")
    public void checkSearchVisibility() {
        homePage.scrollDown();
    }

    @And("User waits for login button visibility")
    public void userWaitsForLoginButtonVisibility() {
        homePage.waitForLoginButtonVisibility();
    }

    @And("User checks body and body critical elements number {int}")
    public void userChecksBodyAndBodyCriticalElementsVisibility(int number) {
        homePage.waitForBodyVisibility();
        homePage.checkBodyVisibilityAndNumberOfElementsWithin(number);
    }

    @And("User check main content visibility")
    public void userCheckMainContentVisibility() {
        homePage.checkMainContentVisibility();
    }

    @And("User checks footer and footer critical elements visibility")
    public void userChecksFooterAndFooterCriticalElementsVisibility() {
        homePage.checkFooterAndCriticalElementsVisibility();
    }

    @And("User validates login button presence and link accuracy")
    public void userValidatesLoginButtonPresenceAndLinkAccuracy() {
        homePage.validateLoginButtonPresenceAndLinkAccuracy();
    }


    // second scenario
    @And("User clicks Sign In button")
    public void userClicksSignInButton() {
        signInPage = pageFactoryManager.getSignInPage();
        homePage.clickSignIn();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks Create Amazon account button")
    public void clickCreateAmazonAccountButton() {
        signInPage.clickCreateNewAccountButton();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Page {string} page appears with all required fields")
    public void pageNewAccountPageAppearsWithAllRequiredFields(String newAccountPageURL) {
        signInPage.verifyNewAccountPageURLAndFields(URL);
    }

    @And("User navigates back to the login page")
    public void userNavigatesBackToTheLoginPage() {
        signInPage.navigateBack();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User enters valid {string} and click next")
    public void userEntersValidUsernameAndClickNext(String username) {
        signInPage.fillEmailFieldAndContinue(username);
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on the Forgot Password link")
    public void userClicksOnTheForgotPasswordLink() {
        signInPage.clickForgotPasswordLink();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Forgot password {string} page with Email\\/Phone textarea field appears.")
    public void forgotPasswordForgotPasswordPageWithEmailPhoneTextareaFieldAppears(String forgotPasswordURL) {
        signInPage.verifyURL(forgotPasswordURL);
    }

    @And("User clicks navigates back, confirms form re-submitting")
    public void userEnterNavigatesBackConfirmsFormReSubmitting() {
        signInPage.navigateBackAndRefresh();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User enters valid {string} and clicks next")
    public void userEntersValidPasswordAndClicksNext(String password) {
        signInPage.fillPasswordFieldAndContinue(password);
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User finds {string} visible in Account menu")
    public void userFindsLoginVisibleInAccountMenu(String login) {
        homePage.verifyLoginResult(login);

    }

    @And("User enters {string} in the search area")
    public void enterProductsInSearchField(String query) {
        homePage.clearSearchFieldAndInsertText(query);
        homePage.setLastQuery(query);
    }

    @And("User clicks search icon")
    public void clickSearchIcon() throws InterruptedException {
        homePage.clickSearchButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Thread.sleep(2000);
    }

    @And("search result page appears with at least {int} of searched elements")
    public void checkNumberOfElementsOnSearchPage(int numberOfElements) throws InterruptedException {

        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForSearchResultsAppearance();
        searchResultsPage.setLastQuery(homePage.getLastQuery());
        searchResultsPage.checkThatResultPageContainsDefinedResultsNumber(numberOfElements);
    }

    @And("User clicks back, {string} appears")
    public void returnToMainPage(String homePageURL) {
        searchResultsPage.navigateBack();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.verifyURL(homePageURL);
    }

    @And("User types single {string} in the search box")
    public void enterOneCharacter(String character) throws InterruptedException {
        homePage.clearSearchFieldAndInsertText(character);
        homePage.setLastQuery(character);
        Thread.sleep(2000);
    }

    @And("A list of product appears with suggestions starting with the entered character")
    public void checkSearchResultWithOneCharacterEntered() throws InterruptedException {
        homePage.waitForDropdownVisibility();
        homePage.verifyDropdownSearchResults();

    }

    @And("User enters {int} of \"a\" letters from 5000 to 10000")
    public void enterInvalidNumberOfCharacters(int numberOfCharacters) {
        searchResultsPage.insertChartSequence(numberOfCharacters);
        searchResultsPage.clickSearchButton();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("search results page appears along with error message")
    public void checkSearchResultWithInvalidCharactersNumber() {
        searchResultsPage.verifyErrorImagePresence();
    }

    @And("user enters {int} of \"a\" letters from 1 to 600")
    public void enterValidNumberOfCharacters(int numberOfCharacters) {
        searchResultsPage.insertChartSequence(numberOfCharacters);
        searchResultsPage.clickSearchButton();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    //todo fnish the test
    @And("search result page appears without error message")
    public void checkSearchResultWitValidNumberOfCharacters() {
        searchResultsPage.verifyErrorImageAbsence();
    }

    @And("ser clicks \"all\" button")
    public void expandAllCategories() {
        searchResultsPage.expandCategoriesWithinSearchField();
    }

    @And("categories appear with total {int} of categories")
    public void checkNumberOfCategories(int numberOfCategories) {

    }


    @And("User expands categories within search field, selecting the {int}")
    public void selectCategory(int categoryNumber) {
        homePage.expandCategoriesWithinSearchField();
        homePage.selectCategoryByNumber(categoryNumber);
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
    }

    @And("User click in the image of the first result in the search list result page")
    public void clickOnTheFirstResultImage() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnTheFirstElementInTheSearchPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemPage = pageFactoryManager.getItemPage();
    }

    @And("User clicks Add to List button in the item page")
    public void addToList() {
        itemPage.clickAddToWishListButton();
        itemPage.waitForWishListReviewButtonToAppear(DEFAULT_TIMEOUT);
    }

    @And("User clicks View Your List button  in the Add to List page")
    public void clickViewYourListButton() {
        itemPage.clickReviewWishListButton();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage = pageFactoryManager.getWishListPage();
    }

    @And("My wish list, should be populated with the {string} item")
    public void verifyMyWishListContainsProduct(String product) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        wishListPage.checkThatWishedItemContainsKeyWord(product);
        shoppingCartPage.setItemTittle(product);
    }

    //fifth scenario

    @And("User enters {string} in the search box")
    public void enterProductsInSearchBox(String query) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        homePage.clearSearchFieldAndInsertText(query);
        shoppingCartPage.setItemTittle(query);
    }

    @And("User selects the product quantity as {string} in a range from 2 to 30")
    public void selectProductsQuantity(String quantity) {

        itemPage.expandQuantityList();
        itemPage.selectQuantity(quantity);
        shoppingCartPage.setQuantity(quantity);
    }

    @And("User clicks add to cart on the page on product details page")
    public void clickAddToCart() {
        itemPage.clickAddToCart();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Products are added to the cart")
    public void verifyNumberOfProductsAndProductTittleInCart() {
        itemPage.clickCartIcon();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.verifyThatItemTitleCorrect();
        shoppingCartPage.verifyThatItemsCountIsCorrect();
    }


    @And("User expands sortBy selector")
    public void expandSortBySelector() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.expandSortingSelector();
    }

    @And("User selects high to low")
    public void selectSortingOrder() {
        searchResultsPage.selectSortingOrder();
    }

    @And("Search result page displays descending price result, check at least {int} of results")
    public void verifyResult(int number) {
        searchResultsPage.verifySortingOrderWithDefinedNumberOfItems(number);
    }

    @And("User clicks  Browsing history link")
    public void clickBrowserHistoryLink() {
        itemPage.clickRecentlyViewedLink();
    }

    @And("Users is able to see two products")
    public void verifySearchHistoryResults() {
        searchHistoryPage = pageFactoryManager.getSearchHistoryPage();

    }

    @And("User clicks Deliver to icon")
    public void clickDeliverToIcon() {
        homePage.clickDeliveryIcon();
    }

    @And("User clicks Manage address book link")
    public void clickManageAddressBookLink() {
        homePage.waitForAddressManagementLinkVisibility();
        homePage.clickManageAddressBookLink();
    }

    @And("User clicks add address")
    public void clickAddNewAddress() {
        addressOperationsPage = pageFactoryManager.getAddressOperationPage();
        addressOperationsPage.clickAddNewShippingAddressButton();
    }

    @And("User fills valid {string} phone number")
    public void fillValidPhoneNumberOnAddressPage(String phoneNumber) {
        addressOperationsPage.fillPhoneNumberOnAddressPage(phoneNumber);
    }

    @And("User fills valid {string} address")
    public void fillValidAddress(String deliveryAddress) {
        addressOperationsPage.fillShippingAddress(deliveryAddress);

    }

    @And("User fills valid {string} city")
    public void fillValidCity(String shippingCity) {
        addressOperationsPage.enterShippingCity(shippingCity);

    }

    @And("User selects corresponding {string}")
    public void selectCorrespondingDeliveryState(String state) {
        addressOperationsPage.expandStateSelector();
        addressOperationsPage.selectCorrespondingState(state);
    }

    @And("User fills corresponding {string}")
    public void enterCorrespondingZipCode(String ZIPCode) {
        addressOperationsPage.enterCorrespondingZIPCode(ZIPCode);
    }

    @And("User clicks add address form button")
    public void clickAddNewShippingAddress() {
        addressOperationsPage.submitNewAddressAdditionForm();
        addressOperationsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("New {string} appears in the addresses list")
    public void verifyThatNewShippingAddressAppearsOnAddressesPage(String newAddress) {
        addressOperationsPage.verifyThatNewAddressAdded(newAddress);
    }


    @And("User clicks Customer service link")
    public void clickCustomerServiceLink() {
        homePage.clickCustomerServiceLink();
    }

    @And("User sees nine categories within the page body and text : We’re here to help, {string}")
    public void verifyCustomerServiceElementsPresence(String username) {
        customerServicePage = pageFactoryManager.getCustomerServicePage();
        customerServicePage.verifyElementsPresence(username);
    }

    @And("User sees help library search area")
    public void verifyHelpLibrarySearchAreaPresence() {
        customerServicePage.verifySearchTheHelpLibraryElementPresence();
    }



    @And("User sets customer reviews filter to 4 stars and up")
    public void setReviewsFilterToFourStarsAndUp() {
        //todo remove pagefactory from here
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.selectMostReviewedItemsFilter();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Product page appears, review section is not empty")
    public void verifyThatReviewsSectionIsNotEmpty() {
        itemPage.verifyThatReviewsSectionIsNotEmpty();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
