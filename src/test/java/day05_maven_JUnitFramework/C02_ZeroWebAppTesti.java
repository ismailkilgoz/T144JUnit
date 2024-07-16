package day05_maven_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ZeroWebAppTesti {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. http://zero.webappsecurity.com
        // sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();


        // 3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("username");

        // 4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("password");

        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@*='submit']")).click();

        // 6. Back tusu ile sayfaya donun
        driver.navigate().back();

        // 7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // 8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("1000");

        // 9. tarih kismina “2023-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2023-09-10");

        // 10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Pay']")).click();

        // 11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        String expectedText = "The payment was successfully submitted.";
        String actualText = driver.findElement(By.xpath("//*[@id='alert_content']")).getText();

        if (actualText.contains(expectedText)){
            System.out.println("Mesaj testi PASSED");
        }else   System.out.println("Mesaj testi FAILED");

        ReusableMethods.bekle(3);
        driver.quit();
    }
}
