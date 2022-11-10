package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    // 1.Bir Class olusturalimYanlisEmailTesti
    // 2.http://automationpractice.com/index.php sayfasina gidelim
    // 3.Sign in butonuna basalim
    // 4.Email kutusuna @isareti olmayan bir mail yazip enter'a
    // 5.bastigimizda “Invalid email address” uyarisi ciktigini test edelim

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test() throws InterruptedException {

        Thread.sleep(2000);
        // 3.Sign in butonunabasalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

        //4.Email kutusuna @isareti olmayan bir mail yazip enter'a basınız
        driver.findElement(By.id("newsletter-input")).sendKeys("zzzgmail.com", Keys.ENTER);

        // 5.bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='alert alert-danger']")).isDisplayed());

    }

    @After
    public void tearDown(){
        //driver.close();
    }







}
