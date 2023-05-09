package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStudies {
    WebDriver driver;


    @Test
    public void google() {
        mahserin4Atlısı();
        driver.get("http://www.amazon.com");
        String actualtitle = driver.getTitle();
        String expectİçerik = "amazon";
        Assert.assertTrue(actualtitle.contains(expectİçerik));
        Assert.assertFalse(actualtitle.contains(expectİçerik));

    }




    public void mahserin4Atlısı (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
