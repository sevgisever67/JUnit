package MyStudies;

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

import java.util.List;

public class GenelTekrarHomework extends TestBaseBeforeClass {
    @Test
    public void test01(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        String anasayfaHandle=driver.getWindowHandle();
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdown= driver.findElement(By.xpath("//div[@data-index='2']"));
        Select selections=new Select(dropdown);
        List<WebElement> obtionslist= selections.getOptions();
        for (WebElement  each:obtionslist) {
            System.out.println(each.getText());
        }
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        int exceptedElemansayisi=40;
        int actuelelemansayisi=obtionslist.size();
        Assert.assertEquals(exceptedElemansayisi,actuelelemansayisi);



    }

    @Test
    public void test02() throws InterruptedException {


        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selections=new Select(dropdown);
        selections.selectByVisibleText("Electronics");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonuçYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonuçYazisi);
        String expectedİçerik="iphone";
        Assert.assertTrue(sonuçYazisi.contains(expectedİçerik));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrün=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        WebElement ikinciUrün=driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(birinciUrün));
        ikinciUrün.click();



        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String ürünTitle=driver.getTitle();

        String ikinciÜrünParaBirimi=driver.findElement(By.xpath("//span[@class='a-price-symbol'][1]")).getText();
        String ikinciÜrünTamfiyatKısmı=driver.findElement(By.xpath("//span[@class='a-price-whole'][1]")).getText();
        String ikinciÜrünKüsüratFiyatı=driver.findElement(By.xpath("//span[@class='a-price-fraction'][1]")).getText();

        System.out.print("Ürün Fiyatı : "+ikinciÜrünParaBirimi+ikinciÜrünTamfiyatKısmı+"."+ikinciÜrünKüsüratFiyatı);






    }

    @Test @Ignore
    public void test03(){
        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.amazon.com");
        //2-dropdown’dan bebek bölümüne secin
        WebElement dropdownMenü= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdownMenü);
        select.selectByVisibleText("Baby");
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset"+Keys.ENTER);
        //4-sonuç yazsının puset içerdiğini test edin
        String sonçYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]")).getText();
        Assert.assertTrue(sonçYazisi.contains("puset"));
        System.out.println(sonçYazisi);
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrün=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        driver.findElement(RelativeLocator.with(By.tagName("div")).below(ikinciUrün)).click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
