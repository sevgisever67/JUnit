package MyStudies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }


    @Test
    public void test1(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        //online backing
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement CurrencyDropdown= driver.findElement(By.id("pc_currency"));
        Select dropdonCurrency=new Select(CurrencyDropdown);
        dropdonCurrency.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("20");
        //10. “US Dollars” in secilmedigini test edin
        WebElement dollarsRaioButton= driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollarsRaioButton.isSelected());


    }@Test
    public void test2(){
        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("(//label[@class='radio inline'])[3]")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        driver.findElement(By.xpath("//div[@id='alert_content']")).isDisplayed();


    }




}
