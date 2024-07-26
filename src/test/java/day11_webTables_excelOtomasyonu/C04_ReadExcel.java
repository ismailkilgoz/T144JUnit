package day11_webTables_excelOtomasyonu;

import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void test01() throws IOException {

        // excel'e ulasip Sayfa1'da 8.satir 1.sutundaki datayi yazdiralim

        // 1.adim, Java ile dosyaya ulasabilmek icin dosya yolunu hazirlayalim
        String dosyaYolu ="src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";

        // Java ile dosyaya erisip icindeki bilgileri alalim
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 3. excel dosyalari birden fazla sayfa icerebilen ozel yapilar oldugundan
        //    bunu apache.poi kullanarak bir workbook olarak kaydedelim

        // Workbook workbook = new Workbook(); // 'Workbook' is abstract; cannot be instantiated

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // gercek excel'deki bilgileri Java yardimi ile okuyup
        // bu class'da olusturdugumuz workbook'a yukledik
        // workbook excel'deki tum bilgilere sahip ama excel'in bir kopyasi

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // excel'de Java gibi index kullanir ve index 0'dan baslar

        Row row8 = sayfa1.getRow(7);    // 8. satir icin index 7

        Cell data8ciSutun1ciData = row8.getCell(0); // 1. data icin index 0

        System.out.println(data8ciSutun1ciData);      // Argentina

    }

    @Test
    public void test02() throws IOException {

        // excel'deki Sayfa1'de 15.satirin 4.datasini yazdirin

        // Sayfa1'e kadar tum adimlari atmak zorundayiz
        String dosyaYolu ="src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // workbook olusturup excel'deki tum bilgileri workbook'a yukledik
        // bundan sonra workbook;da var olan bilgileri alacagiz, bunun icin get...() kullaniriz

        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        System.out.println(sayfa1.getRow(14).getCell(3));

        // Sayfa1'deki 22.satir 3. sutundaki bilginin Bolivya oldugunu test edin
        String exceptedData = "Bolivya";
        String actualData = sayfa1.getRow(21).getCell(2).toString();

        Assertions.assertEquals(exceptedData,actualData);
    }
}
