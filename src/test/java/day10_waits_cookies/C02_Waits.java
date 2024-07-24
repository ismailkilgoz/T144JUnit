package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class C02_Waits {

    // Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    // Iki metod icin de asagidaki adimlari test edin.
    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Textbox’in etkin olmadigini(enabled) dogrulayın
    // 3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    WebDriver driver ;
    @Test
    public void implicitlyWaitTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // ve textbox etkin oluncaya kadar bekleyin
        // bu bekleme sayfanin yuklenmesi veya webElement'in locate edilmesi
        // ile ilgili olmadigindan implicitlyWait devreye girmez
        ReusableMethods.bekle(3);


        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement enabledText = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        Assertions.assertTrue(enabledText.isDisplayed());

        driver.quit();




    }

    @Test
    public void explicitWaitTesti(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.

            // explicitWait kullanabilmek icin
            // 1.adim bir wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

            // 2.adim EGER MUMKUNSE kullanacagimiz webelementi locate edin
            //        bizim kullanacagimiz textBox zaten locate edildi

            // 3.adim wait objesi ile baslayip, beklenecek kosulu tanimlayin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

            // Artik textBox'un enable oldugunu test edebiliriz.
        Assertions.assertTrue(textBox.isEnabled());


        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enabledText = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        Assertions.assertTrue(enabledText.isDisplayed());

        driver.quit();
    }
}
