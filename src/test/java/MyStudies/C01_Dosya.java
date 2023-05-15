package MyStudies;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_Dosya {
    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook1= WorkbookFactory.create(fis);

        Sheet sheet=workbook1.getSheet("Sayfa1");
        Row row = sheet.getRow(1);
        Cell cell=row.getCell(3);
        System.out.println(cell);


    }

}
