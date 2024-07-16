package day05_maven_JUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_OrtakBaslangicVeBitisAdimlari {

    /*
        Bu class'da birbirinden bagimsiz calisabilecek
        3 test yapmak istiyorum
        1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
        2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
        3- youtube.com'a gidip url'in "youtube" icerdigini test etsin

        Class'daki 3 test method'unun hepsinin
        en basindaki 3 satir ve en sonundaki 2 satir ayni
        bu satirlari tekrar tekrar yazmak istemezsek



     */
    WebDriver driver;


    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void driverKapatma(){
        ReusableMethods.bekle(1);
        driver.quit();
    }


    @Test
    public void testotomasyonuTesti(){
        setup();

        // 1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Url testi PASSED");
        }else System.out.println("Testotomasyonu Url testi FAILED");

        driverKapatma();
    }

    @Test
    public void wisequarterTesti(){

        setup();
        // 2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Url testi PASSED");
        }else System.out.println("Wisequarter Url testi FAILED");

        driverKapatma();
    }

    @Test
    public void youtubeTesti(){

        setup();
        // 3- youtube.com'a gidip url'in "youtube" icerdigini test etsin
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Url testi PASSED");
        }else System.out.println("Youtube Url testi FAILED");

        driverKapatma();
    }


}