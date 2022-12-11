import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Teste {

    private WebDriver driver;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void LoginTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("vladimirputin@mail.ru");
        driver.findElement(By.id("pass")).sendKeys("mustcrushcapitalism123");
        driver.findElement(By.id("send2")).click();


        WebElement welcome = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        Assert.assertTrue(welcome.isDisplayed());
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

    @Test
    public void AddToWishList() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("vladimirputin@mail.ru");
        driver.findElement(By.id("pass")).sendKeys("mustcrushcapitalism123");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();

        WebElement UpdateWishlist = driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-update.button-secondary"));
        Assert.assertTrue(UpdateWishlist.isDisplayed());
    }

    @Test
    public void LoginLogout() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("vladimirputin@mail.ru");
        driver.findElement(By.id("pass")).sendKeys("mustcrushcapitalism123");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();

        WebElement LoginLogout = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertTrue(LoginLogout.isDisplayed());
    }

    @Test
    public void OpenCart() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a")).click();

        WebElement OpenCart = driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > p.empty"));
        Assert.assertTrue(OpenCart.isDisplayed());
    }

    @Test
    public void Search() {
        driver.findElement(By.id("search")).sendKeys("ceaun");
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[1]/button")).click();

        WebElement Search = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title"));
        Assert.assertTrue(Search.isDisplayed());
    }


    @Test
    public void AddToCartByQtyAndSize() {
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(1) > a > img")).click();
        driver.findElement(By.xpath("//*[@id=\"qty\"]")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#swatch21 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();

        WebElement AddToCartByQtyAndSize = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > ul > li > button"));
        Assert.assertTrue(AddToCartByQtyAndSize.isDisplayed());
    }

    @Test
    public void Compare(){
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(1) > a > img")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(2) > a")).click();

        WebElement Compare = driver.findElement(By.cssSelector("#messages_product_view > ul > li > ul > li"));
        Assert.assertTrue(Compare.isDisplayed());
    }

@After
    public void quit() {
        driver.close();
    }
}
