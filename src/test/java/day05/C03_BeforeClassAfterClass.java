package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    /**
   BeforeClass ve AfterClass notasyonlari kullaniyorsak
   olusturacagimiz method'u static yapmammiz gerekiyor
    */


     // BeforeClass - AfterClass ---> BeforeClass+Test+Test+Test+AfterClass çalışıyor sırayla (toplam 5 method çalışıyor)
     // Tüm testleri aynı browser'da açtı, son testten sonra browser'ı kapattı
     // Before - After ---> Before+Test+After    Before+Test+After   Before+Test+After şeklinde (toplam 9 method çalışıyor)

    /**
    beforeclass-afterclass kullanirsak ayni browserda islem yaapar once beforeclass calisir arada 3 method calisir
    en son afterclass calisir. Toplam da 5 method calisir
    */

    //BeforeClass ve AfterClass da bir kere calısır // before ve after da 3 kere çalısır
    static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }
    @Test
    public void test02() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://techproeducation.com");
    }
    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }


}
