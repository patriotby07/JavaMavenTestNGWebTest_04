import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://www.99-bottles-of-beer.net/";
        driver.get(url);
    }

    @Test
    public void testMenuStartTitle() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 10, 200);

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']" +
                "/div[@id='main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
