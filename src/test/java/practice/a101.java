package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class a101 {

    /*Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.

   Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur. En az Web’de yapmak zorunlu.
- Senaryoya üye kaydı oluşturmadan devam edilecek.
- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
- Açılan ürünün siyah olduğu doğrulanır.
- Sepete ekle butonuna tıklanır.
- Sepeti Görüntüle butonuna tıklanır.
- Sepeti Onayla butonuna tıklanır.
- Üye olmadan devam et butonuna tıklanır.
- Mail ekranı gelir.
- Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.


     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        //A101 sayfasına gidilir //"https://www.a101.com.tr/"
        driver.get("https://www.a101.com.tr/");

        //Çerazleri kabul et butonu tıklanır
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();


        //Çıkmadan önce gözat kısmı kapatılır
       // driver.findElement(By.xpath("//*[text()='X']")).click();

        //sayfayı yenile
        //driver.navigate().refresh();

        //giyim aksesuar tıklanır
        driver.findElement(By.xpath("(//*[@title='GİYİM & AKSESUAR'])[1]")).click();

        //Kategorilerden kadın içgiyim seçilir
        driver.findElement(By.xpath("//a[@data-value='1565']")).click();
        Thread.sleep(2000);

        //seçeneklerden kadın dizaltı çorap seçilir
        driver.findElement(By.xpath("//a[@data-value='1567']")).click();

        //İlk çıkan çorap tıklanır
        driver.findElement(By.xpath("//*[@alt='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")).click();

        //Siyah olduğu doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='SİYAH']")).isDisplayed());

        //sayfa yenilenir
        driver.navigate().refresh();

        //Sepete ekle butonu tıklanır
        driver.findElement(By.xpath("//*[@class='add-to-basket button green block with-icon js-add-basket']")).click();

        Thread.sleep(3000);

        //Sepeti görüntüle butonu tıklanır
        driver.findElement(By.xpath("(//*[text()='Sepeti Görüntüle'])[2]")).click();

        Thread.sleep(3000);

        //Sepeti onayla butonu tıklanır
        driver.findElement(By.xpath("//*[@class='button green checkout-button block js-checkout-button']")).click();

        Thread.sleep(3000);

        //Üye olmadan devam et butonu tıklanır
        driver.findElement(By.xpath("//*[@title='ÜYE OLMADAN DEVAM ET']")).click();

        Thread.sleep(3000);

        //Mail ekranı gelir. Ekranın geldiği doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-inner']")).isDisplayed());

        Thread.sleep(3000);

        //Bir mail adresi girilir.
        driver.findElement(By.xpath("//*[@name='user_email']")).sendKeys("qazeliha@gmail.com", Keys.ENTER);

        Thread.sleep(3000);

        //Adres ekranı gelir. Ekranın geldiği doğrulanır.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-checkout js-page-checkout js-tab-box']")).isDisplayed());

        Thread.sleep(3000);

        //Adres oluştur seçeneğine tıklanır
        driver.findElement(By.xpath("(//*[@class='new-address js-new-address'])[1]")).click();


        //Adres ekleme kısımları doldurulur
        Thread.sleep(3000);

        //Adres Başlığı
        driver.findElement(By.xpath("//*[@placeholder='Ev adresim, iş adresim vb.']")).sendKeys("Ev");

        Thread.sleep(3000);

        //Ad
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Zeliha");

        Thread.sleep(3000);

        //Soyad
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("QA");

        Thread.sleep(3000);

        //Telefon
        driver.findElement(By.xpath("//*[@name='phone_number']")).sendKeys("5436549871");

        Thread.sleep(3000);

        //İl seçiniz
        driver.findElement(By.xpath("//*[@name='city']")).sendKeys("Bursa");

        Thread.sleep(4000);

        //İlçe seçiniz
        driver.findElement(By.xpath("//*[@name='township']")).sendKeys("Nilüfer");


        Thread.sleep(5000);

        //Mahalle seçiniz
        driver.findElement(By.xpath("//*[@class='js-district']")).sendKeys("BEŞEVLER MAH");

        Thread.sleep(4000);

        //Adresinizi yazınız
        driver.findElement(By.xpath("//*[@name='line']")).sendKeys("Konak Mahallesi gökçe gül apartmanı no:2/2");

        Thread.sleep(4000)
        ;
        //Posta kodunu yazınız
        //driver.findElement(By.xpath("//*[@name='postcode']")).sendKeys("16265");

        Thread.sleep(3000);

        //Kaydet butonuna tıklanır
        driver.findElement(By.xpath("//*[@class='button green js-set-country js-prevent-emoji']")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        //Kaydet butonuna tıklayıp çıkıs yapılır
        //WebElement x = driver.findElement(By.xpath("//*[@class='close js-modal-close']"));
        //x.click();
        //Thread.sleep(4000);

        //MNG Kargo seçilir
        //driver.findElement(By.xpath("(//div[@class='radio'])[4]")).click();

        //driver.navigate().refresh();

        //Kaydet ve devam et butonu tıklanır
         driver.findElement(By.xpath("//button[@class='button block green js-proceed-button']")).click();

         Thread.sleep(3000);

         //Ödeme ekranına gelindiği doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-checkout js-page-checkout js-tab-box']")).isDisplayed());






    }




}
