package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_IFrame {

    /**
    Iframe nedir?
    ➢ IFrame, bir web sayfasına icine yerlestirilmis baska
    bir web sayfasıdır veya bir HTML dokumaninin içine
    yerleştirilmiş baska bir HTML dokumanidir.
    ➢ IFrame genellikle bir Web sayfasına dokuman, video
    veya interaktif media gibi başka bir kaynaktan içerik
    eklemek için kullanılır. <iframe> tag’ı bir inline frame
    belirtir.
    https://html.com/tags/iframe/

    IFrame,birwebsayfasınaicineyerlestirilmisbaskabirwebsayfasıdırveyabirHTMLdokumanininiçineyerleştirilmişbaskabirHTMLdokumanidir.
     */

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

    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test(){
        driver.get("https://html.com/tags/iframe/");

        //Önce List'e attık çünkü siteye her giriş yaptığımızda tekrar tekrar çıkan videolar konusunda sıkıntı yaşamayalım

        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        /**
        Bir web sitesinde bir video(youtube vs) varsa <iframe> tag'i içerisindeyse
        bu video'yu direkt locate edip çalıştırmak dinamik olmaz.
        Çünkü link değişebilir ve locate'imiz çalışmaz.
        Bunun için bütün frame'leri bir array liste atıp index ile frame'i
        seçip sonrasında play tuşunu locate edip çalıştırabiliriz.
        */

        /*
        Bu şekilde de yapılabilirdi:

        WebElement youtableFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtableFrame);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
         */



    }

}
