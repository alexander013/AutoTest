import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

public class MakingAnOrderTests {
    private WebDriver driver;

    private WebDriverWait wait;

//    Необходимо сделать так, чтобы браузер открывался один раз

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        Открытие браузера во весь экран
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 7);
    }

    @After
    public void tearDown() throws IOException {
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_MakingOrder\\screenshot.png"));
        driver.quit();
    }

    @Test
    public void MakingOrderTest() {
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
//        Элемент Каталог
        var CatalogElement = By.id("menu-item-46");
//        Элемент товара Apple Watch 6
//        Кнопка В КОРЗИНУ
        var ButtonBasketElementLocator = By.cssSelector("a[data-product_id='15']");
//        Кнопка ПОДРОБНЕЕ
        var ButtonMoreDetailedElementLocator = By.xpath("//*[@class='added_to_cart wc-forward']");
//        Кнопка ОФОРМИТЬ ЗАКАЗ
        var ButtonPlaceOrderElementLocator = By.cssSelector("div.wc-proceed-to-checkout > a");
//        Поле ИМЯ
        var NameElement = By.id("billing_first_name");
//        Поле ФАМИЛИЯ
        var FamilyElement = By.id("billing_last_name");
//        Поле АДРЕС
        var AddressElement = By.id("billing_address_1");
//        Поле ГОРОД/НАСЕЛЕННЫЙ ПУНКТ
        var CityElement = By.id("billing_city");
//        Поле ОБЛАСТЬ
        var AreaElement = By.id("billing_state");
//        Поле ПОЧТОВЫЙ ИНДЕКС
        var PostalCodeElement = By.id("billing_postcode");
//        Поле ТЕЛЕФОН
        var PhoneElement = By.id("billing_phone");
//        Поле АДРЕС ПОЧТЫ
        var EmailElement = By.id("billing_email");
//        Кнопка ОФОРМИТЬ ЗАКАЗ
        var ButtonElement = By.id("place_order");
//        Элемент ЗАКАЗ ПОЛУЧЕН
        var OrderReceivedElementLocator = By.xpath("//h2[@class='post-title'][text()='Заказ получен']");
//        Клик по МОЙ АККАУНТ
        driver.findElement(MyAccountElement).click();
//        Ввод "Sacha"
        driver.findElement(UserNameElement).sendKeys("Sacha");
//        Вводим пароль "qwerty123"
        driver.findElement(PasswordElement).sendKeys("qwerty123");
//       Клик по кнопке ВОЙТИ
        driver.findElement(LoginButtonEnterElement).click();
//        Клик по разделу КАТАЛОГ
        driver.findElement(CatalogElement).click();
//        Наведение на кнопку В КОРЗИНУ
        driver.findElement(CatalogElement).click();
        new Actions(driver)
                .moveToElement(driver.findElement(ButtonBasketElementLocator))
                .perform();
//        Клик по кнопке В КОРЗИНУ
        driver.findElement(ButtonBasketElementLocator).click();
//        Ожидание появления кнопки ПОДРОБНЕЕ
        wait.until(ExpectedConditions.elementToBeClickable(ButtonMoreDetailedElementLocator));
//        Клик по кнопке ПОДРОБНЕЕ
        driver.findElement(ButtonMoreDetailedElementLocator).click();
//        Клик по кнопке ОФОРМИТЬ ЗАКАЗ
        driver.findElement(ButtonPlaceOrderElementLocator).click();
//        Ввод в поле ИМЯ "Геннадий"
        driver.findElement(NameElement).clear();
        driver.findElement(NameElement).sendKeys("Геннадий");
//        Ввод в поле ФАМИЛИЯ "Петров"
        driver.findElement(FamilyElement).clear();
        driver.findElement(FamilyElement).sendKeys("Петров");
//        Ввод в поле АДРЕС "Воронцова 56"
        driver.findElement(AddressElement).clear();
        driver.findElement(AddressElement).sendKeys("Воронцова 56");
//        Ввод в поле ГОРОД/НАСЕЛЕННЫЙ ПУНКТ "Москва"
        driver.findElement(CityElement).clear();
        driver.findElement(CityElement).sendKeys("Москва");
//        Ввод в поле ОБЛАСТЬ "Московская"
        driver.findElement(AreaElement).clear();
        driver.findElement(AreaElement).sendKeys("Московская");
//        ВВОД в поле ПОЧТОВЫЙ ИНДЕКС "123456"
        driver.findElement(PostalCodeElement).clear();
        driver.findElement(PostalCodeElement).sendKeys("123456");
//        Ввод в поле ТЕЛЕФОН "89993334455"
        driver.findElement(PhoneElement).clear();
        driver.findElement(PhoneElement).sendKeys("89993334455");
//        Ввод в поле АДРЕС ПОЧТЫ "snap@mail.ru"
        driver.findElement(EmailElement).clear();
        driver.findElement(EmailElement).sendKeys("snap@mail.ru");
//        Клик по кнопке ОФОРМИТЬ ЗАКАЗ
        driver.findElement(ButtonElement).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(OrderReceivedElementLocator));
//        Проверка наличия элемента ЗАКАЗ ПОЛУЧЕН
        Assert.assertTrue("Элемент не найден",
                driver.findElement(OrderReceivedElementLocator).isDisplayed());
//        Проверка на соответствие текста
        Assert.assertEquals("Текст не соответствует", "Заказ получен",
                driver.findElement(OrderReceivedElementLocator).getText());
    }
}
