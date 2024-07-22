package day08_switchingWindows_actionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C03_KontrolsuzYeniWindowAcilmasi extends TestBaseEach {

    @Test
    public void test01(){

        // https://testotomasyonu.com/addremove/ url'e gidin
        driver.get("https://testotomasyonu.com/addremove/");

        System.out.println("addremove : " +driver.getCurrentUrl());     // https://testotomasyonu.com/addremove/
        System.out.println("addremove : " +driver.getWindowHandle());
        String ilkWindowWhd = driver.getWindowHandle();
        ReusableMethods.bekle(2);

        // Electronics linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        System.out.println("Electronics linkine tiklayinca : " +driver.getCurrentUrl());  // https://testotomasyonu.com/category/7/products
        System.out.println("Electronics linkine tiklayinca : " +driver.getWindowHandle());

        // back tusuna basin ve
        driver.navigate().back();
        // https://testotomasyonu.com/addremove/ adresine dondugunuzu test edin
        String expectedUrl = "https://testotomasyonu.com/addremove/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

        // Please click for Electronics Products linkine tiklayin

        driver.findElement(By.xpath("//*[text() = 'Electronics Products']")).click();

        System.out.println("Electronics Products linkine tiklayinca : " +driver.getCurrentUrl());
        // https://testotomasyonu.com/addremove/
        System.out.println("Electronics Produtcs linkine tiklayinca : " +driver.getWindowHandle());
        // 6A3440EF0E661C5CCE256891CD0FC5DC
        System.out.println("Electronics Produtcs linkine tiklayinca tum WHD'leri : " +driver.getWindowHandles());
        // [6A3440EF0E661C5CCE256891CD0FC5DC, 222165D84DD9F549B5EBBB077A3F90B0]

        // Kategori olarak electronics sayfasinin acildigini test edin



        /*
            Kontrolsuz bir window acildiginda
            driver yeni window'a ve yeni sayfaya gecemez
            eski window ve eski url'de bekler

            Biz yeni acilan window'da, acilan url'deki bir web elementi kullanmak istedigimizde
            o web elementi bulamaz ve testimiz failed olur

            Kontrolsuz acilan 2.window'a gecis yapabilmek icin
            2. window'un window handle degerini bulmamiz gerekir

            driver.getWindowHandle() icinde oldugu window'un WHD'ini verir
            driver yeni window'a gecmeden driver'i kullanarak WHD'ini alamayiz
            WHD olmadan da driver'i yeni window'a geciremeyiz

            Bu durumda bizim driver'a henuz gecmedigi window'un WHD'ini bulmamiz lazim

            Burada JAVA devreye girer

            1- ilk window acildiginda birinciWindowWHD'ini kaydederiz
            2- kontrolumuz disinda bir window acildiginda
               driver.getWindowHandles() ile acilmis olan 2 window'un
               WindowHandleDegerlerini kaydederiz
            3- Bir for-each loop ile Set'deki 2 WHD'ini ele alip
               kaydettigimiz birinciWindowWHD'ine esit olmayan String'i
               ikinciWindowWHD olarak atariz
            4- Java ile buldugumuz ikinciWindowWHD'ini kullanarak
               driver'i ikinci window'a gecirebiliriz.


         */

        Set <String> acikTumWindowlarinWHDleri = driver.getWindowHandles();
        String ikinciWindowWhd = "";

        for (String eachWhd : acikTumWindowlarinWHDleri){
            if (!eachWhd.equals(ilkWindowWhd)){
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);

        ReusableMethods.bekle(3);

        WebElement seciliKategoriElementi = driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori = "Electronics";
        String actualSeciliKategori = seciliKategoriElementi.getText();

        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);
        ReusableMethods.bekle(2);

    }
}
