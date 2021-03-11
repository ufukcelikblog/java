
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UygulamaIki {
    public static void main(String[] args) {
        String Dosya = "C:\\Users\\ufukcelik\\OneDrive\\ornek.xlsx";
        try {
            FileInputStream excelDosya = new FileInputStream(new File(Dosya));
            Workbook kitap = new XSSFWorkbook(excelDosya);
            Sheet sayfa = kitap.getSheetAt(0); // ilk çalışma sayfasını alır
            // sayfadaki bütün satirları al
            Iterator<Row> kademeSatir = sayfa.iterator();
            while(kademeSatir.hasNext()) {
                // siradaki satırı oku
                Row satir = kademeSatir.next();
                // o satırdaki tüm hücreleri al
                Iterator<Cell> kademeHucre = satir.iterator();
                while(kademeHucre.hasNext()) {
                    // o satırdaki sıradaki hücreyi okur
                    Cell hucre = kademeHucre.next();
                    if(hucre.getCellType() == CellType.STRING) {
                        System.out.print(hucre.getStringCellValue() + " -- ");
                    } else if(hucre.getCellType() == CellType.NUMERIC) {
                        System.out.print(hucre.getNumericCellValue() + " -- ");
                    }
                }
                System.out.println("");
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Hata: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("Hata: " + ex.toString());
        }
        
    }
}
