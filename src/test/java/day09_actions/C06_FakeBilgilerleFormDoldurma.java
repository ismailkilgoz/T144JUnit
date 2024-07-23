package day09_actions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_FakeBilgilerleFormDoldurma extends TestBaseEach {

    @Test
    public void test01(){

        Faker faker = new Faker();

        // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        // 2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='e-cart'])[1]")).click();

        // 3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        String fakePassword = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();
        driver.findElement(By.id("firstName")).
                sendKeys(faker.name().firstName() ,
                        Keys.TAB , faker.name().lastName() ,
                        Keys.TAB, fakeEmail ,
                        Keys.TAB , fakePassword ,
                        Keys.TAB , fakePassword );

        driver.findElement(By.id("btn-submit-form")).click();

        // login yaparak hesabin olusturuldugunu test edelim

        driver.findElement(By.id("email")).sendKeys(fakeEmail,
                Keys.TAB , fakePassword,
                Keys.ENTER);
        ReusableMethods.bekle(4);
        // 5- Kaydin olusturuldugunu test edin

        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();
    }
}
