package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void test1(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        //Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/"));  böyle de doğru cevabı bulursunuz test PASSED olur

        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test2(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        //Assert.assertFalse(driver.getTitle().contains("Rest"));  Bu şekilde de test PASSED olur

        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }

    @Test
    public void test3(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        //Assert.assertTrue(driver.findElement(By.xpath("//img[@class='logo'][1]")).isDisplayed());  Bu şekilde de test PASSED olur

        WebElement logo=driver.findElement(By.xpath("//img[@class='logo'][1]"));
        Assert.assertTrue(logo.isDisplayed());


    }

    @Test
    public void test4(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        //Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Français']")).isDisplayed());  Bu şekilde de test PASSED olur

        WebElement francaisLinkTest=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisLinkTest.isDisplayed());

    }

    @AfterClass
    public static void teadDown(){
        driver.close();
    }



}
