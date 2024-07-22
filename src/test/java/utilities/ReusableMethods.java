package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getStringList(List<WebElement> kaynakList){
        List<String> stringList = new ArrayList<>();
        for ( WebElement eachElement : kaynakList
        ) {
            stringList.add(eachElement.getText());
        }
        return stringList;
    }

    public static void switchWindowByUrl(WebDriver driver, String hedefUrl){
        Set<String> acikWindowlarinWhdSeti = driver.getWindowHandles();
        for (String eachWhd : acikWindowlarinWhdSeti){
            //once bizim oglanin getirdigi whd ile bir window'a gecis yapalim
            driver.switchTo().window(eachWhd);
            String gecilenSayfaUrl= driver.getCurrentUrl();
            if (gecilenSayfaUrl.equals(hedefUrl)){
                break;
            }
        }
    }

    public static void switchWindowByTitle(WebDriver driver,String hedefTitle){
        Set<String> acikWindowlarinWhdSeti = driver.getWindowHandles();
        for (String eachWhd : acikWindowlarinWhdSeti){
            //once bizim oglanin getirdigi whd ile bir window'a gecis yapalim
            driver.switchTo().window(eachWhd);
            String gecilenSayfaTitle= driver.getTitle();
            if (gecilenSayfaTitle.equals(hedefTitle)){
                break;
            }
        }

    }
}
