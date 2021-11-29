package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPageHelper extends PageBase {

    public MyAccountPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'My account ')]")
    WebElement titleMyAccoutPage;
    @FindBy(css = "ul[class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows'] > li")
    List<WebElement> menu;
    @FindBy(css = "[title=\"Add to cart\"]")
    WebElement addToCartButton;
    @FindBy(css = ".cross")
    WebElement xButton;
    @FindBy(xpath = "//i[@class='icon-ok']/parent::h2")
    WebElement successMesage;

    public MyAccountPageHelper addItemToCart() {
        menu.get(2).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        Actions builder = new Actions(driver);
        builder
                .moveToElement(driver.findElement(By.className("product-container")))
                .perform();
        waitUntilElementIsClickabl(addToCartButton, 5);
        addToCartButton.click();
        waitUntilElementIsClickabl(xButton, 5);
        return this;
    }

    public MyAccountPageHelper closeAdededWindow() {
        xButton.click();
        return this;
    }

    public String chekAddedTitle() {
        return successMesage.getText();
    }

    public MyAccountPageHelper waitPageLoad() {
        waitUntilElementIsVisable(titleMyAccoutPage, 5);
        return this;
    }
}
