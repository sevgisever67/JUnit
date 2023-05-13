package MyStudies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYoluDinamikYapma extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        WebElement fotopng = driver.findElement(By.linkText("foto.png"));
        fotopng.click();
        Thread.sleep(2000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\tr\\Downloads\\foto.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(System.getProperty("user.dir"));
        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = "/Downloads/foto.png";

        String dosyaYolu1 = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
