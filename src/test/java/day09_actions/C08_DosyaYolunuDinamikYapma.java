package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_DosyaYolunuDinamikYapma extends TestBaseEach {

    @Test
    public void test01(){

        /*
            Bir projede kod yazdigimizda
            kod'un bulundugu her bilgisayarda calismasi gerekir

            Bunun icin dosya yolunu kisilel bilgilerden arindirmak gerekir

            Java bu tur ortak projelerde
            dosya yolunun saglikli calismasi icin
            standart 2 dosya yolu baslangici belirlemis

            1 - System.getProperty("user.home") ==> bilgisayarin ana dosya yolunu verir "C:/Users/Administrator/"
                                               yani herkeste farkli olan kismi verir
         */

        // Downloads klasorunde sample.png dosyasi bulundugunu test edin

        //String dosyaYolu = "C:/Users/Administrator/Downloads/sample.png";

        String dosyaYolu = System.getProperty("user.home") + "/Downloads/sample.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
            2 - System.getProperty("user.dir") ==> uzerinde calistigimiz projenin ana klasorunu verir

         */

        // Projemizde day09 package'inda sample.png dosyasi bulundugunu test edin

        // String dosyaYolu2 = "src/test/java/day09_actions/sample.png";

        String dosyaYolu2 = System.getProperty("user.dir")+"/src/test/java/day09_actions/sample.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu2)));

        //C:\Users\Administrator\IdeaProjects\Team144_JUnit\src\test\java\day09_actions\sample.png

        System.out.println(System.getProperty("user.dir"));



    }
}
