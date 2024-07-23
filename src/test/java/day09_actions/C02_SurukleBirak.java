package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_SurukleBirak extends TestBaseEach {

    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement acceptableButonu = driver.findElement(By.id("draggable2"));
        ReusableMethods.bekle(1);
        WebElement dropKutusu = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(acceptableButonu,dropKutusu);
        actions.perform();
        ReusableMethods.bekle(1);

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText = "Dropped!";
        String actualText = driver.findElement(By.id("droppable2")).getText();

        Assertions.assertEquals(expectedText,actualText);

        ReusableMethods.bekle(1);
        // 4- Sayfayi yenileyin
        driver.navigate().refresh();

        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableButonu = driver.findElement(By.id("draggable-nonvalid2"));
        dropKutusu = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableButonu,dropKutusu);
        actions.perform();
        ReusableMethods.bekle(1);


        // 6- “Drop Here” yazisinin degismedigini test edin
        String exceptedEskiText = "Drop Here";
        String actualEskiText = driver.findElement(By.id("droppable2")).getText();

        Assertions.assertEquals(exceptedEskiText,actualEskiText);

    }
}
