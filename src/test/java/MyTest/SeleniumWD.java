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
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

public class SeleniumWD {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
    String browser = PropertyReader.BROWSER;
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
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
