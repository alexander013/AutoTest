import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class HomePageTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//     Открытие браузера во весь экран
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown() throws IOException {
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_home\\screenshot.png"));
        driver.quit();
    }
// ----------------------------------------------------------------------------------------------------------------------


    //        Элемент блока главной страницы, подтверждающий нахождение пользователя на главной странице
    private final By PromoWrap1ElementLocator = By.xpath("//*[@class = 'promo-wrap1']");
    //        Элемент для перехода в раздел "Главная"
    private final By HomeElementLocator = By.cssSelector("li#menu-item-26");
    //        Элемент для перехода в раздел "Каталог"
    private final By KatalogElementLocator = By.cssSelector("li#menu-item-46");
    //        Элемент заголовка раздела "Каталог"
    private final By TitleKatalogElementLocator = By.xpath("//h1[text() = 'Каталог']");
    //        Элемент для перехода в раздел "Мой аккаунт"
    private final By AccauntElementLocator = By.cssSelector("li#menu-item-30");
    //        Элемент заголовка заполнения формы раздела "Мой аккаунт"
    private final By TitleAccauntElementLocator = By.xpath("//h2[@class='entry-title'][text() = 'Мой аккаунт']");
    //        Элемент для перехода в раздел "Корзина"
    private final By KorzinaElementLocator = By.cssSelector("li#menu-item-29");
    //        Элемент заголовка раздела "Корзина"
    private final By TitleKorzinaElementLocator = By.xpath("//h2[@class = 'entry-title'][text() = 'Корзина']");
    //          Элемент блока КНИГИ
    private final By KnigiLocator = By.xpath("(//*[@class='caption wow fadeIn'])[1]");
    //        Элемент заголовка раздела "Книги"
    private final By TitleKnigiLocator = By.xpath("(//h1)[2]");
    //        Элемент заголовка блока КНИГИ
    private final By NameKnigiLocator = By.xpath("(//*[@class='caption wow fadeIn'])[1]//h4");
    //        Элемент заголовка раздела ПЛАНШЕТЫ
    private final By TitleTabletsElementLocator = By.cssSelector("h1.entry-title.ak-container");
    //          Элемент блока ПЛАНШЕТЫ
    private final By PlanshetLocator = By.xpath("(//*[@class='caption wow fadeIn'])[2]");
    //        Элемент заголовка блока ПЛАНШЕТЫ
    private final By TitlePlanshetLocator = By.xpath("(//*[@class='caption wow fadeIn'])[2]//h4");
    //        Элемент блока ФОТОАППАРАТЫ
    private final By CameraUnitElementLocator = By.xpath("(//*[@class='caption wow fadeIn'])[3]");
    //        Элемент заголовка раздела ФОТОАППАРТЫ
    private final By TitleCameraUnitElementLocator = By.xpath("//h1[@class='entry-title ak-container']");
    //        Элемент банера УЖЕ В ПРОДАЖЕ
    private final By BannerLocator = By.xpath("(//div[@class='promo-image'])[4]");
    //        Элементы на баннере УЖЕ В ПРОДАЖЕ
    private final By BanerElementLocator = By.xpath("(//*[@class='caption wow fadeIn'])[4]");
    //        Название товара на баннере УЖЕ В ПРОДАЖЕ
    private final By AlreadyOnSaleElementLocator = By.xpath("(//*[@class='caption wow fadeIn'])[4]//div[@class='promo-desc-title']");
    //        Название товара, которое указано в разделе (ВСЕ ТОВАРЫ) после клика по баннеру УЖЕ В ПРОДАЖЕ
    private final By TitleProductElementLocator = By.xpath("//h1[@class='product_title entry-title']");
    //        Элемент ГЛАВНАЯ для всех разделов
    private final By MainElementlocator = By.xpath("//div[@class='woocommerce-breadcrumb accesspress-breadcrumb']//a[1]");
    //        Элемент кнопка скроллинга наверх страницы
    private final By AkTopElementLocator = By.cssSelector("div[style='right: 20px;']");
    //        Элемент в самом низу страницы сайта
    private final By SkillboxElementLocator = By.xpath("//*[@class = 'site-info']");
    //        Элемент с контактами внизу сайта
    private final By BannerTextElementLocator = By.xpath("//*[@class = 'banner-text wow fadeInLeft']");
    //        Элемент товара БАБОЧКА в разделе распродажа
    private final By ButterflyElementLocator = By.xpath("(//*[@data-wow-delay='1s'])[5]");
    //        Элемент ПРОСМОТРЕННЫЕ ТОВАРЫ
    private final By ProductsViewedElementLocator = By.id("woocommerce_recently_viewed_products-2");
    //        Элемент товара АННИГИЛЯТОРНАЯ ПУШКА в разделе РАСПРОДАЖА
    private final By AnnihilatorCannonElementLocator = By.xpath("(//li[@data-wow-delay='0s'])[1]");
    //        Кнопка READ MORE (АННИГИЛЯТОРНАЯ ПУШКА)
    private final By ReadMoreButtonElementLocator = By.xpath("(//a[@data-quantity='1'])[5]");
    //        Элемент слайдера РАСПРОДАЖА
    private final By UnitElementLocator = By.xpath("(//ul)[5]");
    //        Элемент заголовка товара после клика по кнопке READ MORE (АННИГИЛЯТОРНАЯ ПУШКА)
    private final By TitleAnnihilatorCannonElementLocator = By.xpath("//h1[@class = 'product_title entry-title']");
    //        Элемент текста названия товара в разделе РАСПРОДАЖА (АННИГИЛЯТОРНАЯ ПУШКА)
    private final By ElementTovarLocator = By.xpath("(//h3)[5]");
    //        Элемент в слайдере НОВЫЕ ПОСТУПЛЕНИЯ
    private final By TovarNewArrvalsLocator = By.xpath("(//div[@class = 'item-img'])[25]");
    //        Элемент кнопки В КОРЗИНУ
    private final By ButtonBasketElementLocator = By.xpath("(//a[@data-product_id = '3754'])[1]");
    //        Элемент кнопки ПОДРОБНЕЕ
    private final By MoreElementLocator = By.xpath("//a[@class='added_to_cart wc-forward']");
    //        Элемент заголовка раздела КОРЗИНА
    private final By TitleBasketElementLocator = By.xpath("//span[@class='current'][text() = 'Корзина']");



    //  ТЕСТ НА ПЕРЕХОД ПО ССЫЛКЕ http://intershop5.skillbox.ru/ И ПОПАДАНИЕ НА ГЛАВНУЮ СТРАНИЦУ САЙТА
    @Test
    public void OpenHomePageTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Проверка переходим ли в раздел "Главная"
        Assert.assertTrue("Не отобразилась главная страница", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//  ТЕСТ НА ПЕРЕХОД ИЗ РАЗДЕЛА "Главная" В РАЗДЕЛ "Каталог" И ОБРАТНО НА ГЛАВНУЮ СТРАНИЦУ
    @Test
    public void GoingToCatalogTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Нажатие в главном меню на раздел "Каталог"
        driver.findElement(KatalogElementLocator).click();
//        Проверка на нахождение элемента, который подтверждает что мы в разделе "Каталог"
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleKatalogElementLocator).isDisplayed());
//        Проверка на соответсвие текста названия раздела КАТАЛОГ с заголовком раздела КААТЛОГ
        Assert.assertEquals("Неверный текст !", driver.findElement(KatalogElementLocator).getText(),
                driver.findElement(TitleKatalogElementLocator).getText());
