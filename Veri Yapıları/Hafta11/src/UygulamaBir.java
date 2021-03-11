
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UygulamaBir {

    private static final String Dosya = "C:\\Users\\ufukcelik\\OneDrive\\ornek.xlsx";

    public static void main(String[] args) {
        // Yeni bir Excel Dosyası (Çalışma Kitapı)
        XSSFWorkbook dosya = new XSSFWorkbook(); 
        XSSFSheet sayfa = dosya.createSheet("Örnek 1");
        Object[][] tablo = {
            {"Veri Yapısı", "Veri Tipi", "Büyüklük (Byte)"},
            {"int", "İlkel", 2},
            {"float", "İlkel", 4},
            {"String", "Gelişmiş", "Belirsiz"}
        };
        int satirNo = 0;
        System.out.println("Excel dosyası oluşturuluyor");
        for(Object[] tabloSatir : tablo) {
            Row satir = sayfa.createRow(satirNo++);
            int sütunNo = 0;
            for(Object tabloHucre : tabloSatir) {
                Cell hucre = satir.createCell(sütunNo++);
                if(tabloHucre instanceof String) {
                    hucre.setCellValue((String) tabloHucre);
                } else if(tabloHucre instanceof Integer) {
                    hucre.setCellValue((Integer) tabloHucre);
                }
            }
        }
        
        try {
            FileOutputStream dosyaVerisi = new FileOutputStream(Dosya);
            dosya.write(dosyaVerisi);
            dosya.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı hatası\n" + ex.toString());
        } catch (IOException ex) {
            System.out.println("Dosya yazma hatası\n" + ex.toString());
        }
        System.out.println("Excel dosyası oluşturuldu...");
    }
}
