import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasketTests {
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
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_basket\\screenshot.png"));
        driver.quit();
    }


    //        Элемент для перехода в раздел КАТАЛОГ
    private final By CatalogElement = By.id("menu-item-46");
    //        Элемент кнопки ПРИМЕНИТЬ КУПОН
    private final By ButtonCouponElement = By.name("apply_coupon");
    //        Элемент поля ВВЕДИТЕ КОД КУПОНА
    private final By EnterCouponCodeElement = By.id("coupon_code");
    //        Сообщение об успешном добавлении купона
    private final By CouponSuccessfullyAddedElementLoator = By.cssSelector("div.woocommerce-message");
    //        Элемент товара Apple Watch 6
    //        Кнопка В КОРЗИНУ
    private final By ButtonBasketElementLocator = By.cssSelector("a[data-product_id='15']");
    //        Кнопка ПОДРОБНЕЕ
    private final By ButtonMoreDetailedElementLocator = By.xpath("//*[@class='added_to_cart wc-forward']");
    //        Элемент раздела КОРЗИНА
    private final By BasketElementzLocator = By.cssSelector("span.current");
    //        Сообщение НЕВЕРНЫЙ КУПОН
    private final By InvalidCouponElementLoator = By.cssSelector("ul.woocommerce-error");
    //        Кнопка удаления товара из корзины
    private final By DeleteButtonElementLocator = By.cssSelector("a[data-product_id='15']");
    //        Сообщение об удалении товара
    private final By MessageDeleteProductElementLocator = By.cssSelector("div.woocommerce-message");
    //        Элемент для возвращения удалённого товара из корзины
    private final By ReturnElementLocator = By.cssSelector("a.restore-item");
    //        Товар в корзине Apple Watch 6
    private final By AppleWatchElementLocator = By.cssSelector("td.product-name");
    //        Элемент увеличения количества товара
    private final By QuantityElementLocator = By.xpath("//input[@type='number']");
    //        Загрузочный элемент при обновлении корзины
    private final By block = By.cssSelector("div.blockUI.blockOverlay");
    //        Общая сумма товара
    private final By TotalCostElementLocator = By.xpath("(//bdi[text() = '174950,00'])[1]");





    //----------------------------------------------------------------------------------------------------------------------
//    Тест на применение действующего купона sert500
    @Test
    public void ValidCouponTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
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
//        Проверка на наличие элемента раздела КОРЗИНА
        Assert.assertTrue("Элемент не найден", driver.findElement(BasketElementzLocator).isDisplayed());
//        Проверка на соответствие текста названия КОРЗИНА
        Assert.assertEquals("Текст не соответствует", "Корзина", driver.findElement(BasketElementzLocator).getText());
//        Заполнение поля ВВЕДИТЕ КОД КУПОНА
        driver.findElement(EnterCouponCodeElement).sendKeys("sert500");
//        Клик по кнопке ПРИМЕНИТЬ КУПОН
        driver.findElement(ButtonCouponElement).click();
//        Ожидание появления элемента КУПОН УСПЕШНО ДОБАВЛЕН
        wait.until(ExpectedConditions.presenceOfElementLocated(CouponSuccessfullyAddedElementLoator));
//        Проверка на наличие элемента КУПОН УСПЕШНО ДОБАВЛЕН
        Assert.assertTrue("Элемент не найден", driver.findElement(CouponSuccessfullyAddedElementLoator).isDisplayed());
//        Проверка соответствия текста
        Assert.assertEquals("Неверный текст", "Купон успешно добавлен.",
                driver.findElement(CouponSuccessfullyAddedElementLoator).
                        getText());
    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//    Тест на применение не действительного купона sert13000
    @Test
    public void NoValidCouponTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
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
//        Проверка на наличие элемента раздела КОРЗИНА
        Assert.assertTrue("Элемент не найден", driver.findElement(BasketElementzLocator).isDisplayed());
