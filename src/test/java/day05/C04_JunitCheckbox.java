package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JunitCheckbox {
     /*
      1. Bir class oluşturun : CheckBoxTest
      2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */

   WebDriver driver;

   @Before
   public void setUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }

   @Test
   public void test1(){

       //a. Verilen web sayfasına gidin.
       //https://the-internet.herokuapp.com/checkboxes
       driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

       //b. Checkbox1 ve checkbox2 elementlerini locate edin.
       //c. Checkbox1 seçili değilse onay kutusunu tıklayın
       //d. Checkbox2 seçili değilse onay kutusunu tıklayın
       if (!driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected()){
           driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
       }
       if (!driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected()){
           driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
       }
   }


   @After
   public void tearDown(){
       driver.close();
   }








}
