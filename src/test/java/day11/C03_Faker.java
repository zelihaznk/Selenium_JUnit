package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilites.TestBaseBeforeClassAfterClass;

public class C03_Faker extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {

        /*
        "https://facebook.com"  Adresine gidin
        “create new account”  butonuna basin
        “firstName” giris kutusuna bir isim yazin
        “surname” giris kutusuna bir soyisim yazin
        “email” giris kutusuna bir email yazin
        “email” onay kutusuna emaili tekrar yazin
        Bir sifre girin
        Tarih icin gun secin
        Tarih icin ay secin
        Tarih icin yil secin
        Cinsiyeti secin
        Kaydol butonuna basın
        Sayfayi kapatin
         */

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://tr-tr.facebook.com/");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // “firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker(); // FAKER OBJESİ OLUSTURUYORUZ
        String fakeMail = faker.internet().emailAddress();
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));
        actions.click(isim).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(fakeMail).sendKeys(Keys.TAB)
                .sendKeys("05554569878").sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("16").sendKeys(Keys.TAB).sendKeys("Mar")
                .sendKeys(Keys.TAB).sendKeys("1993")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



        /**
        Faker class'ını kullanma amacımız form doldurmamız gereken web sitelerinde defalarca kendi üreteceğimiz veriler yerine
        bizim için random veriler üretir ve işimizi kolaylaştırır.

        Faker class'ını kullanmak için mvnrespository.com adresinden java faker kütüphanesini aratır ve en çok kullanılanı
        pom.xml dosyamıza (dependencies tagları arasına) ekleriz. Sonra faker class'ından bir obje oluşturup;

        email için: faker.internet() methodunu kullanarak emailAddress() method'unu seçeriz.
        password: faker.internet().password()
        isim: faker.name().firstName()
        soyisim: faker.name().lastName()

        method'larını kullanırız.
        */

        // faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
        // ve en cok kullanilani pom.xml dosyamiza ekleriz
        // ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
        // emailAdress() methodunu seceriz
        // password icinde ayni internet methodunu kullaniriz
        // isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
        // faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi üretecegimiz
        // veriler yerine bizim icin random veriler üretir ve isimizi kolaylastirir

    }


}
