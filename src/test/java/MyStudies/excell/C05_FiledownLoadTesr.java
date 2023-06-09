package MyStudies.excell;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FiledownLoadTesr extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        WebElement fotoElementi= driver.findElement(By.linkText("image.png"));
        fotoElementi.click();
        Thread.sleep(2000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\tr\\Downloads\\image.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
