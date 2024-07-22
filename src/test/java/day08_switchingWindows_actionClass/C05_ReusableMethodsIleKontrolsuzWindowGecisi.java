package day08_switchingWindows_actionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C05_ReusableMethodsIleKontrolsuzWindowGecisi extends TestBaseEach {

    @Test
    public void test01(){

        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        // Please click for Electronics Products' linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']"))
                .click();

        /*
             Birden fazla window acildiginda
             acilan window'larin WHD'lerini onceden bilmemiz MUMKUN DEGIL
             ama gecmek istedigimiz window'un TITLE veya URL'ini BILIYORUZ

         */
        Set<String> acikWindowlarinWhdSeti = driver.getWindowHandles();

        String hedefUrl = "https://testotomasyonu.com/category/7/products";
        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/category/7/products");

        // Electronics sayfasinin acildigini test edin
        String expectedElectronicsUrl = "https://testotomasyonu.com/category/7/products";
        String actualElectronicsUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedElectronicsUrl,actualElectronicsUrl);

        // Ilk actiginiz addremove sayfasinin oldugu window'a donun
        hedefUrl = "https://testotomasyonu.com/addremove/";
        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/addremove/");

        // Url'in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

}
