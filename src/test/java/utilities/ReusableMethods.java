package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
}
