package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test() throws InterruptedException {


        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle(); //Bu satırda amazon sayfasının handle değerini verdik ki daha oraya gidebilelim

        /**
        Eğer bize verilen task'de sayfalar arası geçiş varsanher driver.get() methodundan sonra
        driver'in window handla değerini bir String değişkene atarız.
        Sonrasında farklı bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz.
         */

        //2- Url'nin amazon içerdiğini test edelim

        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)

        driver.switchTo().newWindow(WindowType.WINDOW); // yeni pencere açmak için kullanılır Yeni window olusturup geçiş yapma(switch)
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle=driver.getWindowHandle();//Bu satırda bestbuy sayfasının handle değerini verdik ki daha oraya gidebilelim

        //4- title'in BestBuy içerdiğini test edelim

        String expectedTitle="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım

        driver.switchTo().window(amazonWindowHandle); //Burada amazon sayfasına geçmek için yukarıda tanımladığımız
                                                     // amazon değeri ile driver.switchTo().window(amazonWindowHandle) yaptık
        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim

        WebElement sonucYazi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedWord="java";
        String actualWord=sonucYazi.getText();
        Assert.assertTrue(actualWord.contains(expectedWord));

        //7- Yeniden bestbuy sayfasına gidelim

        driver.switchTo().window(bestBuyHandle);//Burada bestbuy sayfasına geçmek için yukarıda tanımladığımız
                                               // bestbuy değeri ile driver.switchTo().window(bestBuyHandle) yaptık

        //8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        logo.isDisplayed();




    }



    @AfterClass
    public static void tearDown(){
      driver.quit();
    }
}
