package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBaseBeforeClassAfterClass;

public class C05_MauseActions2 extends TestBaseBeforeClassAfterClass {

    /*
    Yeni bir class olusturalim: MouseActions2
    https://demoqa.com/droppable adresine gidelim
    “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test() throws InterruptedException {

        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        Thread.sleep(2000);
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        //Actions actions = new Actions(driver); protected olarak diğer cassda kullandığımız için oldu
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe,dropHere).perform(); //actionsun harekete geçebilmesi için perform konulmalısır

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }


}
