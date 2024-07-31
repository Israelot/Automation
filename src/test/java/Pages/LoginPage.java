package Pages;

import BaseClass.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static BaseClass.TestBase.testData;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver){super(driver);
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//input[@id='crendential-input']")
    public WebElement userNameField;
    @FindBy(xpath = "//input[@id='password-input']")
    public WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    public WebElement submitBTN;

    public void enterUserName(String userName) {
        waitForElement(userNameField, 40);
        enterText(userNameField, userName );
    }
    public void enterPassWord(String passWord) {
        enterText(passwordField, passWord);
    }
    public void clickLoginBtn() {
        click(submitBTN);
    }

    public void loginToImonitor(){
        enterUserName(testData.getProperty("userName"));
        enterPassWord(testData.getProperty("passWord"));
        clickLoginBtn();
    }
}
