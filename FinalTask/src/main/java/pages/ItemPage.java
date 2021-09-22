package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemPage extends BasePage {
    @FindBy(xpath = "//input[contains(@title,'Add to List')]")
    private WebElement addToListButton;
    @FindBy(xpath = "//span[@class='w-button-text'][contains(.,'View Your List')]")
    private WebElement viewListButton;
    @FindBy(xpath = "//span[@class='a-dropdown-label'][contains(.,'Qty:')]")
    private WebElement quantitySelector;
    @FindBy(xpath = "//input[@name='submit.add-to-cart']")
    private WebElement addToCart;
    @FindBy(xpath = "//div[@class='a-section review aok-relative']")
    private List<WebElement> reviewsSection;


    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToWishListButton() {
        addToListButton.click();
    }

    public void clickReviewWishListButton() {
        viewListButton.click();
    }

    public void waitForWishListReviewButtonToAppear(long timeToWait) {
        waitVisibilityOfElement(timeToWait, viewListButton);
    }

    public void expandQuantityList() {
        quantitySelector.click();
    }

    public void selectQuantity(String quantity) {
        int integerQuantity = Integer.parseInt(quantity);
        integerQuantity--;
        driver.findElement(By.xpath("//a[@id='quantity_" + integerQuantity + "']")).click();
    }

    public void scrollToReviewsSection() {
        scrollToTheElement(reviewsSection.get(0));
    }

    public void verifyThatReviewsSectionIsNotEmpty() {
        verifyReviewsSectionElementLength();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void waitForWishListPopUpToAppear() {
        waitVisibilityOfElement(30, viewListButton);
    }

    private boolean verifyReviewsSectionElementLength() {
        if (reviewsSection.size() > 0) return true;
        else return false;
    }


}