//        Нажатие в главном меню на раздел "Главная"
        driver.findElement(HomeElementLocator).click();
//        Проверка на нахождение элемента, который подтверждает что мы в разделе "Главная"
        Assert.assertTrue("Элемент не найден", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//  ТЕСТ НА ПЕРЕХОД ИЗ "Главная" В РАЗДЕЛ "Мой аккаунт" И НАЗАД НА ГЛАВНУЮ СТРАНИЦУ"
    @Test
    public void GoingToMyAccountTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Нажатие в главном меню на раздел "Мой аккаунт"
        driver.findElement(AccauntElementLocator).click();
//        Проверка на нахождение элемента, который подтверждает что мы в разделе "Мой аккаунт"
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleAccauntElementLocator).isDisplayed());
//        Нажатие в главном меню на раздел "Главная"
        driver.findElement(HomeElementLocator).click();
//        Проверка на нахождение элемента, который подтверждает что мы в разделе "Главная"
        Assert.assertTrue("Элемент не найден", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//  ТЕСТ НА ПЕРЕХОД ИЗ РАЗДЕЛА "Главная" В РАЗДЕЛ "Корзина" И ВОЗВРАЩЕНИЕ НА ГЛАВНУЮ СТРАНИЦУ САЙТА
    @Test
    public void GoingToMyBasketTest() {
        //        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Нажатие в главном меню на раздел "Корзина"
        driver.findElement(KorzinaElementLocator).click();
//        Проверка на нахождение элемента, который подтверждает что мы в разделе "Корзина"
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleKorzinaElementLocator).isDisplayed());
//        Нажатие в главном меню на раздел "Главная"
        driver.findElement(HomeElementLocator).click();
