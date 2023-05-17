package MyStudies.Homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class WindowHandleHomeworSoru extends TestBase {
    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin


        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        String windowBirHamdle=driver.getWindowHandle();
        //4.Diger window'a gecin
        Set<String> handleSet=driver.getWindowHandles();
        String windowikiHandle="";
        for (String eachHandle:handleSet) {
            if (eachHandle!=windowBirHamdle){
                windowikiHandle=eachHandle;
            }

        }
        driver.switchTo().window(windowikiHandle);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Actions action=new Actions(driver);
        Faker fake=new Faker();
        action.click(username).sendKeys(fake.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(fake.internet().password())
                .sendKeys(Keys.TAB)
        //6."login" butonuna basin
                .sendKeys(Keys.ENTER).perform();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText="validation failed";
        String actuelPopUptext= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actuelPopUptext);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowBirHamdle);
        //10.Ilk sayfaya donuldugunu test edi
        String ilkSayfaBaşlı=driver.getTitle();
        String actuelHandle=driver.getWindowHandle();
        Assert.assertEquals(windowBirHamdle,actuelHandle);


    }
}
