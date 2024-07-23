package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C03_MoveToElement extends TestBaseEach {

    @Test
    public void test01(){

       // 1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

       // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kidsMenu = driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));

        actions.moveToElement(kidsMenu).perform();

       // 3- “Boys” linkine basin
        driver.findElement(By.partialLinkText("Boys")).click();

       // 4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

       // 4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin


        String exceptedIsim = "Boys Shirt White Color";
        String actualIsim = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']")).getText();

        Assertions.assertEquals(exceptedIsim,actualIsim);

        ReusableMethods.bekle(2);

    }
}
