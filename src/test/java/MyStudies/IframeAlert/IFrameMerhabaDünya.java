package MyStudies.IframeAlert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IFrameMerhabaDünya  extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        WebElement ıFrameContainingYazısı= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(ıFrameContainingYazısı.isDisplayed());
        //konsolda yazdirin.
        System.out.println("ıFrameContainingYazısı : " + ıFrameContainingYazısı.getText());
        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement ıframetextBoxElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(ıframetextBoxElement);

        WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);
        textBox.clear();
        textBox.sendKeys("Merhaba yeni Dünyam");
//
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().parentFrame();
        WebElement seleniumText= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        seleniumText.isDisplayed();
        System.out.println("selenium text : " + seleniumText.getText());



    }


}
