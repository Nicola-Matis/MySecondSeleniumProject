import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {


    private WebDriver driver;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void RegisterTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Vladimir");
        driver.findElement(By.id("middlename")).sendKeys("Putin");
        driver.findElement(By.id("lastname")).sendKeys("Vladimirochi");
        driver.findElement(By.id("email_address")).sendKeys("vladimirputin@mail.ru");
        driver.findElement(By.id("password")).sendKeys("mustcrushcapitalism123");
        driver.findElement(By.id("confirmation")).sendKeys("mustcrushcapitalism123");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[1]/ul/li[4]/label")).click();

        WebElement register = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button"));
        Assert.assertTrue(register.isDisplayed());
    }






    @After
    public void quit() {
        driver.close();
    }
}
