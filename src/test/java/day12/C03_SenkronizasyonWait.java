package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {

    @Test
    public void implicitWaitTest1() {

        // 1. Bir class olusturun : WaitTest
        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //    Iki metod icin de asagidaki adimlari test edin.

                /**
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler
                  */


        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //  Implicitly Wait:   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))


    }

    @Test
    public void explicitWaitTest2() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  //EXPLICIT WAIT kullanmak için bunu yaptık

        //mesajı almak için: WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("..."))); yapılmalıdır
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        //     Görüntülene kadar bekle
        //         Sonra doğrula
        Assert.assertTrue(itsGoneWE.isDisplayed());

        /**
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());


        //    Explicitly Wait
        //1-Webdriver Wait wait=newWebDriverWait(driver,Duration.ofSecond(20))
        //
        // 2-WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("…")))


    }
        /**
İlk olarak belirli miktarda bekleme süresi ile wait object
create edilir.
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
Olusturdugumuz wait objesi sayesinde WebDriverWait class’indan
until( ) method’u ile birlikte ExpectedConditions Class’ini kullanabiliriz.
Ornegin WebElement’i locate etmek icin wait object’i kullanma
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("...")));

     */

        //İmplicitly ile her elementi Max 15 sn bekletiyoruz ama bir yerde 30 saniye beklemesi gerekiyorsa o zaman eksplicitly kullanıyoruz

    //todo implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
    // explicitly wait ise once obje olarak olusturulur sonra
    // sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz
}