//        Проверка на нахождение элемента, который подтверждает что мы в разделе "Главная"
        Assert.assertTrue("Элемент не найден", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


    //    ----------------------------------------------------------------------------------------------------------------------
//    ПЕРЕХОД В БЛОК КНИГИ ИЗ РАЗДЕЛА "Главная"
    @Test
    public void GoingToBookBlockTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Ожидание появления, в блоке КНИГИ, элементов: книги, посмотреть
        wait.until(ExpectedConditions.elementToBeClickable(KnigiLocator));
        var TextNameKnigi = driver.findElement(NameKnigiLocator).getText();
//        Клик по блоку КНИГИ
        driver.findElement(KnigiLocator).click();
        var TextTitleKnigi = driver.findElement(TitleKnigiLocator).getText();
//        Проверка на наличие заголовка раздела КНИГИ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleKnigiLocator).isDisplayed());
//        Проверка на совпадение текста названия блока "Книги" с названем заголовка раздела
        Assert.assertEquals("Неверный текст !", TextNameKnigi,
                TextTitleKnigi);
//        Переход на главную страницу
        driver.findElement(HomeElementLocator).click();
//        Проверка подтверждающая нахождение на главной странице
        Assert.assertTrue("Элемент не найден", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------
//    ТЕСТ НА ПЕРЕХОД В БЛОК ПЛАНШЕТЫ ИЗ РАЗДЕЛА "Главная"
    @Test
    public void GoingToBlockTabletsTest() {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//          Ожидание появления, в блоке ПЛАНШЕТЫ, элементов: планшеты, посмотреть
        wait.until(ExpectedConditions.elementToBeClickable(PlanshetLocator));
        var TextTitlePlanshet = driver.findElement(TitlePlanshetLocator).getText();
//          Клик по элементу блока ПЛАНШЕТЫ
        driver.findElement(PlanshetLocator).click();
        var TextTitleTablets = driver.findElement(TitleTabletsElementLocator).getText();
//        Проверка на наличие заголовка ПЛАНШЕТЫ в разделе ПЛАНШЕТЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleTabletsElementLocator).isDisplayed());
//        Проверка текста на совпадение названия блока ПЛАНШЕТЫ с текстом заголовка раздела ПЛАНШЕТЫ
        Assert.assertEquals("Неверный текст", TextTitlePlanshet,
                TextTitleTablets);
//        Клик по элементу ГЛАВНАЯ в разделе ПЛАНШЕТЫ
        driver.findElement(MainElementlocator).click();
//        Проверка на наличие элемента  блока главной страницы, подтверждающий нахождение пользователя на главной странице
        Assert.assertTrue("Элемент не найден", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }

    //----------------------------------------------------------------------------------------------------------------------
//    Тест перехода в блок ФОТОАППАРАТЫ
//    Здесь не соответствие заголовков при переходе в блок ФОТОАППАРТЫ
//    ФОТОАППАРАТЫ - ФОТО/ВИДЕО
    @Test
    public void GoingToTheCameraUnitTest() {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//          Ожидание появления, в блоке ФОТОАППАРАТЫ, элементов: фотоаппараты, посмотреть
        wait.until(ExpectedConditions.elementToBeClickable(CameraUnitElementLocator));
//          Клик по элементу блока ФОТОАППАРАТЫ
        driver.findElement(CameraUnitElementLocator).click();
//        Проверка на наличие заголовка ФОТО/ВИДЕО в разделе ФОТОАППАРАТЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleCameraUnitElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


// Тест на переход для просмотра товара IPAD AIR 2020 через баннер УЖЕ В ПРОДАЖЕ
//    Здесь текст товара на банере УЖЕ В ПРОДАЖЕ не совпадает с текстом
//        названия товара, которое указано в разделе (ВСЕ ТОВАРЫ) после клика по баннеру УЖЕ В ПРОДАЖЕ.
//        Тест не проходит конечную проверку.

    @Test
    public void GoingToAlreadyOnSaleTest() {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//         Скроллинг до баннера УЖЕ В ПРОДАЖЕ
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(BannerLocator));
        actions.perform();
//        Ожидание элементов на банере УЖЕ В ПРОДАЖЕ
        wait.until(ExpectedConditions.presenceOfElementLocated(BanerElementLocator));
//        Текст названия товара на баннере УЖЕ В ПРОДАЖЕ
        var TextTovara = driver.findElement(AlreadyOnSaleElementLocator).getText();
//        Клик по банеру УЖЕ В ПРОДАЖЕ
        driver.findElement(BannerLocator).click();
        var TextTitleProductElement = driver.findElement(TitleProductElementLocator).getText();
//        Проверка на наличие элемента с названием товара
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleProductElementLocator).isDisplayed());
//        Клик по элементу ГЛАВНАЯ в разделе ПЛАНШЕТЫ
        driver.findElement(MainElementlocator).click();
//        Проверка на наличие элемента блока главной страницы, подтверждающий нахождение пользователя на главной странице
        Assert.assertTrue("Элемент не найден", driver.findElement(PromoWrap1ElementLocator).isDisplayed());
    }
//    --------------------------------------------------------------------------------------------------------------------
//    Тест на работоспособность кнопки со стрелочкой для возврата наверх страницы

    @Test
    public void AkTopTest() {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//         Скроллинг до конца страницы сайта
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SkillboxElementLocator));
        actions.perform();
