package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_RadioButtons {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.


    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void yazidanSecmeTesti(){
        // a. Verilen web sayfasına gidin.
        //          https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        // b. Cinsiyet Radio button elementlerini locate edin
        // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        WebElement erkekCheckboxYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));

        WebElement erkekCheckbox = driver.findElement(By.id("inlineRadio2"));
        WebElement kadinCheckbox = driver.findElement(By.id("inlineRadio1"));
        WebElement digerCheckbox = driver.findElement(By.id("inlineRadio3"));

        erkekCheckboxYaziElementi.click();
        ReusableMethods.bekle(2);

        Assertions.assertTrue(erkekCheckbox.isSelected());
        Assertions.assertFalse(kadinCheckbox.isSelected());
        Assertions.assertFalse(digerCheckbox.isSelected());

    }

    @Test
    public void checkboxSecmeTesti(){
        driver.get("https://testotomasyonu.com/form");

        WebElement erkekCheckbox = driver.findElement(By.id("inlineRadio2"));
        WebElement kadinCheckbox = driver.findElement(By.id("inlineRadio1"));
        WebElement digerCheckbox = driver.findElement(By.id("inlineRadio3"));

        erkekCheckbox.click();
        ReusableMethods.bekle(2);

        Assertions.assertTrue(erkekCheckbox.isSelected());
        Assertions.assertFalse(kadinCheckbox.isSelected());
        Assertions.assertFalse(digerCheckbox.isSelected());

    }

}
