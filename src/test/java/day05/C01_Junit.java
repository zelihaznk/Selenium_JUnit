package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Junit {

    //method olusturtuk, burada junit ile testlerimizi yapabilmek icin üzerine @ annotations dedigimiz @ isaretini
    // koyuyoruz ve test yazıyoruz
    //run tusu main method yazarsak veya test notasyonunu yazarsak cıkar.
    //JUnit ten run yaparsak buradaki bütün methodlar calisir yani aynı anda birden fazla yerin testini yapabiliriz.
    //kod calıstıktan sonra asağıda kac saniyede calıstğı ve test passed seklinde cıkar.

    @Test //methodları main gibi çalıştırmaya yarar bu sayede junit kullanılmış olur

    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        driver.close();
    }

    @Test

    public void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com/tr/");

        driver.close();
    }

    @Test

    public void test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.hepsiburada.com/");

        driver.close();
    }


}
