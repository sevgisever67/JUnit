package MyStudies.ScreenShoot;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.WatchEvent;

public class C02_TumSayfaScreenshot  extends TestBase {
    @Test
    public void test01() throws IOException {
    driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucElement= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucYazisi=sonucElement.getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]")).click();





        TakesScreenshot tss=(TakesScreenshot)driver;
        File tümSayfa=new File("target/ekranResimleri/tümSayfa.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tümSayfa);









    }

}
