package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilites.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {

    @Test
    public void test1() {

    /*
    1-Amazon anasayfaya gidin
    -tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        System.out.println("*****************************************************");

        //-tum cookie’leri listeleyin
        Set<Cookie> tumCookie = driver.manage().getCookies(); //Set döndürdüğü için set atıyoruz

        System.out.println(tumCookie);
        int sayac = 1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = tumCookie.size();
        Assert.assertTrue(cookieSayisi>5);



        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookie) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }

        //cookiesSet.stream().forEach(t-> System.out.println("name : "+t.getName()+" value :"+t.getValue()));

        System.out.println("*****************************************************");

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCookie = driver.manage().getCookies();

        sayac = 1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }

        //cookiesSet.stream().filter(t-> t.getName().equals("i18n-prefs")).forEach(t-> Assert.assertEquals("USD",t.getValue()));

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));

        //Assert.assertTrue(m1.getName().contains("en sevdigim cookie"));
        //Assert.assertTrue(m1.getValue().contains("cikolatali"));

        System.out.println("*****************************************************");

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        sayac = 1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }

        Cookie isim = driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains(isim));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie = driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());

    }
}
