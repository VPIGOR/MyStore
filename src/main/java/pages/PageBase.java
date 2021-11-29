package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public PageBase waitUntilElementIsClickabl(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public PageBase waitUntilElementIsVisable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getPagTitle() {
        return driver.getTitle();
    }

}