import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests {

    /**
     * TC № 1 Подтвердите, что на странице по базовой ссылке в правом верхнем углу
     * пользователь видит заголовок 99 Bottles of Beer
     */
    @Test
    public void testHeadline() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement headline = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1")
        );
        String actualResult = headline.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC № 2 Подтвердите, что на странице по базовой ссылке последний пункт
     * меню называется Submit new Language
     */
    @Test
    public void testMenuItems() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
//        boolean expectedResult1 = true;
        String expectedResult = "Submit new Language";


        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuItems = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        String actualResult = menuItems.getText();
//        boolean actualResult1 = expectedResult.equalsIgnoreCase(actualResult);
        Assert.assertEquals(actualResult, expectedResult.toUpperCase());
//        Assert.assertEquals(actualResult1,expectedResult1);

        driver.quit();
    }

    /**
     * TC № 3 Подтвердите, что на странице по базовой ссылке последний пункт
     * меню имеет подзаголовок Submit new Language
     */
    @Test
    public void testMenuPresenceOfHeader() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuPresenceOfHeader = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        menuPresenceOfHeader.click();
        ;

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
                //body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[text()='Submit New Language']
        );

        String actualResult = submitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC № 4 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/abc.html, первый пункт подменю, называется 0-9
     */
    @Test
    public void testFirstPointSubmenu() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body//ul[@id='menu']//a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();
        ;

        WebElement firstPointSubmenu = driver.findElement(
                By.xpath("//body//ul[@id='submenu']//a[text()='0-9']")
        );

        String actualResult = firstPointSubmenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC № 6 Подтвердите, что имена создателей сайта: Oliver Schade,
     * Gregor Scheithauer, Stefan Scheler
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт подменю Team
     * 3. Считать имя первого создателя
     * 4. Считать имя второго создателя
     * 5. Считать имя третьего создателя
     * 6. Подтвердить, что имена создателей сайта соответствует ожидаемому
     * 7. Закрыть браузер
     */
    @Test
    public void testConfirmationOfCreatorsNames() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String[] expectedResult = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get(url);

        driver.findElement(By.xpath("//body//ul[@id='submenu']//a[text()='Team']")).click();

        String[] actualResult = new String[3];

        WebElement firstCreatorName = driver.findElement(By.xpath("//body//h3[text()='Oliver Schade']"));
        actualResult[0] = firstCreatorName.getText();
        WebElement secondCreatorName = driver.findElement(By.xpath("//body//h3[text()='Gregor Scheithauer']"));
        actualResult[1] = secondCreatorName.getText();
        WebElement thirdCreatorName = driver.findElement(By.xpath("//body//h3[text()='Stefan Scheler']"));
        actualResult[2] = thirdCreatorName.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC № 7 Подтвердите, что при нажатии на Screenshot history1_small.png,
     * происходит переход на другую страницу и полноразмерное раскрытие
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт подменю History
     * 3. Нажать на Screenshot history1_small.png
     * 6. Подтвердить, что происходит переход на другую страницу и полноразмерное
     * раскрытие
     * 7. Закрыть браузер
     */
    @Test
    public void testOpeningScreenshot() { //УТОЧНИТЬ ПАРВИЛЬНОСТЬ ТЕСТА!!!!
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(
                By.xpath("//a[@href='info.html']")).click();

        driver.findElement(
                By.xpath("//img[@src='/images/history1_small.png']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());

        driver.quit();
    }

    /**
     * TC № 11 Подтвердите, что если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html, пользователь
     * нажмет кнопку Submit Language, не заполнив информацию в обязательных полях,
     * будет показана ошибка Error: Precondition failed - Incomplete Input.
     */
    @Test
    public void testPresenseErrorWithEmptyFields() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(By.xpath("//input[@type='submit']")).click(); //УТОЧНИТЬ ИСПОЛЬЗОВАНИЯ ТАКОГО ЗАПРОСА ЭЛЕМЕНТА

        WebElement messageError = driver.findElement( //УТОЧНИТЬ ВАРИАНТЫ КАК ЛУЧШЕ СДЕЛАТЬ ЗАПРОС
                By.xpath("//p[@style='border: 1px solid red; background-color: #ffe0e0; padding: 5px; margin: 5px 10px 5px 10px;']"));

        String actualResult = messageError.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
