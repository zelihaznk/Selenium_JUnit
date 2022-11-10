package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
/*
➢ Adim1: Dropdown menuyu herhangi bir locator ile locate edin.
WebElement ddm=driver.findElement(By.id(“value of id"));
➢ Adim 2: Yeni bir “Select” objesi olusturun ve daha once
locate ettigimiz WebElement’i parametre olarak yeni
objeye ekleyin
Select options=new Select(ddm);
➢ Adim 3: Select class’indan kullanabileceginiz 3
yontemden biriyle dropdown menusundeki
elemananlardan istediginizi secin
options.selectByIndex(1);
 */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //olmadıgınu testedin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size()); //Bu kısımda sayısını yazdırdık sayı yazdırmak istediğimiz zaman List yaparız

        //Buradan sonra ise 28 tanenin isimlerini yazdırdık
        for (WebElement each:drops) {
            System.out.println(each.getText());
        }

        //Beklenen sayı kısmını burada gerçekleştirip eşit değil dedik
        int dropDownList = drops.size();
        int expectedSize = 45;
        Assert.assertNotEquals(dropDownList,expectedSize);

        /*
        İKİNCİ YOL:
        WebElement menu=driver.findElement(By.id("searchDropdownBox"));
        Select select= new Select(menu);
        List<WebElement> listMenu=select.getOptions();
        System.out.println("listMenu.size() = " + listMenu.size());

         */

    }

    @Test
    public void test2(){


         /*
        -Test2
      1.Kategori menusunden Books seceneginisecin
      2.Arama kutusuna Java yazin vearatin
      3.Bulunan sonuc sayisiniyazdirin
      4.Sonucun Java kelimesini icerdigini testedin
       */

        //1.Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");

        //2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        String sonuc=driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']")).getText();
        String[] sonucArr=sonuc.split(" ");
        System.out.println("sonuc sayisi = " + sonucArr[3]);

        //  4. Sonucun Java kelimesini icerdigini test edin
        String sonucYazi=driver.findElement(By.xpath("//*[text()='\"Java\"']")).getText();
        Assert.assertTrue(sonucYazi.contains("Java"));

    }

    @After
    public void tearDown(){
        driver.close();
    }




}
