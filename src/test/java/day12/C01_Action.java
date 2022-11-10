package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBaseBeforeAfter;

public class C01_Action extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        //Automationexercises.com adresine gidelim
        driver.get("https://www.automationexercise.com/");

        //product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        //ilk ürünü tıklamayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//burada bu şekilde sayfayı aşağıya çekip yaparız
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();

        /**
        Burada .sendKeys(Keys.PAGE_DOWN).perform(); ile sayfayı aşağıya indirip click yaptık
        sayfayı aşağıya indirmek için .sendKeys(Keys.PAGE_DOWN).perform(); kullanılır
         */

    }
}
