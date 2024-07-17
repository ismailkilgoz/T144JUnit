package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

public class C05_BeforeVeAfterMethodlariPratikKullanim extends TestBaseEach {

    // Testotomasyonu anasayfaya gidin
    // url'in testotomasyonu icerdigini test edin

    @Test
    public void urlTest(){
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}
