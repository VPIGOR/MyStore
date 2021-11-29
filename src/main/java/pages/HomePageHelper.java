package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#home-page-tabs")
    WebElement homePageTab;




    public HomePageHelper waitAntilHomePageIsLoaded(){
        waitUntilElementIsVisable(homePageTab,5);
        return this;
    }

}
