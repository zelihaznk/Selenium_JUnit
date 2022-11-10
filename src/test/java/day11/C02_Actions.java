package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBaseBeforeClassAfterClass;

public class C02_Actions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://tr-tr.facebook.com/");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //Actions actions = new Actions(driver);
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));
        isim.sendKeys("Zeliha");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Oznuk").sendKeys(Keys.TAB)
                .sendKeys("05436666666").sendKeys(Keys.TAB)
                .sendKeys("qazeliha@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("123456789").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("16").sendKeys(Keys.TAB).sendKeys("Mar")
                .sendKeys(Keys.TAB).sendKeys("1993")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // 4- Kaydol tusuna basalim


    }
}
