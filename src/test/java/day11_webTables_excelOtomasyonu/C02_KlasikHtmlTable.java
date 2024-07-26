package day11_webTables_excelOtomasyonu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.util.List;

public class C02_KlasikHtmlTable extends TestBaseEach {


    @Test
    public void test01(){

        // 1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // 2. Web table tum body’sini yazdirin
        System.out.println("==================== Tum body =======================");
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        System.out.println("====================================");


        // 3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedBodyIcerigi = "Comfortable Gaming Chair";
        String actualBody = tumBodyElementi.getText();

        Assertions.assertTrue(actualBody.contains(expectedBodyIcerigi));

        // 4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        // 5. Tum satirlari yazdirin

        int sayac = 1;

        for (int i = 0; i < satirElementleriList.size(); i++) {
            System.out.println(i+1 + ". satir ==> \n" + satirElementleriList.get(i).getText());
            System.out.println();
        }

        // 6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //     Web Tablolarinda sutun bilgisi olmaz
        //     Bunun yerine herhangi bir satirdaki data sayisini alabiliriz

        List<WebElement> ucuncuSatirElementleriList = driver.findElements(By.xpath("//tbody/tr[3]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = ucuncuSatirElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        // 7. 3.sutunu yazdirin
        //    Web Tablolarinda sutun yapisi olmaz
        //    Bunun yerine hangi satir olursa olsun, o satirin 3. datasini yazdiralim

        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        for (int i = 0; i < ucuncuSutunElementleriList.size(); i++) {
            System.out.print(ucuncuSutunElementleriList.get(i).getText() + "  ");
        }

        // 8. Tablodaki basliklari yazdirin

        System.out.println(driver.findElement(By.xpath("//thead")).getText());

        // 9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        getCellData(1,3);

        // 10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedCategory = "Furniture";
        String actualCategory = getCellData(4,2);

        Assertions.assertEquals(expectedCategory,actualCategory);


        // Category'si travel olan urunun fiyatinin $99.00 oldugunu test edin
        // her satirdaki category degerine bakarim
        // category'si travel olan satirdaki fiyat bilgisini alip actualFiyat olarak kaydederim
        // expected fiyat ile test ederim

        String expectedFiyat = "$99.00";
        String actualFiyat = "";

        for (int i = 1; i <=satirElementleriList.size() ; i++) {

            // i. satirdaki category bilgisini alalim
            String satirdakiCategory = getCellData(i,2);

            if (satirdakiCategory.equalsIgnoreCase("travel")){
                actualFiyat = getCellData(i,3);
            }

        }

        Assertions.assertEquals(expectedFiyat,actualFiyat);







    }

    public String getCellData(int satir, int sutun){

        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";

       WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();
    }
}
