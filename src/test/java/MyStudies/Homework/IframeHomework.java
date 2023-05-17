package MyStudies.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeHomework extends TestBase {
    @Test
    public void test1(){
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        WebElement ourProduct=driver.findElement(By.xpath("//a[text()='Our Products']"));
        ourProduct.click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        //4. Popup mesajini yazdirin
        String popUp=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println("pop up text : "+popUp);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[@class='navbar-header'][1]")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedURL="http://webdriveruniversity.com/index.html";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);
    }
}
