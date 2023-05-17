package MyStudies.excell;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_DosyaXML {
    @Test
    public void test1() throws IOException {
        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook1= WorkbookFactory.create(fis);

        Sheet sheet=workbook1.getSheet("Sayfa1");
        Row row = sheet.getRow(1);
        Cell cell=row.getCell(3);
        System.out.println(cell);


        String actualData=sheet.getRow(2).getCell(3).toString();

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));


    }

}
