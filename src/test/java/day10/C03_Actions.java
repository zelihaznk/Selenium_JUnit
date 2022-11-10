package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBaseBeforeClassAfterClass;

public class C03_Actions extends TestBaseBeforeClassAfterClass {

    @Test
    public void test(){

        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //-Account menüsünden create a list linkine tıklayalım
        WebElement accountList = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));

        Actions actions = new Actions(driver); //Burada öncelikle mause hareketi yapacağımız için bir obje oluşturmamız gerekiyor
        actions.moveToElement(accountList).perform();//Daha sonra ise fareyi üzerine getir ve bekle dedik
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        /*
        Bir web sitesinde bir web elementin mause ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi taktirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElemenNotInteractableException: element not interactable exception'i fırlatır
         */

        /**
        1.Adım: Actions class’ta bir object oluşturulur.
        Actions actions= new Actions(driver);

        ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement
        öğesini bulunur.
        WebElement element = driver.findElement(By.id("ID"));

        ➢ 3.Adim : Ardından bu webelement üzerinde action
        gerçekleştirilir. Örneğin tıklamak için.
        actions.click(element).perform( );
        NOT : Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez.
        action objesi kullanilarak baslayan her komut, calismak icin perform( ) bekler.
         */

    }


}
