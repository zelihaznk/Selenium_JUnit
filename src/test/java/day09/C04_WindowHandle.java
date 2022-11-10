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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
doğrulayın.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();


        /**
        Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir ArrayList'e
        atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
        ve ikinci acilan pencere veya sekmede islem yapabilmek icin
        driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
        */

        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());//sayfalar arası geçiş kolay olsun diye bu şekilde çözdük.
        System.out.println("Window Handle degerleri :"+windowList);
        driver.switchTo().window(windowList.get(1));




        /**
        NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
        açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.
        Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
        hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.
        Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))
        Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
        0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
        */

        /*
        Bu şekilde de yapılabilir ama uzun yoldan oluyor:
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.
        driver.switchTo().window(windowList.get(0)); //İlk sayfaya dönmek için get içine (0) koymamız lazım
        //1. yol:
        Assert.assertEquals("The Internet",driver.getTitle());
        //2. yol:
        Assert.assertTrue(driver.getTitle().contains("The Internet"));



    }



}
