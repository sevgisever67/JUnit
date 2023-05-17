package MyStudies.ActionFaker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Universty_Actions extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actionsHower=new Actions(driver);
        WebElement howerMi= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        WebElement link1= driver.findElement(By.xpath("//a[@class='list-alert'][1]"));
        actionsHower.moveToElement(howerMi)
                .click(link1).perform(); //3- Link 1" e tiklayin

        //4- Popup mesajini yazdirin
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        driver.findElement(By.xpath("//p[text()='Click and Hold!']")).click();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        Thread.sleep(2000);
        String clickHoldText=driver.findElement(By.xpath("//div[@style='background: tomato; font-size: 30px;']")).getText();
        System.out.println(clickHoldText);

        //8- “Double click me" butonunu cift tiklayin
        WebElement clickMe=driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actionsHower.doubleClick(clickMe).perform();


    }
}
