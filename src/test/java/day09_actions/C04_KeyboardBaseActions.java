package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_KeyboardBaseActions extends TestBaseEach {

    @Test
    public void test01(){

        // 1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        // 2- Arama kutusuna actions method’larini kullanarak
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        //    “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT).sendKeys("dell c").keyUp(Keys.SHIFT).sendKeys("ore ")
                .keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).sendKeys("3",Keys.ENTER).perform();


        ReusableMethods.bekle(3);

        // 3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        String exceptedIsimIcerigi = "DELL Core I3";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@*='prod-title mb-3 ']")).getText();

        Assertions.assertTrue(actualUrunIsmi.contains(exceptedIsimIcerigi));
    }
}
