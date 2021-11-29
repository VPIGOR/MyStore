package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class SupportPageHelper extends PageBase {

    public SupportPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#submitMessage")
    WebElement sendMessageButton;
    @FindBy(css = "#id_contact")
    WebElement subjectHeadingField;
    @FindBy(css = ".validate")
    WebElement emailFild;
    @FindBy(css = "#fileUpload")
    WebElement uploadFile;
    @FindBy(xpath = "//textarea[@id = 'message']")
    WebElement messageField;


    public SupportPageHelper sendTheMessage() {
        sendMessageButton.click();
        return this;
    }

    public SupportPageHelper fillMessageField(String text) {
        messageField.click();
        messageField.sendKeys(text);
        return this;
    }

    public SupportPageHelper uploadFile(String filePath) {
        uploadFile.sendKeys(filePath);
        return this;
    }

    public SupportPageHelper fillEmailField(String email) {
        emailFild.sendKeys(email);
        return this;
    }

    public SupportPageHelper choiceCustomerService() {
        Select select = new Select(subjectHeadingField);
        select.selectByIndex(1);
        return this;
    }

    public SupportPageHelper waitAntilSupportPageIsLoaded() {
        waitUntilElementIsClickabl(sendMessageButton, 5);
        return this;
    }
}
