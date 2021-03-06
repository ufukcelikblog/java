
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ufukcelik
 */
public class ExcelBilgiJTable extends javax.swing.JFrame {

    /**
     * Creates new form ExcelBilgiJTable
     */
    public ExcelBilgiJTable() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ExcelBilgi = new javax.swing.JTable();
        jButton_ExcelDosya = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_ExcelBilgi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_ExcelBilgi);

        jButton_ExcelDosya.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ExcelDosya.setText("Aktarılacak Excel Dosyasını Seçiniz");
        jButton_ExcelDosya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcelDosyaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton_ExcelDosya, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_ExcelDosya, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExcelDosyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcelDosyaActionPerformed
        Vector tblBaslik = new Vector();
        Vector tblVeri = new Vector();

        JFileChooser dosyaSecici = new JFileChooser();
        int secim = dosyaSecici.showOpenDialog(this);
        if (secim == JFileChooser.APPROVE_OPTION) {
            File dosya = dosyaSecici.getSelectedFile();
            if (!dosya.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(this, "Lütfen Excel Dosyası Seçin",
                        "Hata", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Workbook kitap = new XSSFWorkbook(dosya);
                    Sheet sayfa = kitap.getSheetAt(0); // ilk sayfayı alır
                    tblBaslik.clear();
                    Row ilkSatir = sayfa.getRow(0);
                    Iterator<Cell> kademeBaslik = ilkSatir.iterator();
                    while (kademeBaslik.hasNext()) {
                        Cell hucre = kademeBaslik.next();
                        tblBaslik.add(hucre.getStringCellValue());
                    }
                    tblVeri.clear();
                    for (int sat = 1; sat < sayfa.getLastRowNum(); sat++) {
                        Row satir = sayfa.getRow(sat);
                        Vector birKayit = new Vector();
                        Iterator<Cell> kademeSatir = satir.iterator();
                        while (kademeSatir.hasNext()) {
                            Cell hucre = kademeSatir.next();
                            if (hucre.getCellType() == CellType.STRING) {
                                birKayit.add(hucre.getStringCellValue());
                            } else if (hucre.getCellType() == CellType.NUMERIC) {
                                birKayit.add(hucre.getNumericCellValue());
                            }
                        }
                        tblVeri.add(birKayit);
                    }
                    DefaultTableModel dtm = new DefaultTableModel(tblVeri, tblBaslik);
                    jTable_ExcelBilgi.setModel(dtm);
                } catch (IOException ex) {
                    Logger.getLogger(ExcelBilgiJTable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(ExcelBilgiJTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton_ExcelDosyaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExcelBilgiJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcelBilgiJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcelBilgiJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcelBilgiJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcelBilgiJTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ExcelDosya;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ExcelBilgi;
    // End of variables declaration//GEN-END:variables
}
