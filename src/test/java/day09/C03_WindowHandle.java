package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {
    /*
    Yeni bir class olusturun: WindowHandle
    Amazon anasayfa adresine gidin.
    Sayfa’nin window handle degerini String bir degiskene atayin
     Sayfa title’nin “Amazon” icerdigini test edin
Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
Sayfa title’nin “Walmart” icerdigini test edin
Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


    @Test
    public void test(){

        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");

        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String ecpectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(ecpectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com/");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedTitle = "TECHPROEDUCATION";
        String actualTitle2 = driver.getTitle();
        Assert.assertFalse(actualTitle2.contains(ecpectedTitle));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");

        //Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = "Walmart";
        Assert.assertTrue(driver.getTitle().contains(walmartTitle));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));

    }
}
