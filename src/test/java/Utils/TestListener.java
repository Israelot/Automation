package Utils;//package Utils;
//
//import BaseClass.PageBase;
//import BaseClass.TestBase;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//
//import static BaseClass.TestBase.extent;
//import static BaseClass.TestBase.reporter;
//
//public class TestListener extends PageBase {
//   ;
//
//    public TestListener(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        String failedTest = iTestResult.getName();
//
//        takeScreenshot(failedTest);
//
//        extent.attachReporter(reporter);
//        extent.createTest(failedTest)
//                .log(Status.FAIL,"test failure");
//        extent.flush();
//    }
//}
