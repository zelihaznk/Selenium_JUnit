package day10;

import org.junit.Test;
import utilites.TestBaseBeforeAfter;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter { //Burada utilites package e extend ettik child parent class konusu sebebiyle

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");

    }

    /**
    TestBase, testlerden önce ve sonra tekrar tekrar
    kullandığımız kodları içermektedir.

    ●İçerisindeki metodları kullanabilmemiz icin extends
    yapıyoruz. Bu sayede test class’ımızda sadece test
    case’ler bulunmaktadır.

    ● Utilities package’da TestBase’i oluşturuyoruz.
    ○ setUp method
    ○ reports (Raporlar)
    ○ tearDown method

    ●TestBase class’i abstract yapabiliriz (Olmasada
    olabilir) , extends yaparak kullanabiliriz. Ve bu
    class’da object create edemeyiz.

    ● olusturdugumuz driver’in farkli package’lardan kullanabilmek icin PROTECTED yapariz
     */

}
