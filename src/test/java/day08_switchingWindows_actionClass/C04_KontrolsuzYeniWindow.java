package day08_switchingWindows_actionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;
import java.util.Set;

public class C04_KontrolsuzYeniWindow extends TestBaseEach {

    @Test
    public void test01(){

        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkWindowWHD = driver.getWindowHandle();
        // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        String expectedText = "Add/Remove Elements";
        String actualText = text.getText();

        Assertions.assertEquals(expectedText,actualText);

        // ● Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.

        String exceptedTitleText = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(exceptedTitleText));

        // ● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();

        Set <String> tumWindowHandleDegerleri = driver.getWindowHandles();
        String ikinciWindow = "";

        for (String eachWHD : tumWindowHandleDegerleri){
            if (!eachWHD.equals(ilkWindowWHD)){
                ikinciWindow=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWindow);
        ReusableMethods.bekle(2);

        // ● Electronics sayfasinin acildigini test edin


        String expectedElectronicsUrl = "https://testotomasyonu.com/category/7/products";
        String actualElectronicsUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedElectronicsUrl,actualElectronicsUrl);

        // ● Bulunan urun sayisinin 16 olduğunu test edin
        List <WebElement> urunSayisiList = driver.findElements(By.xpath("//*[@class='product-box mb-2 pb-1']"));

        Assertions.assertEquals(16, urunSayisiList.size());

        // ● Ilk actiginiz addremove sayfasinin oldugu window’a donun
        driver.switchTo().window(ilkWindowWHD);
        ReusableMethods.bekle(2);

        // ● Url’in addremove icerdigini test edin
        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(2);
    }
}
