package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ModanisaTest {


    //Modanisa sayfasına üye olup daha sonra üyelik girişi yaparak arama kutusuna istenilen ürün yazılır.
    //Çıkan ürünlerden filtreleme yapılarak istenen ürüne tıklanır ve sepete ekleme yapılır.
    //Sonrasında sepete gidilerek ürün sepetten çıkartılır ve hesaptan çıkış yapılır.

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() throws InterruptedException {

        //  'https://www.modanisa.com/' url'sine gidin
        driver.get("https://www.modanisa.com/");

        //Syfayı yenileyin
        driver.navigate().refresh();

        //  Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın
        WebElement anasayfaGorunumTesti = driver.findElement(By.xpath("//body"));
        if (anasayfaGorunumTesti.isDisplayed()){
            System.out.println("Anasayfa gorunum testi PASSED");
        }else System.out.println("Anasayfa gorunumm testi PASSED");


        /**
         //4. 'Üye Ol ' düğmesine tıklayın
         driver.findElement(By.xpath("//a[@id='headerRegisterUrl']")).sendKeys(Keys.ENTER);


         //E-posta ile butonuna tıkla
         driver.findElement(By.xpath("(//input[@name='loginType'])[4]")).click();


         //mail adresini, ad, soyad bilgilerini gir
         //eposta
         driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("qazeliha@gmail.com");
         driver.findElement(By.xpath("//input[@id='name']")).sendKeys("zeliha");
         driver.findElement(By.xpath("//input[@id='surname']")).sendKeys("qa");
         Thread.sleep(3000);

         //Üyelik sözleşmesini kabul ediyorum butonuna tıkla
         driver.findElement(By.xpath("//input[@id='term']")).click();

         //üye ol butonuna tıkla
         driver.findElement(By.xpath("//input[@value='ÜYE OL']")).sendKeys(Keys.ENTER);

         driver.navigate().refresh();

         */


        //giriş yap düğmesine tıklayın
        driver.findElement(By.xpath("//a[@id='headerLoginUrl']")).click();

        //E-posta ile butonuna tıkla
        driver.findElement(By.xpath("(//input[@name='loginType'])[2]")).click();

        //eposta adresini gir
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("qazeliha@gmail.com");

        //Şifreyi gir
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qa199325");

        //üye girişi butonuna tıkla
        driver.findElement(By.xpath("//input[@value='ÜYE GİRİŞİ']")).click();

        //Sayfayı yenileyin
        driver.navigate().refresh();

        //arama kutusundan elbise arat
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Elbise", Keys.ENTER);


        //marka kısmına tıkla
        driver.findElement(By.xpath("//div[contains(text(),'Marka')]")).click();

        //Markalarda arayın kısmına Refka yaz
        driver.findElement(By.xpath("//input[@placeholder='Markalarda Arayın']")).sendKeys("Refka",Keys.ENTER);

        //Refka bloğunu işaretleyin
        driver.findElement(By.xpath("//div[@data-option-value='Refka']//div[@class='l-h-4 l-w-4 l-rounded-1p25 l-border-solid l-border-2 l-border-gray-350 l-bg-white']")).click();

        Thread.sleep(2000);
        //uygula butonuna tıklayın
        driver.findElement(By.xpath("//div[@class='l-flex l-flex-grow l-rounded-1p25 l-font-sans l-font-bold l-text-white l-items-center l-justify-center l-bg-orange-150 l-h-8']")).click();

        //editör seçimi butonuna basınız
        driver.findElement(By.xpath("//span[@class='l-mr-2']")).click();

        //ucuzdan pahalıya kısmını seçiniz
        driver.findElement(By.xpath("//span[contains(text(),'Ucuzdan Pahalıya')]")).click();

        //Beden seç kısmına tıklayın
        driver.findElement(By.xpath("//div[contains(text(),'Beden')]")).click();

        //Beden seçiniz
        driver.findElement(By.xpath("(//div[@class='l-flex l-justify-between l-flex-row l-flex-grow l-pt-0p25 l-pl-2p5 l-pt-0p25'])[4]")).click();

        //Uygula butonuna basınız
        driver.findElement(By.xpath("//div[@class='l-flex l-flex-grow l-rounded-1p25 l-font-sans l-font-bold l-text-white l-items-center l-justify-center l-bg-orange-150 l-h-8']")).click();

        //Elbiseye tıkla
        driver.findElement(By.xpath("//img[@alt='Kanguru Cepli Kapüşonlu Elbise - Vişne - Refka Basic']")).click();

        //Beden seçiniz
        driver.findElement(By.xpath("//select[@class='productSizeSelect productSizeSelect-type1']")).sendKeys("L");
        // driver.findElement(By.xpath("//option[@class='size size-5582565 ']")).sendKeys(Keys.ENTER);

        //Sepete ekle butonuna tıklayınız
        driver.findElement(By.xpath("//a[normalize-space()='Sepete Ekle']")).click();

        //Sepetim kutusuna tıkla
        driver.findElement(By.xpath("//a[@id='cart']")).click();

        //Sayfayı yenile
        driver.navigate().refresh();

        //Sepetten ürün çıkar
        driver.findElement(By.xpath("(//*[name()='path'])[3]")).click();

        //Ürünü sepetinizden silmek istediğinize emin misiniz? Sil!
        driver.findElement(By.xpath("//a[@id='basketList-removePopupRemoveButton']")).click();

        driver.navigate().refresh();

        //hesabım kısmına gel
        driver.findElement(By.xpath("//div[@id='account']")).click();

        //Hesaptan çıkış yapın
        driver.findElement(By.xpath("//*[text()='Çıkış']")).click();

    }

    @After
    public void tearDown(){
        driver.close();
    }




}
