package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BasicAuthentication {

    /*
    1- Bir class olusturun : BasicAuthentication
    2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username : admin
    password : admin
    4- Basarili sekilde sayfaya girildigini dogrulayin
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test(){

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //    Html komutu : https://username:password@URL
        //    Username : admin
        //    password : admin
        //    4- Basarili sekilde sayfaya girildigini dogrulayin

        //    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //https:// sonrası önce Username : admin kısmı "https://admin olarak yazıldı
        //daha sonra https://admin kısmından sonra password : admin kısmını :admin olarak yazıyoruz
        //son olarak da driver.get("https://the-internet.herokuapp.com/basic_auth");
        // kısmındaki @the-internet.herokuapp.com/basic_auth yazılır ve
        // sonuc: driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); olur

        //    4- Basarili sekilde sayfaya girildigini dogrulayin
       Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());



    }
}
