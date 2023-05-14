package MyStudies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeybordActions extends TestBase {
    @Test
    public void test01(){
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actionsObj=new Actions(driver);
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        //4- videoyu izlemek icin Play tusuna basin
        WebElement videoelement= driver.findElement(By.xpath("//iframe[@width='560']"));
        actionsObj.scrollToElement(videoelement).perform();
        videoelement.click();
        //5- videoyu calistirdiginizi test edin
    }
}
