package day07_JsAllerts_IFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C06_Iframe extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement iframeElementi = driver.findElement(By.xpath("(//*[@frameborder='1'])[1]"));
        driver.switchTo().frame(iframeElementi);
        WebElement elektronicsProductsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(elektronicsProductsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellPcElementi = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellPcElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sagdaki bolumde gorunen urunler arasinda
        // ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        // sagdaki fashion bolumu ayri bir iframe oldugundan once o iframe'e gecis yapmaliyiz
        // burada dikkat edecegimiz konu biz soldaki iframe'in icinde oldugumuzdan
        // sagdaki iframe'e gecis yapabilmek icin once anasayfaya donmeliyiz

        driver.switchTo().defaultContent();
        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        // Men Slim Fit Yazisi elementlere ait textlerin icinde geciyor
        // testi yapabilmek icin, tum urunleri tek tek ele almali
        // ve isminde Men Slim Fit geciyor mu diye kontrol etmeliyiz

        List<WebElement> fashionUrunElementleriList = driver.findElements(By.xpath("//*[@class='overlay']"));

        List<String> urunIsimleriList = ReusableMethods.getStringList(fashionUrunElementleriList);
        // [Men Slim Fit Casual Shirt, Men Slim Fit Solid Casual Shirt, Men Sun Glasses, Women Black Fancy Dress, Luxury Shopping Bag For Women, Pink Sport Shoes For Women]

        boolean menSlimFitVarMi = false;
        for (String eachIsim : urunIsimleriList
        ) {

            if (eachIsim.contains("Men Slim Fit")){
                menSlimFitVarMi = true;
            }
        }
        Assertions.assertTrue(menSlimFitVarMi);

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fashionYaziElementi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // once fashion iframe'inden ana sayfaya gecis yapalim

        driver.switchTo().defaultContent();

        WebElement hereAreYaziElementi = driver.findElement(By.className("desc"));

        Assertions.assertTrue(hereAreYaziElementi.isDisplayed());

        //7- Sayfayi kapatin
    }
}
