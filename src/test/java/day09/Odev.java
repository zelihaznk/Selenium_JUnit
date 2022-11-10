package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class Odev {

    /*
    ● Bir class olusturun: IframeTest02
1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
tıklayınız
     */

    //Bir class olusturun: IframeTest02
    //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //sayfadaki iframe sayısını bulunuz.
    //ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //ilk iframe'den çıkıp ana sayfaya dönünüz
    //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //Bir class olusturun: IframeTest02
        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayi = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe sayisi : " + iframeSayi.size());
        //ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@width='560']")));
        WebElement youtube=driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        youtube.click();
        Thread.sleep(3000);
        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        driver.switchTo().frame(driver.findElement(By.id("a077aa5e")));
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();

    }

}
