package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {

    // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    // Click for JS Alert butonuna tıklayalım
    // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test1(){

        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim

        System.out.println(driver.switchTo().alert().getText()); //Alert mesajını yazdırır

        driver.switchTo().alert().accept(); //uyarıyı gecmek icin kullanırız, uyarıyı gecmeyi kabul et gibi bir anlamı var.

        //driver.switchTo().alert().dismiss(); //iki secenek cıktığınıda iptal e basmak istiyorsak dismiss kullanacağız

        //tamam demek istiyorsak accept kullanacağız
        //uyarıdaki alert mesaj yazısını almak istiyorsak getText() kullanacağız.
    }

    /**
    Handle Allert Methods

     ● accept( ) => Bir uyarıda(alert) OK'ı tıklamakla aynı. Tamam tuşuna basmakla aynı şey
     driver.switchTo( ).alert( ).accept( );

     ● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı. İptale basmak için kullanılır
     driver.switchTo( ).alert( ).dismiss( );

     ● getText() => Uyarıdaki(alert) mesajı almak için.
     driver.switchTo( ).alert( ).getText( );

     ● sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için
     driver.switchTo( ).alert( ).sendKeys("Text");
     */





}
