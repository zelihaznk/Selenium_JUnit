package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistsDownload extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {


        //downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();

        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Zeliha Öznük\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //İndirildiğini konsolda gösterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));


    }

}
