package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {

        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        Thread.sleep(2000);

        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Zeliha Öznük\\Downloads\\test (1).txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //İndirildiğini konsolda gösterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));


        /*
        String dosyaYolu = "C:\\Users\\Zeliha Öznük\\Desktop\\test.txt.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
         */

         /**
 Bir Web sitesinden indirdigimiz yada windows icinde
 olusturdugumuz dosyanin indigini yada orda oldugunu
 test edebilmek icin o dosyanin uzerine shift tusuna
 basili olarak sag click yapip dosyanin yolunu kopyalayıp
 bir String degiskene atariz ve dosyayi dogrulamak icin
 Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 Bu methodu kullaniriz.
*/
    }
}
