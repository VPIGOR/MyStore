package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SupportPageHelper;

public class Task1ServisePageTests extends TestBase {

    SupportPageHelper supportPageHelper;

    private String filePath = "C:\\Users\\Igor\\Desktop\\file1.txt";

    @BeforeMethod
    public void init() {
        supportPageHelper = PageFactory.initElements(driver, SupportPageHelper.class);
    }

    @Test
    public void sendMassageToSupport() {
        menuBarHelper.clickContactUsButton();
        supportPageHelper
                .waitAntilSupportPageIsLoaded()
                .choiceCustomerService()
                .fillEmailField(EMAIL)
                .uploadFile(filePath)
                .fillMessageField("hello")
                .sendTheMessage();
    }
}
