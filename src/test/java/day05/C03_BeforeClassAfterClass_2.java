package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C03_BeforeClassAfterClass_2 {

    /**
    befero afterda her test icin farkli browser acip kapatiyor
    beforeClass AfterClass'ta ise tek browser'dan testleri acip kapatiyor
     */

    /**
   BeforeClass ve AfterClass notasyonları kullanıyorsak oluşturacağımız method'u static yapmamız gerekiyor
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    @Ignore
    /**
    Çalışmasını istemediğimiz test için @Ignore notasyonu kullanılır
     */
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }
    @Test
    public void method2() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}


