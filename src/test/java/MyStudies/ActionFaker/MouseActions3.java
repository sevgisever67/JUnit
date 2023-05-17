package MyStudies.ActionFaker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class MouseActions3 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement accountList= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(accountList).perform();
        Thread.sleep(2000);

        //3- “Create a list” butonuna basin
        WebElement createAccount=driver.findElement(By.xpath("//*[text()='Create a List']"));
        createAccount.click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        System.out.println(driver.findElement(By.xpath("//div[@role='heading']")).getText());

    }
}
