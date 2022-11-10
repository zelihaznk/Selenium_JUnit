package utilites;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeAfter {

    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;

    protected String tarih;
    protected  LocalDateTime date;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
        faker = new Faker();

        date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        tarih = date.format(formater);
    }

    @After
    public void tearDown(){
       // driver.quit();
    }

    /**
    TestBase, testlerden önce ve sonra tekrar tekrar
    kullandığımız kodları içermektedir.

    ●İçerisindeki metodları kullanabilmemiz icin extends
    yapıyoruz. Bu sayede test class’ımızda sadece test
    case’ler bulunmaktadır.

    ● Utilities package’da TestBase’i oluşturuyoruz.
    ○ setUp method
    ○ reports (Raporlar)
    ○ tearDown method

    ●TestBase class’i abstract yapabiliriz (Olmasada
    olabilir) , extends yaparak kullanabiliriz. Ve bu
    class’da object create edemeyiz.

    ● olusturdugumuz driver’in farkli package’lardan kullanabilmek icin PROTECTED yapariz
     */




}
