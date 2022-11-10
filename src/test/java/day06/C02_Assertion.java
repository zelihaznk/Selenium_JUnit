package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {

    // assertTRUE (TRUE)---> PASSED
    // assertFALSE (FALSE)---> PASSED
    // assertTRUE (FALSE)---> FAILED
    // assertFALSE (TRUE)---> FAILED


    /*
     Amazon sayfasina git
     3 farkli test method'u olustur
     - url'in "amazon" icergini test et
     - title'in "facebook" icermedigini test et
     - sol ust kosede amazon logosunun gorundugunu test et
     */

   static   WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //BeforeClassta herhangi bir şey yazılmadığı için yani bir yere git demediğimiz için boş bir sayfa açar

        driver.get("https://amazon.com/");  //Tüm testlerde tekrar tekrar yazmamak için get
                                            // methodunu buraya kaydediyoruz tek tek tüm testleri
                                            //çalıştırırken boş sayfa açılmaması burada tanımladık

        // Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
        // BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
        // BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.


    }

    @Test
    public void test1(){
        //- url'in "amazon" icergini test et

        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //Osayfa eğer içeriyorsa true yaparız karşılaştırma yapılırken

        /*
        ESKİ YÖNTEM
        String amazonTitle ="amazon";
        if (driver.getCurrentUrl().contains(amazonTitle)) {
            System.out.println("Url testi PASSED");
        }
         */

    }


    @Test
    public void test2(){
       // - title'in "facebook" icermedigini test et

        Assert.assertFalse(driver.getTitle().contains("facebook"));

        //Sayfa içermediği içinde burada False yaptık

        /*
        ESKİ YÖNTEM
        String facebookTitle="Facebook";
        if (driver.getTitle().contains(facebookTitle)) {
            System.out.println("Title iceriyor,test basarili");
        }

         */
    }

    @Test
    public void test3(){
        // - sol ust kosede amazon logosunun gorundugunu test et
        Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
