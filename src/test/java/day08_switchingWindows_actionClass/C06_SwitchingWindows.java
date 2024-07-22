package day08_switchingWindows_actionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_SwitchingWindows extends TestBaseEach {

    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        // 2- Electronics Products yazisinin gorunur olduğunu test edin

        // yazi iframe icinde oldugundan once iframe'e gecelim
        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);


        WebElement electronicsProductsTitle = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsTitle.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String exceptedDellIsmi = "DELL Core I3 11th Gen";
        String actualDellIsmi = driver.findElement(By.id("pictext1")).getText();

        Assertions.assertEquals(exceptedDellIsmi,actualDellIsmi);

        // 4- Dell bilgisayar’a tiklayip
        driver.findElement(By.id("pictext1")).click();

        // elemente tikladigimizda kontrolsuz olarak yeni window aciliyor
        // once yeni acilan window'a gecmemiz gerekir
        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/product/58");

        // acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        String expectedFiyat = "$399.00";
        String actualFiyat = driver.findElement(By.id("priceproduct")).getText();

        Assertions.assertEquals(expectedFiyat,actualFiyat);

        // 5- Ilk window'a donun ve Fashion yazisinin gorunur olduğunu test edin
        ReusableMethods.switchWindowByTitle(driver,"Test Otomasyonu");

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        String expectedText = "Fashion";
        String actualText = driver.findElement(By.xpath("//*[text()='Fashion']")).getText();

        Assertions.assertEquals(expectedText,actualText);

        ReusableMethods.bekle(3);
        // 6- Sayfayi kapatin
    }

}
