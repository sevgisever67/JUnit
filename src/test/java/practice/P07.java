package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
public class P07 {
    public static void main(String[] args) {

        //2 ) Nurse  3 farkli relative locator ile locate edin
        //3 ) Relative locator’larin dogru calistigini test edin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");
        //Biz nurse elementini normalde id ile "nurs_thumb" kullanarak locate edebiliriz.
        //Eğer locate edemediğimiz bir element olsaydı.
        //relative locator kullanarak locate edebildiğimiz bir element yardımıyla bulabiliriz
        //nurse elementi dr elementinin altında
        WebElement dr= driver.findElement(By.id("dr_thumb"));
        WebElement nurse= driver.findElement(RelativeLocator.with(By.tagName("img")).below(dr));
        if (nurse.getAttribute("id").equals("nurs_thumb")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

    }
}