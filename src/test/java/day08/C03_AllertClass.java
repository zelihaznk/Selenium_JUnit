package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AllertClass {
    /**
     bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
     eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
     ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
     bu tür alertlere  js alert denir.
     js alert'lere müdahale edebilmek icin

     -- tamam ya da ok icin
     driver.switchTo().alert().accept();

     --iptal icin
     driver.switchTo().alert().dismiss();

     --alert icindeki mesajı almak icin
     driver.switchTo().alert().getText();

     --alert bizden bir metin istiyorsa
     driver.switchTo().alert().sendKeys("");

     methodları kullanilir!!
     */



    /*
    Handle Allert Class Work
   ● Bir class olusturun: Alerts
   ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
   ● Bir metod olusturun: acceptAlert
   ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
   “You successfully clicked an alert” oldugunu test edin.
   ● Bir metod olusturun: dismissAlert
   ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
   “successfuly” icermedigini test edin.
   ● Bir metod olusturun: sendKeysAlert
   ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
   tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void acceptAlert(){

        // ● Bir metod olusturun: acceptAlert
        //   ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //   “You successfully clicked an alert” oldugunu test edin.

         driver.findElement(By.xpath("//*[text()='Click for JS Alert']")) .click();
         driver.switchTo( ).alert( ).accept(); //ok butonuna basabilmek için yaptık

        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj,actualMesaj);

        //Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());
        //Kısa yollu çözüm de doğru

    }

    @Test
    public void dismissAlert() throws InterruptedException {

        //● Bir metod olusturun: dismissAlert
        //   ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //   “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();


        //Allert üzerindeki mesajı ekleyin
        System.out.println("2. butonunun allert mesaji = " + driver.switchTo().alert().getText());  //2. butonun allert mesajını yazdırdık

        Thread.sleep(2000);
        //önce mesajı gördük şimdi iptal yapıyoruz
        driver.switchTo().alert().dismiss();

        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));

        /*
        Bu yöntemle de yapılabilirdi
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "successfuly";
        Assert.assertEquals(expectedMesaj,actualMesaj);
        */

    }


    @Test
    public void sendKeysAlert() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        //   ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //   tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        System.out.println("*****************************************");

        //Allert üzerindeki mesajı ekleyin
        System.out.println("3. butonunun allert mesaji = " + driver.switchTo().alert().getText()); //3. butonun allert mesajını yazdırdık

        Thread.sleep(2000);

        //uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.switchTo().alert().sendKeys("Zeliha");
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
        WebElement isim=driver.findElement(By.xpath("//*[text()='You entered: Zeliha']"));
        String expectedisim="Zeliha";
        String actualMessage=isim.getText();
        Assert.assertTrue(actualMessage.contains(expectedisim));



    }




}
