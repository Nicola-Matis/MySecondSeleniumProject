import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCart {


    private WebDriver driver;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void OpenCart() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a")).click();

        WebElement OpenCart = driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > p.empty"));
        Assert.assertTrue(OpenCart.isDisplayed());
    }



    @After
    public void quit() {
        driver.close();
    }
}
