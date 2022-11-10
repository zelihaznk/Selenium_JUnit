package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IframeTest {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /**
         Iframe genellkikle bir web sayfasına doküman, video veya interaktif medya gibi
         başka bir kaynaktan içerik eklemek için kullanılır.
         */

        driver.get("https://the-internet.herokuapp.com/iframe");

    }
    @Test
    public void iframeTest() throws InterruptedException {

        /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText()); //konsola yazdırmak için getText() methodu kullanılır

        //○ Text Box’a “Merhaba Dunya!” yazin.

        //Locate ederken karşımıza ilk olarak iframe çıktığı için onu locate edip switchTo() yaptık
        WebElement textBoxFrame = driver.findElement(By.xpath("//*[@id='mce_0_ifr']")); //frame e gecis yapmadan önce frame'i  id ile locate ediyorum
        driver.switchTo().frame(textBoxFrame);//burada  frame e gecis yapiyorum
        Thread.sleep(2000);

        //switchTo() ile gectiğim için o alanı tekrar locate etmeliyim ve işlemleri yapmalıyım
        WebElement textBox=driver.findElement(By.xpath("//p"));//yazımı yazmak icin textBox ı locate ediyorum
        textBox.clear();//textBox'in icini temizlemek icin clear kullanıyorum
        Thread.sleep(2000);
        textBox.sendKeys("Merhaba dunya");//yazimi gönderiyorum


        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin


        //Ana frame geçmek için önce swichTo yapmalıyız. odadan cıkmadan solanu goremiyor
        driver.switchTo().defaultContent(); //iframe den çıkıp ana sayfaya çıkmak için kullanılır

        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }


}
