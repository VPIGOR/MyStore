package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuBarHelper extends PageBase {

    public MenuBarHelper(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div[id = 'contact-link']>a")
    WebElement contactAsButton;
    @FindBy(css = ".header_user_info>a")
    WebElement singInButton;
    @FindBy(css = ".logout")
    WebElement logOutButton;
    @FindBy(css = ".logo")
    WebElement tShortsButton;
    @FindBy(css = "[title=\"View my shopping cart\"]")
    WebElement cart;
    @FindBy(css = "[class=\"ajax_cart_block_remove_link\"]")
    WebElement cardRemoveItemButton;
    @FindBy(css = ".ajax_cart_no_product")
    WebElement emptyCart;

    public boolean isCartEmpty(){
        if(emptyCart != null) {
            return true;
        }else return false;
    }

    public MenuBarHelper removeItemFromCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-800)");
        Actions builder = new Actions(driver);
        builder
                .moveToElement(cart)
                .perform();
        waitUntilElementIsClickabl(cardRemoveItemButton,5);
        cardRemoveItemButton.click();
        return this;
    }

    public MenuBarHelper goHomePage(){
        tShortsButton.click();
        return this;
    }

    public MenuBarHelper clickLogOutButton(){
        logOutButton.click();
        return this;
    }

    public MenuBarHelper clickSingInButton(){
        singInButton.click();
        return this;
    }

    public MenuBarHelper clickContactUsButton(){
     contactAsButton.click();
        return this;
    }
}
