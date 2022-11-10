package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

    //Genel HTML kodlari acisindan tablo elementleri tag'lerle belirlenmistir.
    //             - <table>
    //             - <header> tablonun baslik kismini belirler
    //                <tr> veya <th> satirlari
    //                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
    //             - <tbody> tablo body'si
    //                <tr> satirlari
    //                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)

    //incele dedigimizde table tagının altında thead olur yani baslık, bunun altındakilerde artık
    // th baslığın birinci satırını veriyor. td lerde baslığın hücrelerini sutunlarını veriyor.
    // tr den sonraki th baslığın ikinci satirını veriyor


    /**
      Tabloda <table> tag'i altinda tablonun basligini gosteren <thead> tag, bulunur.
      Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tag'i vardir
      ve basliktaki sutunlara yani hucrelere(cell) de <th> tag'i ile ulasilir
      Basligin altindaki tablolara <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i
      ile sutunlara yani hıcrelere <td> tag'i ile ulasilir
 */



    @Test
    public void test1() {

        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.

        login(); //önce login methodu oluşturduk

        //table( ) metodu oluşturun
        table();

        //● printRows( ) metodu oluşturun //tr
        printRows();

    }

    private void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        //Username : manager
        //Password : Manager2!
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }


    private void table() {
        //incele kısmına //thead//tr//th yazarak sutun sayısı bulunur
        //  //thead yazılıp

        //tr satırları
        //th sutunları verir

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> sutunSayisi =driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("sutun sayisi :"+sutunSayisi.size());

        //thead —> başlık
        //th --> 1.satır
        //tr--> 1.satır-1.eleman

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> tumBodyTumBaslik = driver.findElements(By.xpath("//table//tbody"));
        System.out.println("body sayisi :"+tumBodyTumBaslik.size());

        System.out.println("*****************************");

        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body :"+body.getText());

        System.out.println("*****************************");

        WebElement basliklar= driver.findElement(By.xpath("//thead//tr"));  //başlık için thead olur
        System.out.println("basliklari :"+basliklar.getText());

        System.out.println("*****************************");

        //thead-->Title başlıklari
        //tbody --> Title tablo

        //table row =tr
        //table header = th
        //table data= td

    }

    private void printRows() {
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("*****************************");

        List<WebElement> satirList = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("tablodaki satir sayisi :"+satirList.size());

        // ○ Table body'sinde bulunan satirlari(rows) konsolda yazdırın.
        WebElement bodySatirlar = driver.findElement(By.xpath("//tbody//tr"));
        System.out.println("Body'de yer alan satırlar = " + bodySatirlar.getText());

        System.out.println("**rows Lambda ile**");
        satirList.stream().forEach(t-> System.out.println(t.getText()));

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement dorduncuSatir = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("Dorduncu satir icerigi = " + dorduncuSatir.getText());

        System.out.println("Tablodaki dorduncu satir :"+driver.findElement(By.xpath("//tbody//tr[4]")).getText());

        System.out.println("**4. satir Lambda ile**");
        satirList.stream().map(WebElement::getText).limit(4).skip(3).forEach(System.out::println);


    }


}