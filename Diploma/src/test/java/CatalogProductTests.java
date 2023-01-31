import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CatalogProductTests {

    private WebDriver driver;

    private WebDriverWait wait;


    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//    Открытие браузера во весь экран
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown() throws IOException{
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_catalog\\screenshot.png"));
        driver.quit();
    }


    //        Элемент для перехода в раздел КАТАЛОГ
    private final By CatalogElement = By.id("menu-item-46");
    //        Элемент названия раздела КАТАЛОГ
    private final By TitleCatalogElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text()='Каталог']");
    //        Элемент БЫТОВАЯ ТЕХНИКА, который появляется при наведении на раздел КАТАЛОГ
    private final By HomeAppliancesElementLocator = By.id("menu-item-119");
    //        Элемент ХОЛОДИЛЬНИКИ в под меню БЫТОВАЯ ТЕХНИКА
    private final By RefrigeratorsElementLocator = By.id("menu-item-120");
    //        Элемент заголовка раздела ХОЛОДИЛЬНИКИ
    private final By TitleRefrigeratorsElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text()='Холодильники']");
    //        Заголовок раздела БЫТОВАЯ ТЕХНИКА
    private final By TitleHomeAppliancesElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text()='Бытовая техника']");
    //        Элемент СТИРАЛЬНЫЕ МАШИНЫ в под меню БЫТОВАЯ ТЕХНИКА
    private final By WashingMachinesElementLocator = By.id("menu-item-121");
    //        Элемент заголовка раздела СТИРАЛЬНЫЕ МАШИНЫ
    private final By TitleWashingMachinesElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text()='Стиральные машины']");
    //        Элемент ЭЛЕКТРОНИКА, который появляется при наведении на раздел КАТАЛОГ
    private final By ElectronicsElementLocator = By.id("menu-item-47");
    //        Заголовок раздела ЭЛЕКТРОНИКА
    private final By TitleElectronicsElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text()='Электроника']");
    //        Элемент ТЕЛЕФОНЫ
    private final By PhonesElement = By.id("menu-item-114");
    //        Элемент ПЛАНШЕТЫ
    private final By TabletsElement = By.id("menu-item-116");
    //        Элемент ТЕЛЕВИЗОРЫ
    private final By TelevisionsElement = By.id("menu-item-118");
    //        Элемент ФОТО/ВИДЕО
    private final By PhotosVideosElement = By.id("menu-item-117");
    //        Элемент ЧАСЫ
    private final By WatchesElement = By.id("menu-item-115");
    //        Заголовок раздела ТЕЛЕФОНЫ
    private final By TitlePhoneElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Телефоны']");
    //        Заголовок раздела ПЛАНШЕТЫ
    private final By TitleTabletsElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Планшеты']");
    //        Заголовок раздела ТЕЛЕВИЗОРЫ
    private final By TitleTelevisionsElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Телевизоры']");
    //        Заголовок раздела ФОТО/ВИДЕО
    private final By TitlePhotosVideosElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Фото/видео']");
    //        Заголовок раздела ЧАСЫ
    private final By TitleWatchesElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Часы']");
    //        Элемент КНИГИ, который появляется при наведении на раздел КАТАЛОГ
    private final By BooksElementLocator = By.id("menu-item-180");
    //        Заголовок раздела КНИГИ
    private final By TitleBooksElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Книги']");
    //        Элемент ОДЕЖДА, который появляется при наведении на раздел КАТАЛОГ
    private final By ClothesElementLocator = By.id("menu-item-48");
    //        Заголовок раздела КНИГИ
    private final By TitleClothesElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Одежда']");
    //        Элемент поля поиска
    private final By SearchFieldElement = By.name("s");
    //        Элемент кнопки поиска
    private final By ButtonSearSubmitElement = By.className("searchsubmit");
    //        Элемент заголовка искомого товара (в данном случае "iPad Air 2020 64gb wi-fi")
    private final By TitleProductElementLocator = By.xpath("//h1[text() = 'iPad Air 2020 64gb wi-fi']");
    //        Элемент ВЫПАДАЮЩИХ СПИСКОВ
    private final By SortigElement = By.cssSelector("select[name='orderby']");
    //          Элемент ОБЫЧНАЯ СОРТИРОВКА
    private final By MenuOrderElement = By.cssSelector("select[name='orderby'] option:nth-of-type(1)");
    //          Элемент ПО ПОПУЛЯРНОСТИ
    private final By PopularityElement = By.cssSelector("select[name='orderby'] option:nth-of-type(2)");
    //          Элемент ПО ОТЗЫВАМ
    private final By RatingElement = By.cssSelector("select[name='orderby'] option:nth-of-type(3)");
    //          Элемент ПОСЛЕДНИЕ
    private final By DateElement = By.cssSelector("select[name='orderby'] option:nth-of-type(4)");
    //          Элемент ПО ВОЗРАСТАНИЮ ЦЕНЫ
    private final By PriceElement = By.cssSelector("select[name='orderby'] option:nth-of-type(5)");
    //          Элемент ПО УБЫВАНИЮ ЦЕНЫ
    private final By PriceDescElement = By.cssSelector("select[name='orderby'] option:nth-of-type(6)");
    //        Элемент названия КАТЕГОРИИ ТОВАРОВ
    private final By ProductCategoryElementLocator = By.xpath("(//span[@class='widget-title'])[1]");
    //        Элемент товара Apple Watch 6
    //        Кнопка В КОРЗИНУ
    private final By ButtonBasketElementLocator = By.cssSelector("a[data-product_id='15']");
    //        Кнопка ПОДРОБНЕЕ
    private final By ButtonMoreDetailedElementLocator = By.xpath("//*[@class='added_to_cart wc-forward']");
    //        Элемент раздела КОРЗИНА
    private final By BasketElementzLocator = By.cssSelector("span.current");