//        Проверка на соответствие текста названия КОРЗИНА
        Assert.assertEquals("Текст не соответствует", "Корзина", driver.findElement(BasketElementzLocator).getText());
//        Заполнение поля ВВЕДИТЕ КОД КУПОНА
        driver.findElement(EnterCouponCodeElement).sendKeys("sert1300");
//        Клик по кнопке ПРИМЕНИТЬ КУПОН
        driver.findElement(ButtonCouponElement).click();
//        Ожидание появления элемента НЕВЕРНЫЙ КУПОН
        wait.until(ExpectedConditions.presenceOfElementLocated(InvalidCouponElementLoator));
//        Проверка на наличие элемента НЕВЕРНЫЙ КУПОН
        Assert.assertTrue("Элемент не найден", driver.findElement(InvalidCouponElementLoator).isDisplayed());
//        Проверка соответствия текста
        Assert.assertEquals("Неверный текст", "Неверный купон.",
                driver.findElement(InvalidCouponElementLoator).
                        getText());
    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//    Тест на удаление товара из корзины и возвращение удалённого товара
    @Test
    public void DeleteProductTest() {
        //        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
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
//        Проверка на наличие элемента раздела КОРЗИНА
        Assert.assertTrue("Элемент не найден", driver.findElement(BasketElementzLocator).isDisplayed());
//        Проверка на соответствие текста названия КОРЗИНА
        Assert.assertEquals("Текст не соответствует", "Корзина", driver.findElement(BasketElementzLocator).
                getText());
//        Клик по кнопке удаления товара из корзины
        driver.findElement(DeleteButtonElementLocator).click();
//        Ожидание появления сообщения “Apple Watch 6” удален. Вернуть?
        wait.until(ExpectedConditions.presenceOfElementLocated(MessageDeleteProductElementLocator));
        Assert.assertEquals("Неверный текст", "“Apple Watch 6” удален. Вернуть?",
                driver.findElement(MessageDeleteProductElementLocator).getText());
//        Клик по ВЕРНУТЬ?
        driver.findElement(ReturnElementLocator).click();
//        Ожидание элемента "Apple Watch 6"
        wait.until(ExpectedConditions.presenceOfElementLocated(AppleWatchElementLocator));
//        Проверка на наличие элемента товара в корзине
        Assert.assertTrue("Элемент не найден",
                driver.findElement(AppleWatchElementLocator).isDisplayed());
//        Проверка на соответствие текста
        Assert.assertEquals("Неверный текст", "Apple Watch 6",
                driver.findElement(AppleWatchElementLocator).getText());

    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//    Тест на увеличение, уменьшение количества товара
    @Test
    public void IncreaseDecreaseQuantityGoodsTest() throws InterruptedException {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
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
//        Проверка на наличие элемента раздела КОРЗИНА
        Assert.assertTrue("Элемент не найден", driver.findElement(BasketElementzLocator).isDisplayed());
//        Проверка на соответствие текста названия КОРЗИНА
        Assert.assertEquals("Текст не соответствует", "Корзина", driver.findElement(BasketElementzLocator).
                getText());
//        Наведение на элемент количества товаров
        new Actions(driver)
                .moveToElement(driver.findElement(QuantityElementLocator))
                .perform();
//        очищение поля КОЛИЧЕСТВО
        driver.findElement(QuantityElementLocator).clear();
//        Ввод в поле КОЛИЧЕСТВО значания
        driver.findElement(QuantityElementLocator).sendKeys("5");
//        Нажимаем ENTER
        driver.findElement(QuantityElementLocator).sendKeys(Keys.ENTER);
//        Ожидание исчезновения элемента обновления страницы (черный кружок в центре)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(block));
//        Проверяем что общая стоимость равна 174950.00 рублей
        Assert.assertEquals("Сумма не соответствует", "174950,00₽",
                driver.findElement(TotalCostElementLocator).getText());
    }

//----------------------------------------------------------------------------------------------------------------------
}
