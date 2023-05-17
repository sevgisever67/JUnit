package MyStudies.DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropdown {
    static WebDriver driver;
    /*
     ● Bir class oluşturun: C3_DropDownAmazon
     ● https://www.amazon.com/ adresine gidin.

     -Test 2
     1. Kategori menusunden Books secenegini secin
     2. Arama kutusuna Java yazin ve aratin
     3. Bulunan sonuc sayisini yazdirin
     4. Sonucun Java kelimesini icerdigini test edin
     */
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");

    }
    @After
    public void teardown() {
        driver.close();
    }
    @Test
    public void test01(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        // Element dropdown menu oldugu icin Select class'indan olusturacagimiz
        // obje ile ilgili method'lari kullanmaliyiz

        WebElement dropdownMenuElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownMenuElementi);
        int expectedOptionSayisi=45;
        int actualOptionSayisi= select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }
    @Test
    public void test02(){
        WebElement dropdownMenuElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownMenuElementi);
        //  1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Kitaplar");
        //  2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        //  3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayiElementi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(sonucSayiElementi.getText());
        //  4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actualSonucYazisi= sonucSayiElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));



    }

}