//        Клик по кнопке скроллинга наверх страницы
        driver.findElement(AkTopElementLocator).click();
//        Ожидание исчезновения элемента кнопки для возвращения наверх страницы
        wait.until(ExpectedConditions.invisibilityOfElementLocated(AkTopElementLocator));
//        Проверка на исчезновение элемента
        Assert.assertTrue("Элемент не исчез", driver.findElements(AkTopElementLocator).size() == 0);
    }
//    --------------------------------------------------------------------------------------------------------------------


    //    Тест на появление элемента с контактами внизу сайта
    @Test
    public void BannerTextTest() {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//         Скроллинг до конца страницы сайта
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SkillboxElementLocator));
        actions.perform();
//        Ожидание появления элемента с контактами внизу сайта
        wait.until(ExpectedConditions.presenceOfElementLocated(BannerTextElementLocator));
//        Проверка на появление элемента с контактами внизу сайта
        Assert.assertTrue("Элемент не найден", driver.findElement(BannerTextElementLocator).isDisplayed());
    }
//  --------------------------------------------------------------------------------------------------------------------


    //    Тест на появление раздела ПРОСМОТРЕННЫЕ ТОВАРЫ
    @Test
    public void ProductsViewedTest() throws InterruptedException {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Скроллинг до баннера УЖЕ В ПРОДАЖЕ
        Actions Banneractions = new Actions(driver);
        Banneractions.moveToElement(driver.findElement(BannerLocator));
        Banneractions.perform();
//        Ожидание появления элемента товара БАБОЧКА
        wait.until(ExpectedConditions.elementToBeClickable(ButterflyElementLocator));
//        Клик по элементу товара БАБОЧКА в разделе распродажа
        driver.findElement(ButterflyElementLocator).click();
//        Клик по элементу ГЛАВНАЯ в раздела ВСЕ ТОВАРЫ, в который перешли после клика по товару БАБОЧКА
//        на главной странице
        driver.findElement(MainElementlocator).click();
//        Скроллинг до низа сайта
        Actions Skillboxactions = new Actions(driver);
        Skillboxactions.moveToElement(driver.findElement(SkillboxElementLocator));
        Skillboxactions.perform();
//        Проверка на наличие раздела ПРОСМОТРЕННЫЕ ТОВАРЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(ProductsViewedElementLocator).isDisplayed());
    }

    //    Тест на измпенение товаров в слайдере РАСПРОДАЖА
    @Test
    public void SliderSaleTest() {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент товара в слайдере РАСПРОДАЖА
        var ProductSaleElementLocator = By.xpath("(//*[@data-wow-delay='2s'])[2]");
//        Элемент стрелочка вправо в слайдере РАСПРОДАЖА
        var SlickNextElementLocator = By.xpath("(//a[@aria-label='next'])[1]");
//        Элемент, который появляется при первом клике на стрелочку вправо, в слайдере РАСПРОДАЖА
        var NextTovarSliderElementLocator = By.xpath("(//*[@data-wow-delay='2s'])[2]");
//        Скроллинг до  элемента товара в слайдере РАСПРОДАЖА
        Actions Saleactions = new Actions(driver);
        Saleactions.moveToElement(driver.findElement(ProductSaleElementLocator));
        Saleactions.perform();
//        Ожидание элемента товара в слайдере РАСПРОДАЖА
        wait.until(ExpectedConditions.elementToBeClickable(ProductSaleElementLocator));
//        Наведение курсора мыши на товар в слайдере РАСПРОДАЖА
        new Actions(driver)
                .moveToElement(driver.findElement(ProductSaleElementLocator))
                .perform();
//        Клик по элементу стрелочка вправо в слайдере РАСПРОДАЖА
        driver.findElement(SlickNextElementLocator).click();
//        Проверка на наличие элемента товара, который появлялется при первом клике
//        на стрелочку вправо, в слайдере РАСПРОДАЖА
        Assert.assertTrue("Элемент не найден", driver.findElement(NextTovarSliderElementLocator).isDisplayed());
    }

