package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "button[id = 'SubmitLogin']")
    WebElement submitLoginButton;
    @FindBy(css = "input[id = 'email']")
    WebElement registeredEmailField;
    @FindBy(css = "input[id = 'passwd']")
    WebElement passwordField;

    public LoginPageHelper pressSingInButton(){
        submitLoginButton.click();
        return this;
    }

    public LoginPageHelper enterPassword(String pass){
        passwordField.sendKeys(pass);
        return this;
    }

    public LoginPageHelper enterRegisteredEmail(String email){
        registeredEmailField.sendKeys(email);
        return this;
    }

    public LoginPageHelper waitLoginPageIsLoad(){
        waitUntilElementIsClickabl(submitLoginButton,5);
        return this;
    }
}
