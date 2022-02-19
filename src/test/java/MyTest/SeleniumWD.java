package MyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class SeleniumWD {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
    String browser = PropertyReader.BROWSER;
        switch (browser) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("version");

                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default:
                throw new InvalidArgumentException("cant initialize driver, available options: chrome, firefox");
        }

    }

    @Test
    public void UserDriverManager() {
        driver.get("http://automationpractice.com/");
        WebElement contactUsButton = driver.findElement(By.xpath("//a[@title='Contact us']"));
        contactUsButton.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }
}
