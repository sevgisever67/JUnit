package day10_actionsClass_Faker_FileTesti;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KlavyeActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com ");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
       WebElement isimKutusu= driver.findElement(By.xpath("//*[@name='firstname']"));
        actions.sendKeys(isimKutusu)
                .sendKeys("sevgi")
                .sendKeys(Keys.TAB)
                .sendKeys("sevm")
                .sendKeys(Keys.TAB)
                .sendKeys("sevgisarar@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("sevgisarar@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("malatya4412")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("mayıs")
                .sendKeys(Keys.TAB)
                .sendKeys("2023")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //4- Kaydol tusuna basalim

    }
}
