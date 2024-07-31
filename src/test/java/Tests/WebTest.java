package Tests;

import BaseClass.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    public void initializer(){
        loginPage = new LoginPage(wDriver);
        dashboardPage = new DashboardPage(wDriver);
    }

    @Test(priority = 1)
    public void LoginToWebPage() throws IOException, InterruptedException {
        test = extent.createTest("Validate User can login to WebPage ");
        initializer();
        loginPage.loginToImonitor();
        dashboardPage.setWebPage();
        dashboardPage.setWebDashboard();
        extent.flush();
    }
}
