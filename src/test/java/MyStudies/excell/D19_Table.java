package MyStudies.excell;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class D19_Table extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //Bir Class olusturun D19_WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikListesi=driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (WebElement eachBaslik:baslikListesi) {
            System.out.println(eachBaslik.getText());
        }

        //3. 3.sutunun basligini yazdirin
        String ucuncuBaslik=driver.findElement(By.xpath("//div[@role='columnheader'][3]")).getText();
        System.out.println(ucuncuBaslik);
        System.out.println(baslikListesi.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        List <WebElement> tumDatalar= driver.findElements(By.xpath("//div[@role='gridcell']"));
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosOlmayanData=0;
        for (WebElement each:tumDatalar) {
            if (!each.getText().isBlank()){
                System.out.println(each.getText());
                bosOlmayanData++;
            }
        }


        //6. Tablodaki satir sayisini yazdirin
        List <WebElement>satirList =driver.findElements(By.xpath("//div[@role='rowgroup']"));
        int satirsayisi=satirList.size();
        System.out.println("satirSayisi : "+satirsayisi);
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println(baslikListesi.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutun=driver.findElements(By.xpath("//div[@role='row']/div[3]"));
        for (WebElement eachData:ucuncuSutun) {
            System.out.println("=======3.Sutun==========");
                System.out.println(eachData.getText());

        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdiri

        for (int i = 2; i <satirList.size() ; i++) {
            String isim= driver.findElement(By.xpath(datayiBul(i,1))).getText();
            if (isim.equalsIgnoreCase("Kierra")){
                String maas=driver.findElement(By.xpath(dinamikXpat(i,5))).getText();
                System.out.println(isim+ " nin maasi : "+ maas );
            }
        }

        //10.  bir method olusturun,  satir ve sutun
        //     sayisini girdigimde bana datayi yazdirsin
        String istenenHücre=datayiBul(3,2);
        System.out.println(istenenHücre);


    }

    private String datayiBul(int satirNo, int sutunNo) {
        String dinamikxpat="(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
        return  driver.findElement(By.xpath(dinamikxpat)).getText();
    }

    public String dinamikXpat(int satirNo, int sutunNo) {

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";

    }

}
