package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle2 {

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
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

// bir dropdown ile calisirken son secilen option'a ulasmak isterseniz
// select.getFirstSelectedOption() method'unu kullanmalisiniz
// bu method bize WebElement dondurur
// uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir

        System.out.println(select.getFirstSelectedOption().getText()); // sectigimiz elementi yazdirdik


// dropdown'daki opsiyonlarin toplam sayisinin
//     28 oldugunu test edin

        List<WebElement> optionList=select.getOptions(); // bu bize list dondurdugu icin liste atadik

        int actualOptionSayisi=optionList.size(); // olan
        int expectedOptionSayisi=28; // beklenen

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
        driver.get("https://www.amazon.com");
        WebElement ddmm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selectt = new Select(ddmm);
        selectt.selectByVisibleText("Books");

// bir dropdown ile calisirken son secilen option'a ulasmak isterseniz
// select.getFirstSelectedOption() method'unu kullanmalisiniz
// bu method bize WebElement dondurur
// uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir

        System.out.println(select.getFirstSelectedOption().getText()); // sectigimiz elementi yazdirdik


// dropdown'daki opsiyonlarin toplam sayisinin
//     28 oldugunu test edin

        List<WebElement> optionListt=select.getOptions(); // bu bize list dondurdugu icin liste atadik

        int actualOptionSayisii=optionListt.size(); // olan
        int expectedOptionSayisii=28; // beklenen

        Assert.assertEquals(expectedOptionSayisii,actualOptionSayisii);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
