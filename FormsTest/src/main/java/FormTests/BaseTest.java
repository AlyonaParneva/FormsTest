package FormTests;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static IndexPage indexPage;
    protected static MiddlePage middlePage;
    protected static FormPage formPage;

    @BeforeAll
    public static void setup() {
        // определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        // создание экземпляра драйвера
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        middlePage = new MiddlePage(driver);
        formPage=new FormPage(driver);
        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста = 10 сек.
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("indexpage"));
    }
}
