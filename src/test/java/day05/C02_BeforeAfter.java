package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    //@Before : Önce ; @After : Sonra Demek. @Test kısmında yazdığımız methodlar; çalışmaya başlamadan önce
   // @Before yazan method çalışır; sonra kendisi çalışır ve en son olarak ta @After da yazılan method çalışır...
  // Bu durum her @Test methodun da aynı şekilde devam eder. @After ve @Before methodlarının nerde yazıldığının önemi yoktur

public class C02_BeforeAfter {

    WebDriver driver; //Bu kısmı yukarıda tanımlamamızın tek sebebi Before kısmında kodlarımın hatasız çalışmasını sağlamaktır.
                      //Ayrıca diğer testlerimizde de daha kolay kullanabilmek için "class" seviyesinde tanımlıyoruz.
                      //driver objesi bu sebeple daha iyi çalışır.

    @Before

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /**
    bir class da;
     -->@before ile olusturulan method class icindeki her test method'undan once ve 1 kez calisir ve
     genellikle public  void setup() seklinde yazilir
     -->@after ile olusturlan method class icindeki her test method'undan sonra ve 1 kez calisir ve
     genellikle public void tearDown() seklinde yazilir
     */

    @Test

    public void method1(){
        //Burada bir defa before methodu çalışır

        driver.get("https://amazon.com");

        //Bir defada after methodu çalışır.
    }

    @Test
    public void method2(){
        //Burada bir defa before methodu çalışır

        driver.get("https://techproeducation.com/tr/");

        //Bir defada after methodu çalışır.
    }

    @Test
    public void method3(){
        //Burada bir defa before methodu çalışır

        driver.get("https://www.hepsiburada.com/");

        //Bir defada after methodu çalışır.
    }

    @After
    //After notasyonu her testten sonra çalışır

    public void tearDown(){
        driver.close();
    }


}
