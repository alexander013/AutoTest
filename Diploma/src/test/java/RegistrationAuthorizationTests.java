import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class RegistrationAuthorizationTests {
    private WebDriver driver;

    private WebDriverWait wait;

//    Необходимо сделать так, чтобы браузер открывался один раз

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//    Открытие браузера во весь экран
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown() throws IOException {
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_RegAuthoriz\\screenshot.png"));
        driver.quit();
    }

    //        Элемент МОЙ АККАУНТ
    private final By MyAccountElement = By.id("menu-item-30");
    //        Элемент "Имя пользователя или почта"
    private final By UserNameElement = By.id("username");
    //        Элемент "Пароль"
    private final By PasswordElement = By.id("password");
    //        Элемент кнопки ВОЙТИ
    private final By LoginButtonEnterElement = By.name("login");
    //        Элемент "Привет Sacha"
    private final By HelloSachaElementLocator = By.cssSelector("div.woocommerce-MyAccount-content > p:nth-of-type(1)");



//----------------------------------------------------------------------------------------------------------------------
//    Тест авторизации через МОЙ АККАУНТ
    @Test
    public void AuthorizationTest()
    {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Клик на МОЙ АККАУНТ
        driver.findElement(MyAccountElement).click();
//        Ввод "Sacha"
        driver.findElement(UserNameElement).sendKeys("Sacha");
//        Вводим пароль "qwerty123"
        driver.findElement(PasswordElement).sendKeys("qwerty123");
//       Клик по кнопке ВОЙТИ
        driver.findElement(LoginButtonEnterElement).click();
//        Проверка наличия элемента успешной авторизации
        Assert.assertTrue("Элемент не найден", driver.findElement(HelloSachaElementLocator).isDisplayed());
//        Проверка соответствия текста
        Assert.assertEquals("Текст не соответствует", "Привет Sacha (Выйти)",
                driver.findElement(HelloSachaElementLocator).getText());

    }
//----------------------------------------------------------------------------------------------------------------------

}
