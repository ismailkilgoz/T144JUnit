package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_Waits {
    /*
        implicitlyWait sayfanin yuklenmesi ve webelement'lerin locate edilmesi icin
                       belirlenmis global bir beklemedir.
        ExplicitWait icin olusturdugumuz WebDriverWait objesi olan wait ise
                       SADECE bir webelement ve SADECE bir expectedCondition icin calisir
     */
    WebDriver driver;
    @Test
    public void implicitlyWait(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneText = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        Assertions.assertTrue(itsGoneText.isDisplayed());

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackText = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        Assertions.assertTrue(itsBackText.isDisplayed());

        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void explicitWaitTesti(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

            // 1.adim wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2.adim MUMKUNSE kullanacagimiz webElement'i locate edin
            //   Eger mumkun degilse 2. ve 3. adimi birlestirecegiz
            //   Bize kullanacagimiz webElement'in locate bilgileri lazim
            //   xpath ==> "//*[text()="It's gone!"]"

            // 3.adim locate bilgilerini kullanarak
            //   locate ve beklenecek islemi birlikte tanimlayin

        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        // 78.satirda its gone yazisinin ortaya cikmasini bekledik ve locate ettik
        // artik testimizi yapabiliriz

        Assertions.assertTrue(itsGoneElementi.isDisplayed());

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 5. It’s back mesajinin gorundugunu test edin

            // 1. adim wait objesi olustur (yukarda olusturuldugu icin yenisine gerek yok)
            // 2. adim mumkunse kullanacagimiz elementi locate edin
            //     Kullanacagimiz element daha onceden its'gone olan element ile ayni
            //     ama HTML element degistigi icin ayni element olarak dusunemeyiz
            //     bizim kullanmak istedigimiz It's back elementini
            //     locate etmemiz mumkun olmadigindan 2. ve 3. adimi birlestirelim
            //      xpath ==> "//*[text()="It's gone!"]"

            // 3. adim bekleme ve locate'i birlikte yapalim

        WebElement itsBackElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));


        Assertions.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }
}
