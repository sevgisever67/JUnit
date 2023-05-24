package MyStudies.excell;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTable extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions action=new Actions(driver);
        action.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        WebElement table= driver.findElement(By.tagName("tbody"));
        System.out.println(table.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirElementList=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirsayisi=10;
        int actualSatirSayisi=satirElementList.size();
        Assert.assertEquals(expectedSatirsayisi,actualSatirSayisi);

        //5.Tum satirlari yazdirin
        System.out.println("=======================");
        for (WebElement eachSatir:satirElementList) {
            System.out.println(eachSatir.getText());

        }
        Thread.sleep(3000);
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunSayisiList= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi=14;
        int actualSutunSayisi=sutunSayisiList.size();
        //7. 5.sutunu yazdirin
        List<WebElement> sutunSayisiList5= driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachSutun:sutunSayisiList5) {
            System.out.println("========Sütün Sayisi=============");
            System.out.println(eachSutun.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturu
        satirSutun(2,5);
    }

    private String satirSutun(int satirNo, int sutunNo) {
        // //tbody/tr[5]/td[9]
        String dinamikXpect="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenDataElement= driver.findElement(By.xpath(dinamikXpect));

        return istenenDataElement.getText();
    }
}
