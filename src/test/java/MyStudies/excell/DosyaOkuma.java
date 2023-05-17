package MyStudies.excell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class DosyaOkuma {
    @Test
    public void test01() throws IOException {
        String dosyaYolu=System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        Boolean flag=false;
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonSatirIndexi; i++) {
            String isim=workbook
                    .getSheet("Sayfa1")
                    .getRow(i).getCell(1)
                    .toString();
            if (isim.equalsIgnoreCase("Benin")){
                flag=true;
            }

        }


        //sayfadaki tüm ülkr isimlerini map olarak kaydedin
        Map<String,String> ulkeIsimleri=new TreeMap<>();

        Sheet sheet=workbook.getSheet("Sayfa1");
        for (int i = 0; i <=sonSatirIndexi ; i++) {

            String key= sheet
                    .getRow(i)
                    .getCell(0)
                    .toString();

            String value=sheet.getRow(i).getCell(1)+","+
                    sheet.getRow(i).getCell(2)+","+
                    sheet.getRow(i).getCell(3).toString();

            ulkeIsimleri.put(key,value);
            
        }

        //ismi Netherlans olan ülke var mi?

        Boolean NetharlandVarmi=false;

        for (int i = 0; i < sonSatirIndexi; i++) {
            String ülkeIsmi=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            if (ülkeIsmi.equalsIgnoreCase("Netherlands")){
                NetharlandVarmi=true;
                break;
            }
        }
        Assert.assertTrue(NetharlandVarmi);




    }
}
