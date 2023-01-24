import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class RegistrationAuthorizationTests {
    private static WebDriver driver;

    private static WebDriverWait wait;

//    Необходимо сделать так, чтобы браузер открывался один раз

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//    Открытие браузера во весь экран
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void tearDown() throws IOException {
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_RegAuthoriz\\screenshot.png"));
        driver.quit();
    }
//----------------------------------------------------------------------------------------------------------------------
//    Тест регистрации через кнопку ВОЙТИ вправом верхнем углу сайта
    @Test
    public void RegistrationButtonEnterTest()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент кнопки ВОЙТИ вправом верхнем углу сайта
        var ButtonEnterElement = By.className("account");
//        Элемент кнопки ЗАРЕГИСТРИРОВАТЬСЯ в форме авторизации
        var ButtonRegistrElementLocator = By.xpath("//button[@type='button']");
//        Элемент поля "Имя пользователя"
        var RegUserNameElement = By.id("reg_username");
//        Элемент поля "Адрес почты"
        var RegEmailElement = By.id("reg_email");
//        Элемент поля "Пароль"
        var RegPasswordElement = By.id("reg_password");
//        Элемент кнопки ЗАРЕГИСТРИРОВАТЬСЯ в форме регистрации
        var RegButtonElement = By.name("register");
//        Элемент успешной регистрации "Регистрация завершена"
        var RegistrationCompletedElementLocator = By.xpath("//div[@class='content-page']//div");
//        Клик по кнопке ВОЙТИ вправом верхнем углу сайта
        driver.findElement(ButtonEnterElement).click();
//        Клик по кнопке ЗАРЕГИСТРИРОВАТЬСЯ в форме авторизации
        driver.findElement(ButtonRegistrElementLocator).click();
//        Ввод в поле "Имя пользователя"  "Sacha2"
        driver.findElement(RegUserNameElement).sendKeys("Sacha4");
//        Ввод в поле "Адрес почты"  "snap2@mail.ru"
        driver.findElement(RegEmailElement).sendKeys("snap4@mail.ru");
//        Ввод в поле "Пароль" "qwerty123"
        driver.findElement(RegPasswordElement).sendKeys("qwerty123");
//        Клик по кнопке ЗАРЕГИСТРИРОВАТЬСЯ
        driver.findElement(RegButtonElement).click();
//        Проверка на наличие элемента успешной регистрации "Регистрация завершена"
        Assert.assertTrue("Элемент не найден", driver.findElement(RegistrationCompletedElementLocator).isDisplayed());
//        Проверка на соответствие текста
        Assert.assertEquals("Неверный текст", "Регистрация завершена",
                driver.findElement(RegistrationCompletedElementLocator).getText());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест авторизации через МОЙ АККАУНТ
    @Test
    public void AuthorizationTest()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент МОЙ АККАУНТ
        var MyAccountElement = By.id("menu-item-30");
//        Элемент "Имя пользователя или почта"
        var UserNameElement = By.id("username");
//        Элемент "Пароль"
        var PasswordElement = By.id("password");
//        Элемент кнопки ВОЙТИ
        var LoginButtonEnterElement = By.name("login");
//        Элемент "Привет Sacha"
        var HelloSachaElementLocator = By.cssSelector("div.woocommerce-MyAccount-content > p:nth-of-type(1)");
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