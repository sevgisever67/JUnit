package MyStudies.DropDown;

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
import java.util.List;

public class HeroKuap {
   static WebDriver driver;

    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public static void tearDown(){
       // driver.close();
    }
    @Test
    public void test1(){
        //● Bir class oluşturun: DropDown
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
        //  c. Checkbox1 seçili değilse onay kutusunu tıklayın
        WebElement checkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        if (!(checkBox1.isSelected())){
            checkBox1.click();
        }
        //  d. Checkbox2 seçili değilse onay kutusunu tıklayın
        WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if (!(checkBox2.isSelected())){
            checkBox2.click();
        }
        //  e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox1.isSelected());

    }
    @Test
    public void test2(){

        //1dsyfs geri git
        driver.navigate().back();
        //Dropdown elementini tıklayın
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement optionsDropDown= driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select optionDrapDown1=new Select(optionsDropDown);
        optionDrapDown1.selectByIndex(1);
        System.out.println(optionDrapDown1.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        optionDrapDown1.selectByValue("2");
        System.out.println(optionDrapDown1.getFirstSelectedOption().getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        optionDrapDown1.selectByVisibleText("Option 1");
        System.out.println(optionDrapDown1.getFirstSelectedOption().getText());
        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionlist=optionDrapDown1.getOptions();
        System.out.println("optionlist.get(1) = " + optionlist.get(1).getText());
        System.out.println("optionlist.get(2) = " + optionlist.get(2).getText());

                //====2.Yöntemmm=======//

        for (WebElement each:optionlist) {
            System.out.println(each.getText());
        }

        //5. Dropdown’un boyutunun 4 olduğunu test edin




    }

}