//----------------------------------------------------------------------------------------------------------------------
//    Тест на  переход в раздел КАТАЛОГ
    @Test
    public void GoingToCatalogTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Клик для перехода в раздел КАТАЛОГ
        driver.findElement(CatalogElement).click();
//        Проверка на наличие элемента названия раздела КАТАЛОГ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleCatalogElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел ХОЛОДИЛЬНИКИ после наведения на КАТАЛОГ и на БЫТОВАЯ ТЕХНИКА
    @Test
    public void RefrigeratorsTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(HomeAppliancesElementLocator))
                .perform();
//        Наведение курсора мыши на раздел ХОЛОДИЛЬНИКИ в под меню БЫТОВАЯ ТЕХНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(RefrigeratorsElementLocator))
                .perform();
//        Клик по элементу ХОЛОДИЛЬНИКИ в под меню БЫТОВАЯ ТЕХНИКА
        driver.findElement(RefrigeratorsElementLocator).click();
//        Проверка на наличие заголовка ХОЛОДИЛЬНИКИ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleRefrigeratorsElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел БЫТОВАЯ ТЕХНИКА при наведении на раздел КАТАЛОГ
    @Test
    public void HomeAppliancesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(HomeAppliancesElementLocator))
                .perform();
//        Клик по разделу БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        driver.findElement(HomeAppliancesElementLocator).click();

//        Проверка на наличие заголовка БЫТОВАЯ ТЕХНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleHomeAppliancesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел СТИРАЛЬНЫЕ МАШИНЫ после наведения на КАТАЛОГ и на БЫТОВАЯ ТЕХНИКА
    @Test
    public void WashingMachinesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(HomeAppliancesElementLocator))
                .perform();
//        Наведение курсора мыши на раздел СТИРАЛЬНЫЕ МАШИНЫ в под меню БЫТОВАЯ ТЕХНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(WashingMachinesElementLocator))
                .perform();
//        Клик по элементу СТИРАЛЬНЫЕ МАШИНЫ в под меню БЫТОВАЯ ТЕХНИКА
        driver.findElement(WashingMachinesElementLocator).click();
//        Проверка на наличие заголовка ХОЛОДИЛЬНИКИ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleWashingMachinesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел ЭЛЕКТРОНИКА при наведении на раздел КАТАЛОГ
    @Test
    public void ElectronicsTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Клик по разделу ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        driver.findElement(ElectronicsElementLocator).click();
//        Проверка на наличие заголовка ЭЛЕКТРОНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleElectronicsElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в разделы ТЕЛЕФОНЫ, ПЛАНШЕТЫ, ТЕЛЕВИЗОРЫ, ФОТО/ВИДЕО, ЧАСЫ после наведения на КАТАЛОГ
//    и с последующим наведением на раздел ЭЛЕКТРОНИКА в под меню раздела КАТАЛОГ
    @Test
    public void SubMenuElectronicsTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ТЕЛЕФОНЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(PhonesElement))
                .perform();
//        Клик по разделу ТЕЛЕФОНЫ
        driver.findElement(PhonesElement).click();
//        Проверка на наличие заголовка ТЕЛЕФОНЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitlePhoneElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ПЛАНШЕТЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(TabletsElement))
                .perform();
//        Клик по разделу ПЛАНШЕТЫ
        driver.findElement(TabletsElement).click();
//        Проверка на наличие заголовка ПЛАНШЕТЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleTabletsElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ТЕЛЕВИЗОРЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(TelevisionsElement))
                .perform();
//        Клик по разделу ТЕЛЕВИЗОРЫ
        driver.findElement(TelevisionsElement).click();
//        Проверка на наличие заголовка ТЕЛЕВИЗОРЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleTelevisionsElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ФОТО/ВИДЕО в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(PhotosVideosElement))
                .perform();
//        Клик по разделу ФОТО/ВИДЕО
        driver.findElement(PhotosVideosElement).click();
//        Проверка на наличие заголовка ФОТО/ВИДЕО
        Assert.assertTrue("Элемент не найден", driver.findElement(TitlePhotosVideosElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ЧАСЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(WatchesElement))
                .perform();
//        Клик по разделу ЧАСЫ
        driver.findElement(WatchesElement).click();
//        Проверка на наличие заголовка ЧАСЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleWatchesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел КНИГИ при наведении на раздел КАТАЛОГ
    @Test
    public void BooksTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на КНИГИ в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(BooksElementLocator))
                .perform();
