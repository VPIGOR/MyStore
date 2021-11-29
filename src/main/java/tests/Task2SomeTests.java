package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageHelper;
import pages.MyAccountPageHelper;

public class Task2SomeTests extends TestBase {

    LoginPageHelper loginPageHelper;
    MyAccountPageHelper myAccountPageHelper;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        loginPageHelper = PageFactory.initElements(driver, LoginPageHelper.class);
        myAccountPageHelper = PageFactory.initElements(driver, MyAccountPageHelper.class);
        menuBarHelper.clickSingInButton();
        loginPageHelper
                .waitLoginPageIsLoad()
                .enterRegisteredEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressSingInButton();
    }
    @AfterMethod(alwaysRun = true)
    public void logOut() {
        menuBarHelper.clickLogOutButton();
    }

    @Test
    public void LogInTest() {
        Assert.assertEquals(myAccountPageHelper.getPagTitle(), "My account - My Store");
    }

    @Test
    public void addItemToTheCart() {
        myAccountPageHelper.addItemToCart();
        String massage = myAccountPageHelper.chekAddedTitle();
        myAccountPageHelper.closeAdededWindow();
        Assert.assertEquals("Product successfully added to your shopping cart",massage);
    }

    @Test
    public void removeItemFromCart(){
        myAccountPageHelper
                .addItemToCart()
                .closeAdededWindow();
        menuBarHelper.removeItemFromCart();
        Assert.assertTrue(menuBarHelper.isCartEmpty());
    }
}
