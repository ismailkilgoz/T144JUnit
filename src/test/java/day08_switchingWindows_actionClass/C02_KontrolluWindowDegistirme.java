package day08_switchingWindows_actionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_KontrolluWindowDegistirme extends TestBaseEach {

    @Test
    public void test01(){

        // testotomasyonu anasayfasina gidin

        driver.get("https://www.testotomasyonu.com");

        String testOtoAnasayfaWH = driver.getWindowHandle();

        System.out.println("Anasayfa : " +driver.getCurrentUrl());
        // Anasayfa : https://www.testotomasyonu.com/
        System.out.println("Anasayfa : " +driver.getWindowHandle());
        // Anasayfa : D70D71EAB9061BF6238E5F715F099760

        // Yeni bir tab olusturup electronics linkine tiklayin

        // EGER driver'a YENI BIR WINDOW actirmak istersek
        // switchTo().newWindow() kullanabiliriz
        // Bu method kullanildiginda 4 onemli noktaya DIKKAT ETMEMIZ gerekir
        // 1- driver OTOMATIK olarak yeni acilan window'a gecer
        // 2- yeni window bos olarak gelir
        // 3- yeni acilan window'da driver.navigate.back dersek anasayfaya donmez
        //      anasayfaya donmek isterseniz driver.switchTo(anasayfanin acik oldugu window'un WHD)
        // 4- switchTo().newWindow() ile acilan window bos oldugundan
        //      electronics linkine basmak icin anasayfaya bir kere daha gitmek gerekir
        System.out.println("_________________________________________________________________");

        driver.switchTo().newWindow(WindowType.TAB);

        System.out.println("Yeni Tab acildiginda : " +driver.getCurrentUrl());
        // Yeni Tab acildiginda : about:blank
        System.out.println("Yeni Tab acildiginda : " +driver.getWindowHandle());
        // Yeni Tab acildiginda : 9173B2E4A21F11F2A41D77792DA33826
        System.out.println("Yeni Tab acildiginda tum WHD'leri : "+ driver.getWindowHandles());
        // Yeni Tab acildiginda tum WHD'leri : [D70D71EAB9061BF6238E5F715F099760, 9173B2E4A21F11F2A41D77792DA33826]

        System.out.println("_________________________________________________________________");


        driver.get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        String electronicsWH = driver.getWindowHandle();

        System.out.println("Electronics linkine basinca : " +driver.getCurrentUrl());
        // Electronics linkine basinca : https://www.testotomasyonu.com/category/7/products
        System.out.println("Electronics linkine basinca : " +driver.getWindowHandle());
        // Electronics linkine basinca : 9173B2E4A21F11F2A41D77792DA33826
        System.out.println("Electronics linkine basinca tum WHD'leri : "+ driver.getWindowHandles());
        // [D70D71EAB9061BF6238E5F715F099760, 9173B2E4A21F11F2A41D77792DA33826]


        // Yeni bir window'da wisequarter.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);

        System.out.println("3. window acildiginda : " +driver.getCurrentUrl());
        //  about:blank
        System.out.println("3. window acildiginda : " +driver.getWindowHandle());
        // Electronics linkine basinca :  E729BFF9D8F017811F77883C5D6FFFDE
        System.out.println("3. window acildiginda : "+ driver.getWindowHandles());
        // [D70D71EAB9061BF6238E5F715F099760, 9173B2E4A21F11F2A41D77792DA33826, E729BFF9D8F017811F77883C5D6FFFDE]

        driver.get("https://www.wisequarter.com");
        String wiseWH = driver.getWindowHandle();

        System.out.println("Testotomasyonu WHD : "+testOtoAnasayfaWH);   // D70D71EAB9061BF6238E5F715F099760
        System.out.println("Electronics WHD : "+electronicsWH);      // 9173B2E4A21F11F2A41D77792DA33826
        System.out.println("Wisequarter WHD : "+wiseWH);         // E729BFF9D8F017811F77883C5D6FFFDE



        // testotomasyonu sanasayfanin acik oldugu window'a donun ve
        driver.switchTo().window(testOtoAnasayfaWH);
        // anasayfada oldugunuzu test edin

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);


        ReusableMethods.bekle(3);
        //electronics urunlerin oldugu window'a gidin
        driver.switchTo().window(electronicsWH);
        // Home/Electronics yazdigini test edin

        WebElement seciliKategoriElementi = driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori = "Electronics";
        String actualSeciliKategori = seciliKategoriElementi.getText();

        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);


        ReusableMethods.bekle(3);
        // wisequarter'in acik oldugu window'a gidin
        driver.switchTo().window(wiseWH);
        // url'in wisequarter icerdigini test edin

        String exceptedUrlText = "wisequarter";
        String actualUrlText = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlText.contains(exceptedUrlText));


        ReusableMethods.bekle(3);
    }
}
