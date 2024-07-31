package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public String testDataFilePath = "src/test/java/Utils/testdataproperties.properties";
    public static Properties testData = new Properties();
    public static DesiredCapabilities caps;
    ChromeOptions chromeOptions;
    public static WebDriver wDriver;
    public static ExtentReports report;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();
    private static final Logger log = LogManager.getLogger(TestBase.class);


    public TestBase() {
        loadPropFile();
    }

    public void loadPropFile() {
        try (FileInputStream fis = new FileInputStream(testDataFilePath)) {
            testData.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void setup(){
//        log = LogManager.getLogger(TestBase.class);

        chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        wDriver = new ChromeDriver(chromeOptions);
//        wDriver.manage().window().maximize(); // to maximize the chrome window
        String baseUrl = testData.getProperty("baseUrl");
        wDriver.get(baseUrl);
        log.info("Opened WebPage");
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/ExtentReport.html");
        extent.attachReporter(spark);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        if (null != wDriver){
            wDriver.quit();
        }
    }
}

