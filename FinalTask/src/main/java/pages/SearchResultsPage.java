package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> searchResultsListTittles;
    @FindBy(xpath = "//img[contains(@alt, 'Sorry!')]")
    private WebElement searchResultErrorImage;
    @FindBy(xpath = "//img[@data-image-index='1']")
    private WebElement firstElementOnTheSearchPage;
    @FindBy(xpath = "//span[@class='a-dropdown-label'][contains(.,'Sort by:')]")
    private WebElement sortBySelector;
    @FindBy(xpath = "//a[contains(.,'Price: High to Low')]")
    private WebElement highToLowSortingOption;
    @FindBy(xpath = "//span[contains(@class,'a-price-whole')]")
    private List<WebElement> searchResultListPrices;
    @FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4'][contains(.,'4 Stars & Up')]")
    private WebElement fourStarsAndUpRaiting;
    @FindBy(xpath = "//div[@class='s-desktop-width-max s-desktop-content s-opposite-dir sg-row']")
    private WebElement searchResultsContainer;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void checkThatResultPageContainsDefinedResultsNumber(int number) {
        verifyNumberOfResults(number);
    }

    public void insertChartSequence(int numberOfLetters) {
        String query = StringUtils.repeat("a", numberOfLetters);
        clearSearchFieldAndInsertText(query);
    }

    public void verifyErrorImagePresence() {
        searchResultErrorImage.isDisplayed();
    }

    public void verifyErrorImageAbsence() {
        sortBySelector.isDisplayed();
    }

    public void clickOnTheFirstElementInTheSearchPage() {
        firstElementOnTheSearchPage.click();
    }

    private boolean verifySort() {
        List<Double> newList = searchResultListPrices.stream()
                .map(s -> Double.parseDouble(s.getText().replaceAll(",", "")))
                .collect(Collectors.toList());

        System.out.println(newList);
        return true;
    }

    public void verifySortingOrderWithDefinedNumberOfItems(int numberOfElements) {
        verifySort();
    }

    public void expandSortingSelector() {
        sortBySelector.click();
    }

    public void selectSortingOrder() {
        highToLowSortingOption.click();
    }

    public void waitForSearchResultsAppearance() {
        waitVisibilityOfElement(30, searchResultsContainer);
    }

    public void selectMostReviewedItemsFilter() {
        fourStarsAndUpRaiting.click();
    }

    private boolean verifyNumberOfResults(int number) {

        for (int i = 0; i < number; i++) {
            if (!searchResultsListTittles.get(i).getText().toLowerCase().contains(lastQuery)) return false;
        }
        return true;
    }


}
