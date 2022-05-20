import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests {
    private static final String URL =
            "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

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
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));

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
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuItems = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        String actualResult = menuItems.getText();

        Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult));

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

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
                //body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[text()='Submit New Language'] ! вариант № 2 !
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
        String[] expectedResult = {"Oliver Schade",
                "Gregor Scheithauer",
                "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get(url);

        driver.findElement(
                By.xpath("//body//ul[@id='submenu']//a[text()='Team']")).click();

        String[] actualResult = new String[3];

        WebElement firstCreatorName = driver.findElement(
                By.xpath("//body//h3[text()='Oliver Schade']"));
        actualResult[0] = firstCreatorName.getText();
        WebElement secondCreatorName = driver.findElement(
                By.xpath("//body//h3[text()='Gregor Scheithauer']"));
        actualResult[1] = secondCreatorName.getText();
        WebElement thirdCreatorName = driver.findElement(
                By.xpath("//body//h3[text()='Stefan Scheler']"));
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
    public void testOpeningScreenshot() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/");

        driver.findElement(
                By.xpath("//a[@href='info.html']")).click();
        driver.findElement(
                By.xpath("//img[@src='/images/history1_small.png']")).click();

        Assert.assertTrue(driver.findElement(By.tagName("img")).isDisplayed());

        driver.quit();
    }

    /**
     * TC № 11 Подтвердите, что если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html, пользователь
     * нажмет кнопку Submit Language, не заполнив информацию в обязательных полях,
     * будет показана ошибка Error: Precondition failed - Incomplete Input.
     */
    @Test
    public void testPresenceErrorWithEmptyFields() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement messageError = driver.findElement(
                By.xpath("//div[@id='main']/p"));

        String actualResult = messageError.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC № 12 Precondition: Если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html,
     * пользователь нажмет кнопку Submit Language, не заполнив информацию в
     * обязательных полях, будет показана ошибка с текстом
     * Error: Precondition failed - Incomplete Input.
     * Подтвердите, что в тексте ошибки слова Error, Precondition, Incomplete и
     * Input написаны с большой буквы, а слово failed написано с маленькой буквы.
     * Так же подтвердите, что в тексте ошибки содержатся знаки :, - и .
     */
    @Test
    public void testPunctuationInError() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String expectedResult1 = "Error";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "Incomplete";
        String expectedResult4 = "Input";
        String expectedResult5 = "failed";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement checkingSpelling = driver.findElement(
                By.xpath("//p[@style]")); //УТОЧНИТЬ МОЖНО ЛИ ИСПОЛЬЗОВАТЬ ТАКОЙ ЗАПРОС

        Assert.assertEquals(checkingSpelling.getText().substring(0, 5),
                expectedResult1);
        Assert.assertEquals(checkingSpelling.getText().substring(7, 19),
                expectedResult2);
        Assert.assertEquals(checkingSpelling.getText().substring(29, 39),
                expectedResult3);
        Assert.assertEquals(checkingSpelling.getText().substring(40, 45),
                expectedResult4);
        Assert.assertEquals(checkingSpelling.getText().substring(20, 26),
                expectedResult5);
        Assert.assertEquals(checkingSpelling.getText().substring(5, 6),
                expectedResult6);
        Assert.assertEquals(checkingSpelling.getText().substring(27, 28),
                expectedResult7);
        Assert.assertEquals(checkingSpelling.getText().substring(45),
                expectedResult8);

        driver.quit();
    }

    /**
     * TC № 13 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html в первом пункте
     * списка пользователь видит текст
     * IMPORTANT: Take your time! The more carefully you fill out this form
     * (especially the language name and description), the easier it will be for
     * us and the faster your language will show up on this page. We don't have
     * the time to mess around with fixing your descriptions etc. Thanks for
     * your understanding.
     */
    @Test
    public void testFirstParagraphForPresenceText() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String expectedResult = "IMPORTANT: Take your time! The more " +
                "carefully you fill out this form (especially the language " +
                "name and description), the easier it will be for us and the " +
                "faster your language will show up on this page. We don't " +
                "have the time to mess around with fixing your descriptions " +
                "etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement textFirstParagraph = driver.findElement(
                By.xpath("//div[@id='main']//li[1]"));

        Assert.assertEquals(textFirstParagraph.getText(),
                expectedResult);

        driver.quit();
    }

    /**
     * TC № 14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь
     * увидит таблицу со следующими названиями для первого и второго столбцов:
     * Language
     * Author
     */
    @Test
    public void testTableColumns() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/");

        driver.findElement(By.xpath("//ul//a[@href='/abc.html']")).click();

        WebElement tableColumnLanguage = driver.findElement(
                By.xpath("//th[text()='Language']"));
        WebElement tableColumnAuthor = driver.findElement(
                By.xpath("//th[text()='Author']"));

        Assert.assertEquals(tableColumnLanguage.getText(),
                "Language");
        Assert.assertEquals(tableColumnAuthor.getText(),
                "Author");

        driver.quit();
    }

    /**
     * TC № 15 Подтвердите, что на странице по базовой ссылке пользователь НЕ
     * увидит новые комментарии, если нажмет на пункты меню Top List → New Comments
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт меню Top List
     * 3. Нажать на пункт подменю New Comments
     * 6. Подтвердить, что отсутствуют новые комментарии
     * 7. Закрыть браузер
     */
    @Test
    public void testAvailabilityComments() { //УЗНАТЬ КАК ТАКОЙ ВАРИАНТ РЕШЕНИЯ!!!!!
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/");

        driver.findElement(By.xpath("//a[@href='/toplist.html']")).click();
        driver.findElement(By.xpath("//a[@href='./newcomments.html']")).click();

        WebElement availabilityComments = driver.findElement(
                By.xpath("//div[@id='main']/p"));

        Assert.assertEquals(availabilityComments.getText(),
                expectedResult);


        driver.quit();
    }

    /**
     * TC № 21 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html пользователь
     * видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом
     * на красном фоне, и что все буквы - capital
     */
    @Test
    public void testFontAndTextColor() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\patri\\Downloads\\driver_Chrome" +
                "\\chromedriver.exe";
        String expectedResult = "background-color: red; color: white;";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement fontAndTextColor = driver.findElement(
                By.xpath("//span"));
        WebElement textWarning = driver.findElement(
                By.xpath("//span/b"));

        Assert.assertEquals(fontAndTextColor.getText(),"IMPORTANT:");
        Assert.assertEquals(fontAndTextColor.getAttribute("style"),
                expectedResult);
        Assert.assertEquals(textWarning.getCssValue("font-weight"),
                "700");

        driver.quit();
    }
}
