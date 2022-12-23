import Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LogoTest extends BaseTest {

    private final static String LOGO = "//nav//a/img";
    private final static By GUIDE_PAGE = By.xpath("//div[@id = 'desktop-menu']//a[@href = '/guide']");
    private final static By API_PAGE = By.xpath("//div[@id = 'desktop-menu']//a[@href = '/api']");
    private final static By DASHBOARD_PAGE = By.xpath("//div[@id = 'desktop-menu']//a[@href = '/weather-dashboard']");
    private final static By PRICING_PAGE = By.xpath("//div[@id = 'desktop-menu']//a[@href = '/price']");

    private void assertEquals() {
        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL);
    }

    private void logoClicked() {
        getDriver().findElement(By.className("logo")).click();
    }

    private WebElement getElement(By by, WebDriver driver) {
        return driver.findElement(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    @Test
    public void testLogoPageOpensMainPage() {

        closeLoaderContainer(); // ждет закрытия серого окна
        List<WebElement> header = getDriver().findElements(By.xpath("//div[@id = 'desktop-menu']/ul/li"));
        for (WebElement headings : header) {
            if (headings.если элимент есть в списке) {
                click(GUIDE_PAGE, getDriver());
                logoClicked();
                assertEquals();
            }
           //if (headings.getText().contains("api")) {
           //    click(API_PAGE, getDriver());
           //    logoClicked();
           //    assertEquals();
           //}

        }



        /*Reporter.log("Кликабельность логотипа на странице Guide", true);
        closeLoaderContainer();
        getWait5().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(GUIDE_PAGE))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице API", true);
        closeLoaderContainer();
        getWait5().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(API_PAGE))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице Dashboard", true);
        closeLoaderContainer();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DASHBOARD_PAGE))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице Pricing", true);
        closeLoaderContainer();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRICING_PAGE))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице Maps", true);
        closeLoaderContainer();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@id = 'desktop-menu']//a[@href = '/weathermap']"))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице Our Initiatives", true);
        closeLoaderContainer();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@id = 'desktop-menu']//a[@href = '/our-initiatives']"))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице Partners", true);
        closeLoaderContainer();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@id = 'desktop-menu']//a[@href = '/examples']"))).click();
        logoClicked();
        assertEquals();

        Reporter.log("Кликабельность логотипа на странице Support => FAQ", true);
        closeLoaderContainer();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className(
                "with-dropdown"))).click();
        logoClicked();
        assertEquals();*/


    }

}
