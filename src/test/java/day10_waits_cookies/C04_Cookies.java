package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_Cookies extends TestBaseEach {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com/");

        // eger isteniyorsa cookies kabul edin
        // driver.findElement(By.xpath("(//*[text()='Allow all cookies'])[2]")).click();

        // Tum cookie'leri yazdirin

        Set<Cookie> cookiesSet = driver.manage().getCookies();
        int siraNo = 1;

        for (Cookie eachCookie : cookiesSet){
            System.out.println(siraNo + ". cookie :" + eachCookie);
            siraNo++;
        }

        // yeni bir cookie olusturun. Ismi : en sevdigim cookie     degeri : cikolatali cookie
        // ve bu cookie'yi facebook'a ekleyin

        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali cookie");

        driver.manage().addCookie(yeniCookie);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        cookiesSet = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie eachCookie : cookiesSet){
            System.out.println(siraNo + ". cookie :" + eachCookie);
            siraNo++;
        }

        // ekledigimiz cookie'nin eklendigini test edin

        String expectedCookieValue = "cikolatali cookie";
        String actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();

        Assertions.assertEquals(expectedCookieValue, actualCookieValue);

        // ismi "_js_datr" olan cookie'yi silin

        driver.manage().deleteCookieNamed("_js_datr");

        // ismi "_js_datr" olan cookie'nin silindigini test edelim
        /*
            Bunun icin iki yol kullanilabilir
            1- olmayan bir cookie'yi yazdirmak istersek exception verir
               exception olusuyorsa onu try catch ile kontrole alir
               exception olustuguna gore aranan cookie silinmistir diyebiliriz
            2- asagida cookie'leri yazdirdigimiz for-each loop'da
               ele aldigimiz her eachCookie'nin isminin aradigim cookie olup olmadigini kontrol ederim
               basta olusturacagimiz bir flag ile loop sonunda test yaparim
         */



        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        cookiesSet = driver.manage().getCookies();
        siraNo = 1;

        boolean jsdatrCookieVarMi = false;

        for (Cookie eachCookie : cookiesSet){
            System.out.println(siraNo + ". cookie :" + eachCookie);
            if (eachCookie.getName().equals("_js_datr")){
                jsdatrCookieVarMi = true;
            }
            siraNo++;
        }

        Assertions.assertFalse(jsdatrCookieVarMi);

        // tum cookie'leri silin

        driver.manage().deleteAllCookies();

        // tum cookie'leri sildigimizi test edin


        cookiesSet = driver.manage().getCookies();

        Assertions.assertTrue(cookiesSet.isEmpty());



    }




}
