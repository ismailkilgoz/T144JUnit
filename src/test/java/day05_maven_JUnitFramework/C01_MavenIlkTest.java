package day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_MavenIlkTest {

    public static void main(String[] args) {


        // ilgili ayarlari yapin

        // WebDriverManager.chromedriver().setup();
        /*
            17. satir sirket bize ozel bir WebDriver verirse kullanilacak
            Ama biz Selenium'un kendi Webdriver'ini kullanacagimiz icin
            17. satira ihtiyacimiz yok
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        // title'in "Test Otomasyon" icerdigini test edin
        String exceptedTitleIcerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(exceptedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        // sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();


    }
}
