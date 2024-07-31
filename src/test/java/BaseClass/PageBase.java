package BaseClass;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import static BaseClass.TestBase.test;

public class PageBase {

    protected WebDriver wDriver;

    protected WebDriverWait wait;

    private int webScreenshotCounter = 0;


    public PageBase(WebDriver driver) {
        this.wDriver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Initialize WebDriverWait for WebDriver
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement el, long timeoutInSeconds) {
        this.wait = new WebDriverWait(wDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void click(WebElement el) {
        waitForElement(el, 40);
        el.click();
    }

    public void enterText(WebElement el, String text) {
        waitForElement(el, 40);
        el.sendKeys(text);
    }

    // Counter for multiple web screenshots

    protected void takeWebScreenshot(String TestName) throws IOException {
        String timestamp = String.valueOf(System.currentTimeMillis());
        webScreenshotCounter++; // Increment the counter for each screenshot
        File srcFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "src/../ExecImages/WebScreenshots/web_screenshot_" + timestamp + "_" + webScreenshotCounter + ".png";
        File destFile = new File(screenshotPath);
        Files.copy(srcFile.toPath(), destFile.toPath());

        // Attach the screenshot to the ExtentReports
        test.pass(TestName+".",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}

