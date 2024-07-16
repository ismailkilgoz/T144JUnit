package day05_maven_JUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_BeforeAfterNotasyonlari {

    /*
    Bu class'da birbirinden bagimsiz calisabilecek
            3 test yapmak istiyorum
            1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
            2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
            3- youtube.com'a gidip url'in "youtube" icerdigini test etsin

            EGER setup ve driverKapatma method'larinin
            bizim cagirmamiza ihtiyac olmadan
            OTOMATIK OLARAK her test method'undan once ve sonra calismasini istersek
            @Before... ve @After... method'lari kullaniriz

            Bu method'lar test method'larindan once ve sonra
            otomatik ve bagimsiz olarak calistiklarindan
            test method'unda bir exception olussa bile
            bu method'lar devreye girer ve gorevlerini yaparlar
     */
    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        ReusableMethods.bekle(1);
        driver.quit();
    }


    @Test
    public void testotomasyonuTesti(){

        // 1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Url testi PASSED");
        }else System.out.println("Testotomasyonu Url testi FAILED");

    }

    @Test
    public void wisequarterTesti(){

        // 2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Url testi PASSED");
        }else System.out.println("Wisequarter Url testi FAILED");

    }

    @Test
    public void youtubeTesti(){

        // 3- youtube.com'a gidip url'in "youtube" icerdigini test etsin
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Url testi PASSED");
        }else System.out.println("Youtube Url testi FAILED");

    }
}
