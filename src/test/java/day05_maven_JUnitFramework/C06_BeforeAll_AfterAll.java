package day05_maven_JUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class C06_BeforeAll_AfterAll {

    // 3 farkli test method'u olusturup asagidaki 3 gorevi yerine getirin
    //      1- testotomasyonu anasayfaya gidin ve dogru sayfaya gittiginizi test edin
    //      2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    //      3- ilk urunu tiklayin ve urun isminde case sensitive olmadan phone bulundugunu test edin

    /*
            JUnit'te @Test method'larinin hangi sira ile calisacagi
            ongorulemez ve kontrol edilemez
            Eger test method'larinin belirli bir sirada calismasini istersek
            @Test method isimlerini test01, test02... gibi ayarlayabiliriz

            @BeforeAll ve @AfterAll method'lari static OLMAK ZORUNDADIR
     */


    static WebDriver driver;
    static List <WebElement> bulunanUrunElementleriList;
    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    //1- testotomasyonu anasayfaya gidin ve dogru sayfaya gittiginizi test edin
    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");
        if (driver.getCurrentUrl().equals("https://www.testotomasyonu.com/")){
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("Anasayfa testi FAILED");
    }

    //2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    @Test
    public void test02(){
        driver.findElement(By.id("global-search")).sendKeys("phone" + Keys.ENTER);
        bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@class='product-detail mb-3']"));

        if (bulunanUrunElementleriList.size()>0){
            System.out.println("Urun arama testi PASSED");
        }else System.out.println("Urun arama testi FAILED");
    }

    //3- ilk urunu tiklayin ve urun isminde case sensitive olmadan phone bulundugunu test edin
    @Test
    public void test03(){
        bulunanUrunElementleriList.get(0).click();
        String expectedUrunIcerigi = "phone";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualIsim = urunIsimElementi.getText().toLowerCase(Locale.ROOT);

        if (actualIsim.contains(expectedUrunIcerigi)) {
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");
    }


}
