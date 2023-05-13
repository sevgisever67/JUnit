package day10_actionsClass_Faker_FileTesti;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_FakerClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com ");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement isimKutusu= driver.findElement(By.xpath("//*[@name='firstname']"));
        Faker faker=new Faker();
        actions.sendKeys(isimKutusu);



    }
}
