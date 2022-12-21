import Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoTest extends BaseTest {

    private final static String LOGO = "//nav//a/img";

    private void assertEquals() {
        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL);
    }

    @Test
    public void testLogoGuidePageOpensMainPage() {

        closeLoaderContainer();
        getWait5().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//nav//div[@id = 'desktop-menu']//a[@href = '/guide']"))).click();

        getDriver().findElement(By.xpath(LOGO)).click();
        assertEquals();
    }

}