//    Тест на клик по кнопке READ MORE на карточке товара раздела РАСПРОДАЖА

    @Test
    public void ReadMoreTest()
    {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Скроллинг до элемента слайдера РАСПРОДАЖА
        Actions SaleActions = new Actions(driver);
        SaleActions.moveToElement(driver.findElement(UnitElementLocator));
        SaleActions.perform();
//        Ожидание элемента товара в слайдере РАСПРОДАЖА
        wait.until(ExpectedConditions.elementToBeClickable(AnnihilatorCannonElementLocator));
        var TextElementTovar = driver.findElement(ElementTovarLocator).getText();
//        Наведение курсора мыши на товар в слайдере РАСПРОДАЖА АННИГИЛЯТОРНАЯ ПУШКА
        new Actions(driver)
                .moveToElement(driver.findElement(AnnihilatorCannonElementLocator))
                .perform();
//        Клик по кнопке READ MORE
        driver.findElement(ReadMoreButtonElementLocator).click();
        var TextTitleAnnihilatorCannonElement = driver.findElement(TitleAnnihilatorCannonElementLocator).getText();
//        Проверка на наличие элемента заголовка товара после клика по кнопке READ MORE (АННИГИЛЯТОРНАЯ ПУШКА)
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleAnnihilatorCannonElementLocator).isDisplayed());

    }

//    Тест на отправку товара в корзину
    @Test
    public void SendingGoodsToBasketTest()
    {
//        Открытие сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Скроллинг до элемента слайдера НОВЫЕ ПОСТУПЛЕНИЯ
        Actions SaleActions = new Actions(driver);
        SaleActions.moveToElement(driver.findElement(TovarNewArrvalsLocator));
        SaleActions.perform();
//        Ожидание элемента товара в слайдере НОВЫЕ ПОСТУПЛЕНИЯ
        wait.until(ExpectedConditions.elementToBeClickable(TovarNewArrvalsLocator));
//        Наведение курсора мыши на товар в слайдере НОВЫЕ ПОСТУПЛЕНИЯ
        new Actions(driver)
                .moveToElement(driver.findElement(TovarNewArrvalsLocator))
                .perform();
//        Наведение курсора мыши на кнопку В КОРЗИНУ
        new Actions(driver)
                .moveToElement(driver.findElement(ButtonBasketElementLocator))
                .perform();
//        Клик по кнопке В КОРЗИНУ
        driver.findElement(ButtonBasketElementLocator).click();
//        Ожидание появления кнопки ПОДРОБНЕЕ
        wait.until(ExpectedConditions.elementToBeClickable(MoreElementLocator));
//        Клик по кнопке ПОДРОБНЕЕ
        driver.findElement(MoreElementLocator).click();
//        Проверка на что перешли в раздел КОРЗИНА
        Assert.assertTrue("элемент не найден", driver.findElement(TitleBasketElementLocator).isDisplayed());
    }
}



