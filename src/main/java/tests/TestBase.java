package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePageHelper;
import pages.MenuBarHelper;

import java.util.concurrent.TimeUnit;


public abstract class TestBase {

    WebDriver driver = new ChromeDriver();
    public static final String URL = "http://automationpractice.com/index.php";
    public static final String EMAIL = "my@gog.com";
    public static final String PASSWORD = "12345";

    HomePageHelper homePageHelper;
    MenuBarHelper menuBarHelper;

    @BeforeSuite()
    public void initWebDriver() {
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        menuBarHelper = PageFactory.initElements(driver, MenuBarHelper.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        homePageHelper.waitAntilHomePageIsLoaded();
        driver.manage().window().maximize();
    }
 @AfterSuite
    public void closeDriver(){
        driver.quit();
 }

}

