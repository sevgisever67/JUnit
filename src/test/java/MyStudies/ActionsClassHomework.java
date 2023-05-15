package MyStudies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassHomework {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverMe= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverMe).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//a[text()='Link 1']")).click();
        //4. Popup mesajini yazdirin
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickHoldText= driver.findElement(By.id("click-box"));
        clickHoldText.click();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin

        String clickText=driver.findElement(By.xpath("//div[text()='Dont release me!!!']")).getText();
        System.out.println(clickText);


        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();


    }
}
