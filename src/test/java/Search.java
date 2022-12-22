import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {


    private WebDriver driver;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void Search() {
        driver.findElement(By.id("search")).sendKeys("ceaun");
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[1]/button")).click();

        WebElement Search = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title"));
        Assert.assertTrue(Search.isDisplayed());
    }



    @After
    public void quit() {
        driver.close();
    }
}
