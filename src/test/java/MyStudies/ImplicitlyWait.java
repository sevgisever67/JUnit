package MyStudies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImplicitlyWait {
    @Test
    public  void test01(){
        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //“It’s gone! " yazisi çıkana kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement itsGone=
                        wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//p[@id='message']")));

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement goneText= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(goneText.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //It’s back yazisi çıkıncaya kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        //7. It’s back mesajinin gorundugunu test edi
        WebElement backYazisi= driver.findElement(By.xpath("//p[@id='message']"));
        backYazisi.click();
        Assert.assertTrue(backYazisi.isDisplayed());
        driver.close();


    }
}
