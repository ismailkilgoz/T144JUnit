package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_FileUpload extends TestBaseEach {

    @Test
    public void fileUpdateTesti(){

        // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // 2.chooseFile butonuna basalim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));
        // 3.Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/day09_actions/sample.png";
        chooseFileButonu.sendKeys(dosyaYolu);

        // 4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // 5.“File Uploaded!” textinin goruntulendigini test edelim.

        String expectedText = "File Uploaded!";
        String actualText = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedText,actualText);

        ReusableMethods.bekle(5);
    }
}
