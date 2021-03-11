package ufuk;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UygulamaBir {
    private static boolean tabloVar(String tabloAd, Connection bag) throws SQLException {
        DatabaseMetaData meta = bag.getMetaData();
        ResultSet sonuc = meta.getTables(null, null, tabloAd.toUpperCase(), null);
        return sonuc.next();
    }
    public static void main(String[] args) {
        String veritabani = "jdbc:derby:stok;create=true";
        String projeAdresi = System.getProperty("user.dir", ".");
        JOptionPane.showMessageDialog(null, "Proje Adresi: " + projeAdresi);
        try (Connection bag = DriverManager.getConnection(veritabani)) {
            Statement st = bag.createStatement();
            if(!tabloVar("urun", bag)) { // ürün tablosu yoksa
                String sql = "CREATE TABLE urun (id INT PRIMARY KEY, ad VARCHAR(100))";
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Ürün tablosu oluşturuldu...");
                
                sql = "INSERT INTO urun VALUES (1,'Masa'), (2, 'Koltuk'), (3, 'Sehpa')";
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "3 adet ürün kaydedildi...");
            }
            String sql = "SELECT * FROM urun";
            ResultSet sonuc = st.executeQuery(sql);
            while(sonuc.next()) {
                JOptionPane.showMessageDialog(null, "ID: " + sonuc.getInt("id") + " AD: " + sonuc.getString("ad"));
            }
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch(SQLException ex) {
            if(ex.getSQLState().equals("XJ015")) {
                JOptionPane.showMessageDialog(null, "Derby veritabanı normal şekilde kapatıldı");
            } else {
                JOptionPane.showMessageDialog(null, "HATA: " + ex.toString());
            }
        }
    }
}
