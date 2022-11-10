package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBaseBeforeAfter;

public class C02_FileExistUpload extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. dosya sec butonuna basalim
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));

        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */

        /*Benim yöntemim
        actions = new Actions(driver);
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        actions.click(dosyaSec).perform();
         */


        //4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\Zeliha Öznük\\Downloads\\test.txt";
        dosyaSec.sendKeys(dosyaYolu);

        ///5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());


    }
}
