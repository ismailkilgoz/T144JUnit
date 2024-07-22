package day08_switchingWindows_actionClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_WindowSayfaFarki extends TestBaseEach {

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/
        System.out.println(driver.getWindowHandle());   // 6ACEAF5415DC9DFEECA3D990CD78DCDA
        ReusableMethods.bekle(3);

        // Electronics linkine tiklayalim
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/category/7/products
        System.out.println(driver.getWindowHandle());   // 6ACEAF5415DC9DFEECA3D990CD78DCDA

        // ilk urune click yapalim

        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/product/58
        System.out.println(driver.getWindowHandle());   // 6ACEAF5415DC9DFEECA3D990CD78DCDA

        // Ayni window'da yeni sayfalar acildigi icin
        // eski sayfalara donmek icin navigate().back() ile donebiliriz

        driver.navigate().back();
        System.out.println("ilk navigate.back'den sonra "+driver.getCurrentUrl()); // https://www.testotomasyonu.com/category/7/products
        System.out.println(driver.getWindowHandle());   // 6ACEAF5415DC9DFEECA3D990CD78DCDA

        ReusableMethods.bekle(3);

        driver.navigate().back();
        System.out.println("ikinci navigate.back'den sonra "+driver.getCurrentUrl()); // https://www.testotomasyonu.com/
        System.out.println(driver.getWindowHandle());   // 6ACEAF5415DC9DFEECA3D990CD78DCDA

    }
}
