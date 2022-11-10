package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.TestBaseBeforeAfter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class homework extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {

       /*
      Ödev 1

"http://webdriveruniversity.com/Actions" sayfasina gidin
"Hover over Me First" kutusunun ustune gelin
"Link 1" e tiklayin
Popup mesajini yazdirin
Popup'i tamam diyerek kapatin
"Click and hold" kutusuna basili tutun
"Click and hold" kutusunda cikan yaziyi yazdirin
"Double click me" butonunu cift tiklayin
     */

        //"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //"Hover over Me First" kutusunun ustune gelin
        WebElement howerOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(howerOverMeFirst).perform();//moveToElement Masuse i istediğimiz web elementin üzerinde tutar
        Thread.sleep(5000);

        //"Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();

        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //"Click and hold" kutusuna basili tutun
        WebElement clickHoldButton = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickHoldButton).perform();
        Thread.sleep(3000);

        //"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHoldButton.getText());

        //"Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleClick);

        driver.quit();

    }

    @Test
    public void test2() {

        /*
        Ödev 2
"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
"Our Products" butonuna basin
"Cameras product"i tiklayin
Popup mesajini yazdirin
"close" butonuna basin
"WebdriverUniversity.com (IFrame)" linkini tiklayin
"http://webdriveruniversity.com/index.html" adresine gittigini test edin
         */

        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //"Our Products" butonuna basin
        WebElement outProducts = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(outProducts);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        //"Cameras product"i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        //Popup mesajini yazdirin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        String popUp = driver.findElement(By.className("modal-body")).getText();
        System.out.println(popUp);

        //"close" butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.switchTo().defaultContent(); //en üstteki switch'e çıkmak için kullanılır

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("//*[text()=\"WebdriverUniversity.com (IFrame)\"]")).click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/index.html"));

        driver.quit();

    }

    @Test
    public void test3() {

        /*
        Ödev 3

1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a  kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve  "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
Ilk sayfaya geri donun
Ilk sayfaya donuldugunu test edin
   */
      //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement loginPortal = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));

        //3."Login Portal" a tiklayin
        loginPortal.click();

        //4.Diger window'a gecin
        List<String> windowHandle = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1));

        //5."username" ve  "password" kutularina deger yazdirin
        //username
        WebElement username = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        actions.clickAndHold();
        username.sendKeys(faker.name().username());
        //password
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        actions.clickAndHold();
        password.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String axpectedPopup ="validation failed";
        String actualPopup = driver.switchTo().alert().getText();
        Assert.assertEquals(actualPopup,axpectedPopup);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //Ilk sayfaya geri donun
        driver.switchTo().window(windowHandle.get(0));

        //Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(loginPortal.isDisplayed());

        driver.quit();
    }
}
