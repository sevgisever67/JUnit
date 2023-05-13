package MyStudies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;

public class mauseAction2 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actionButton=new Actions(driver);
        WebElement dragMe= driver.findElement(By.id("draggable"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actionButton.dragAndDrop(dragMe,dropHere).perform();
        Thread.sleep(2000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test ed
        WebElement droppedYaziElementi = driver.findElement(By.tagName("p"));
        String expectedyazi = "Dropped!";
        String actualYazi = droppedYaziElementi.getText();
        Assert.assertEquals(expectedyazi,actualYazi);

    }
}
