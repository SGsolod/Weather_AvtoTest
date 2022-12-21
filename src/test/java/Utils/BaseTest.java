package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait10;
    private WebDriverWait wait20;
    private WebDriverWait wait5;
    public final String BASE_URL = BaseUtils.getBaseUrl();

    @BeforeSuite
    public void beforeClass(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    public void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();
        getDriver().manage().window().maximize();
        getDriver().get(BASE_URL);

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) {
        driver.quit();
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20() {
        if (wait20 == null) {
            wait20 = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        }

        return wait10;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }

    protected void bannerClose() {
        WebElement banner = getDriver().findElement(
                By.xpath("//body[@class = 'body-orange']//div/a[@class = 'smartbanner__exit']"));
        banner.click();

    }

    protected void closeLoaderContainer() {
        getWait10().until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("owm-loader-container")));
    }
}
