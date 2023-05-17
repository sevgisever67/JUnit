package MyStudies.Homework;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

import java.lang.reflect.Array;
import java.util.List;

public class GenelTekrarHomework extends TestBaseBeforeClass {
    @Test
    public void test01() {
        //Test01 :
        // 1- amazon gidin
        driver.get("https://www.amazon.com");

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownMenuElementi = driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdownMenuElementi);
        List<WebElement> DMListesi = select.getOptions();
        int siraNo = 1;
        for (WebElement each : DMListesi
        ) {
            System.out.println(siraNo + " == " + each.getText());
            siraNo++;
        }

        //3- dropdown menude 40 eleman olduğunu doğrulayın
        int expectedSonuc = 40;
        int actualIcerik = DMListesi.size();
        Assert.assertEquals(expectedSonuc, actualIcerik);
    }

    @Test
    public void test02() {
        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropdownMenuElementi = driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdownMenuElementi);
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("iphone" + Keys.ENTER);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucSayiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedIcerik = "iphone";
        String actualSonuc = sonucSayiElementi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("div")).toRightOf(birinciUrun));
        ikinciUrun.click();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String urunTitle = driver.findElement(By.id("productTitle")).getText();
        String urunFiyat = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[6]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Test
    public void test03() throws InterruptedException {
        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //String ikinciSayfaWHD=driver.getWindowHandle();

        //2-dropdown’dan Baby bölümüne secin
        WebElement dropdownMenuElementi = driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdownMenuElementi);
        select.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("bebek puset" + Keys.ENTER);
        String sonucSayisiYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        String[] sonucArr = sonucSayisiYazisi.split(" ");
        System.out.println(sonucArr[0]);

        //4-sonuç yazsının puset içerdiğini test edin
        String expectedSonuc = "puset";
        String actualSonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement birinciUrunElementi = driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]"));
        WebElement ikinciUrunElementi = driver.findElement(RelativeLocator.with(By.tagName("span")).below(birinciUrunElementi));
        ikinciUrunElementi.click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urunTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
       // String urunFiyat = driver.findElement(By.xpath("(//span[text()='$18.99'])[1]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(5000);
    }
}