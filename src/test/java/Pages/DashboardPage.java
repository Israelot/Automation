package Pages;

import BaseClass.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static BaseClass.TestBase.testData;

public class DashboardPage extends PageBase {
    public DashboardPage(WebDriver driver) { super(driver); }


    @FindBy(xpath = "//body/app-root[1]/div[1]/app-pages[1]/div[1]/div[1]/app-sidebar[1]/div[2]/div[2]/ul[1]/li[6]/div[1]/a[1]")
    public WebElement customerCareDropDown;
    @FindBy (xpath = "//body/app-root[1]/div[1]/app-pages[1]/div[1]/div[1]/app-sidebar[1]/div[2]/div[2]/ul[1]/li[6]/div[2]/ul[1]/li[1]/div[1]")
    public WebElement msisdnActivity;
    @FindBy (xpath = "//body/app-root[1]/div[1]/app-pages[1]/div[1]/div[1]/div[1]/app-customer-care[1]/app-add-customer-care[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
    public WebElement numberInputField;
    @FindBy (xpath = "//input[@id='flexSwitchCheck']")
    public WebElement testNumberToggle;
    @FindBy (xpath = "//body/app-root[1]/div[1]/app-pages[1]/div[1]/div[1]/div[1]/app-customer-care[1]/app-add-customer-care[1]/div[1]/form[1]/div[3]/div[1]/app-im-button-template[1]/button[1]")
    public WebElement getDetails;


    public void clickCustomerCareDropDown(){
        click(customerCareDropDown);
    }
    public void clickMSISDNActivity(){
        click(msisdnActivity);
    }
    public void inputNumberField(){
        enterText(numberInputField, testData.getProperty("MSISDN"));
    }
    public void clickTestNumberToggle(){
        click(testNumberToggle);
    }
    public void clickGetDetails(){
        click(getDetails);
    }

    public void setWebPage(){
        clickCustomerCareDropDown();
        clickMSISDNActivity();
    }
    public void setWebDashboard() throws IOException, InterruptedException {
        inputNumberField();
        clickTestNumberToggle();
        Thread.sleep(3000);
        clickGetDetails();
        Thread.sleep(3000);
        takeWebScreenshot("ScreenShot to validate WebDashboard set");
    }
}
