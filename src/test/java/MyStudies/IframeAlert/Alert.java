package MyStudies.IframeAlert;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Alert extends TestBase {
    @Test
    public void test01 (){
        //3 test method'u olusturup asagidaki gorevi tamamlayin
        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        driver.switchTo().alert().getText();
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }@Test @Ignore
    public void test02(){
        //2.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        //- 2.alert'e tiklayalim

        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        //3.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin


    }
    @Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("sevgi");
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim

    }
}
