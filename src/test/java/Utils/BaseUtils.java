package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseUtils {

   private static final String BASE_URL = "https://openweathermap.org/";

    public static String getBaseUrl() {

       return BASE_URL;
   }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