//        Клик по разделу КНИГИ в под меню КАТАЛОГ
        driver.findElement(BooksElementLocator).click();
//        Проверка на наличие заголовка БЫТОВАЯ ТЕХНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleBooksElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел ОДЕЖДА при наведении на раздел КАТАЛОГ
    @Test
    public void ClothesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на КНИГИ в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ClothesElementLocator))
                .perform();
//        Клик по разделу КНИГИ в под меню КАТАЛОГ
        driver.findElement(ClothesElementLocator).click();
//        Проверка на наличие заголовка БЫТОВАЯ ТЕХНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleClothesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на поиск товара через поисковое поле
    @Test
    public void ProductSearchTest()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Ввод "iPad Air 2020 64gb wi-fi" в поле поиска
        driver.findElement(SearchFieldElement).sendKeys("ipad air 2020 64gb wi-fi");
//        Клик по кнопке поиска
        driver.findElement(ButtonSearSubmitElement).click();
//        Проверка на наличие заголовка искомого элемента ("iPad Air 2020 64gb wi-fi")
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleProductElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
//    Тест на проведение сортировки в разделе КАТАЛОГ - по популярности, по отзывам, последние,
//    по возрастанию цены, по убыванию цены
    @Test
    public void SortingTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//          Клик по элементу для перехода в КАТАЛОГ
        driver.findElement(CatalogElement).click();
//      Выбор элемента ВЫПАДАЮЩЕГО СПИСКА
        Select Sortig = new Select(driver.findElement(SortigElement));
//      Выбор из ВЫПАДАЮЩЕГО СПСИКА "По популярности"
        Sortig.selectByVisibleText("По популярности");
//      Проверка на соответсвие текста
        Assert.assertEquals("Текст не соответствует", "По популярности", driver.findElement(PopularityElement).getText());
//      Выбор элемента ВЫПАДАЮЩЕГО СПИСКА
        Select MenuOrderSortig = new Select(driver.findElement(SortigElement));
//      Выбор из ВЫПАДАЮЩЕГО СПСИКА "Обычная сортировка"
        MenuOrderSortig.selectByVisibleText("Обычная сортировка");
//      Проверка на соответсвие текста
        Assert.assertEquals("Текст не соответствует", "Обычная сортировка", driver.findElement(MenuOrderElement).getText());
//      Выбор элемента ВЫПАДАЮЩЕГО СПИСКА
        Select RatingSortig = new Select(driver.findElement(SortigElement));
//      Выбор из ВЫПАДАЮЩЕГО СПСИКА "По отзывам"
        RatingSortig.selectByVisibleText("По отзывам");
//      Проверка на соответсвие текста
        Assert.assertEquals("Текст не соответствует", "По отзывам", driver.findElement(RatingElement).getText());
//        Выбор элемента ВЫПАДАЮЩЕГО СПИСКА
        Select DateSortig = new Select(driver.findElement(SortigElement));
//      Выбор из ВЫПАДАЮЩЕГО СПСИКА "Последние"
        DateSortig.selectByVisibleText("Последние");
//      Проверка на соответсвие текста
        Assert.assertEquals("Текст не соответствует", "Последние", driver.findElement(DateElement).getText());
//      Выбор элемента ВЫПАДАЮЩЕГО СПИСКА
        Select PriceSortig = new Select(driver.findElement(SortigElement));
//      Выбор из ВЫПАДАЮЩЕГО СПСИКА "По возрастанию цены"
        PriceSortig.selectByVisibleText("По возрастанию цены");
//      Проверка на соответсвие текста
        Assert.assertEquals("Текст не соответствует", "По возрастанию цены", driver.findElement(PriceElement).getText());
//        Выбор элемента ВЫПАДАЮЩЕГО СПИСКА
        Select PriceDescSortig = new Select(driver.findElement(SortigElement));
//      Выбор из ВЫПАДАЮЩЕГО СПСИКА "По возрастанию цены"
        PriceDescSortig.selectByVisibleText("По убыванию цены");
//      Проверка на соответсвие текста
        Assert.assertEquals("Текст не соответствует", "По убыванию цены", driver.findElement(PriceDescElement).getText());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на наличие в разделе КАТАЛОГ блока КАТЕГОРИИ ТОВАРОВ
    @Test
    public void ProductCategoryPhonesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Клик на раздел КАТАЛОГ
        driver.findElement(CatalogElement).click();
//        Проверка на наличие элемента блока КАТЕГОРИИ ТОВАРОВ
        Assert.assertTrue("Элемент не найден", driver.findElement(ProductCategoryElementLocator).isDisplayed());
//        Проверка на наличие текста названия КАТЕГОРИИ ТОВАРОВ
        Assert.assertEquals("Текст не соответствует", "КАТЕГОРИИ ТОВАРОВ", driver.findElement(ProductCategoryElementLocator).getText());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на добавление товара в корзину в разделе КАТАЛОГ
    @Test
    public void AddBasketTest()
    {
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

    }
//----------------------------------------------------------------------------------------------------------------------
}
