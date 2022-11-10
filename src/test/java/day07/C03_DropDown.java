package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    /*
     ●Bir class oluşturun:C3_DropDownAmazon
     ●https://www.amazon.com/ adresinegidin.

     -Test1
      Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
      oldugunu testedin

      -Test2
      1.Kategori menusunden Books seceneginisecin
      2.Arama kutusuna Java yazin vearatin
      3.Bulunan sonuc sayisiniyazdirin
      4.Sonucun Java kelimesini icerdigini testedin
       */

   static WebDriver driver;

   static Select select;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //olmadıgınu testedin

        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());

        /**
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
        butun elemanlarının sayısına ulasabiliriz
         */

        //dropdown menülerden çesitli yöntemler ile element locate etmek için kullanıyoruz


        int expectedSayi = 45;
        int actualDds= ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDds);

    }

    @Test
    public void test2() throws InterruptedException {

        /*
        -Test2
      1.Kategori menusunden Books seceneginisecin
      2.Arama kutusuna Java yazin vearatin
      3.Bulunan sonuc sayisiniyazdirin
      4.Sonucun Java kelimesini icerdigini testedin
       */
        //1- Kategori menusunden "Books" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        /*
        Eger dropdown menudeki option'a String olarak ulasmak istersek selectByVisibleText() method'u kullaniriz.
        Eger dropdown menunun index'i ile ulasmak istersek selectByIndex() method'u kullaniriz.
         */
        select.selectByIndex(5);
        //select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        Thread.sleep(2000);

        /*
        Dropdown menude sectigimiz option'a ulasmak istersek select.getFirstSelectedOption() method'unu kullaniriz.
         */
        System.out.println(select.getFirstSelectedOption().getText());
        //2- Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //3- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());

        String[] sonucArr = sonucSayisi.getText().split(" ");
        System.out.println("sonuc sayisi -> " + sonucArr[3]);

        //4- Sonucun Java kelimesini icerdigini test edin
        String expected = "Java";
        String actualSonuc = sonucSayisi.getText();
        Assert.assertTrue(actualSonuc.contains(expected));


    }



}

/**
selectByVisibleText () / deselectByVisibleText ()	görüntülenen metne göre bir seçeneği seçer / seçimi kaldırır
selectByValue () / deselectByValue ()	"value" öz niteliğinin değerine göre bir seçeneği seçer / seçimi kaldırır
selectByIndex () / deselectByIndex ()	indeksine göre bir seçeneği seçer / seçimi kaldırır
isMultiple ()	açılır öğe bir seferde birden fazla seçime izin veriyorsa, DOĞRU döndürür; Aksi takdirde YANLIŞ
Hiçbirini seçme()	önceden seçilen tüm seçeneklerin seçimini kaldırır
 */
