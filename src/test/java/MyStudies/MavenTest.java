package MyStudies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MavenTest {
    WebDriver driver;
    @Test
    public void test1(){
        mahserin4Atlisi();
        driver.get("https://www.saucedemo.com");
        WebElement usernamebox= driver.findElement(By.id("user-name"));
        usernamebox.sendKeys("standard_user");
        WebElement passwordbox= driver.findElement(By.id("password"));
        passwordbox.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement ürünElement=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        String ürünİsmi=ürünElement.getText();
        System.out.println("ürün ismi"+ürünİsmi);
        ürünElement.click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement sepettekiElement= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String sepettekiÜrünİsmi=sepettekiElement.getText();
        Assert.assertEquals(ürünİsmi,sepettekiÜrünİsmi);



    }
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
