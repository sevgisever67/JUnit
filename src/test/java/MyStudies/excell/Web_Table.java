package MyStudies.excell;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Web_Table extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //Bir Class olusturun D19_WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List < WebElement> basliklarList=driver.findElements(By.xpath("//div[@role='row']"));
        for (WebElement each:basliklarList) {
            System.out.println(each.getText());
        }
        //3. 3.sutunun basligini yazdirin
        //String dinamikXpat="//div[@role='row'][1]/div[3]";
        System.out.println(driver.findElement(By.xpath("//div[@role='row'][1]/div[3]")).getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tumData=driver.findElements(By.xpath("//div[@role='row'][1]/div"));
        for (WebElement each:tumData) {
            if (!(each.getText().isBlank())){
                System.out.println(each.getText());
            }

        }
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosOlmayanData=1;
        for (WebElement each:tumData) {
            if (!(each.getText().isBlank())){
                bosOlmayanData++;
            }
        }
        System.out.println("Bos olmayan Data syaisi" + bosOlmayanData);
        //6. Tablodaki satir sayisini yazdirin
        int satirsayisi=driver.findElements(By.xpath("//div[@role='row']")).size();
        System.out.println("satir sayisi: "+satirsayisi);
        //Thread.sleep(2000);
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("sutun sayisi : "+basliklarList.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuData=driver.findElements(By.xpath("//div[@role='row']/div[3]"));
        for (WebElement eachData:ucuncuData) {
            if (!(eachData.getText().isBlank())){
                System.out.println(eachData.getSize());
            }
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        String dinamik ="//div[@role='row']/div[5]";
        String isimier="//div[@role='row']/div[1]";




        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsi
    }
}
