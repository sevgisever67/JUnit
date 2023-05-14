package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String ht="https://www.";
        driver.get(ht+"google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to(ht+"amazon.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandle());
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        String handle= driver.getWindowHandle();
        System.out.println(driver.getWindowHandle()); //1CE3FE669CAC4226533D9A79F8D09DED - FDD888F612B1F0E8F188DFA52DC7671A
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ht+"wisequarter.com");
        System.out.println(driver.getWindowHandle());//5EC2B80485B4E37A6B2EABE9FF6122B0
        System.out.println(driver.getWindowHandles());//[E1F0E7AC5CA4B77A21556D4073B69A7D, 5EC2B80485B4E37A6B2EABE9FF6122B0]
        driver.switchTo().window(handle);
        driver.close(); // açık olan son browser'ı kapatır.
        //driver.quit();// birden fazla açılmış browser'ların tümünü kapatır

    }
}