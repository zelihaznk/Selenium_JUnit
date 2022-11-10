package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBaseBeforeAfter;

public class homework3 extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        System.out.println("********************************");
        //Headers da bulunan department isimlerini yazdirin
        WebElement departman = driver.findElement(By.xpath("//*[text()='Department']"));
        System.out.println(departman.getText());

        System.out.println("********************************");
        //sutunun basligini yazdirin
        WebElement basliklar = driver.findElement(By.xpath("//*[@class='rt-tr']"));
        System.out.println(basliklar.getText());


        //Tablodaki tum datalari yazdirin
        //Tabloda kac cell (data) oldugunu yazdirin
        //Tablodaki satir sayisini yazdirin
        //Tablodaki sutun sayisini yazdirin
        //Tablodaki 3.kolonu yazdirin
        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin


    }
}
