package MyStudies.ActionFaker;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class FkarClassFakeaccount extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3. “firstName” giris kutusuna bir isim yazin
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker fakeObj=new Faker();
        String mail=fakeObj.internet().emailAddress();
        actions.click(firstName)
                .sendKeys(fakeObj.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeObj.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeObj.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("22")
                .sendKeys(Keys.TAB)
                .sendKeys("may")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
      //  Thread.sleep(3000);

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement radioÖzel= driver.findElement(By.xpath("//input[@value='-1']"));
        Assert.assertFalse(radioÖzel.isSelected());
        WebElement radioErkek=driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(radioErkek.isDisplayed());
        WebElement radioKadın= driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(radioKadın.isSelected());
        //13. Sayfayi kapati



    }
}
