package sirket;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ufukcelik
 */
public class AnaForm extends javax.swing.JFrame {

    /**
     * Creates new form AnaForm
     */
    public AnaForm() {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTreeMENU = new javax.swing.JTree();
        jDesktopPaneFORMLAR = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPERSONEL = new javax.swing.JMenu();
        jMenuItemKayitlar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuURUNLER = new javax.swing.JMenu();
        jMenuItemKayit = new javax.swing.JMenuItem();
        jMenuItemRapor = new javax.swing.JMenuItem();
        jMenuYARDIM = new javax.swing.JMenu();
        jMenuItemHakkinda = new javax.swing.JMenuItem();
        jMenuCikis = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(150);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("ANASAYFA");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("PERSONEL");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kayıtlar");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Liste");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ÜRÜNLER");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kayıt");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Rapor");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("YARDIM");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Hakkında");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kullanım");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ÇIKIŞ");
        treeNode1.add(treeNode2);
        jTreeMENU.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeMENU.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeMENUValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTreeMENU);

        jSplitPane1.setLeftComponent(jScrollPane2);

        javax.swing.GroupLayout jDesktopPaneFORMLARLayout = new javax.swing.GroupLayout(jDesktopPaneFORMLAR);
        jDesktopPaneFORMLAR.setLayout(jDesktopPaneFORMLARLayout);
        jDesktopPaneFORMLARLayout.setHorizontalGroup(
            jDesktopPaneFORMLARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );
        jDesktopPaneFORMLARLayout.setVerticalGroup(
            jDesktopPaneFORMLARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jDesktopPaneFORMLAR);

        jMenuPERSONEL.setText("PERSONEL");

        jMenuItemKayitlar.setText("Kayıtlar");
        jMenuItemKayitlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKayitlarActionPerformed(evt);
            }
        });
        jMenuPERSONEL.add(jMenuItemKayitlar);

        jMenuItem1.setText("Liste");
        jMenuPERSONEL.add(jMenuItem1);

        jMenuBar1.add(jMenuPERSONEL);

        jMenuURUNLER.setText("ÜRÜNLER");

        jMenuItemKayit.setText("Kayıt");
        jMenuItemKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKayitActionPerformed(evt);
            }
        });
        jMenuURUNLER.add(jMenuItemKayit);

        jMenuItemRapor.setText("Rapor");
        jMenuItemRapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRaporActionPerformed(evt);
            }
        });
        jMenuURUNLER.add(jMenuItemRapor);

        jMenuBar1.add(jMenuURUNLER);

        jMenuYARDIM.setText("YARDIM");

        jMenuItemHakkinda.setText("Hakkında");
        jMenuItemHakkinda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHakkindaActionPerformed(evt);
            }
        });
        jMenuYARDIM.add(jMenuItemHakkinda);

        jMenuBar1.add(jMenuYARDIM);

        jMenuCikis.setText("ÇIKIŞ");
        jMenuBar1.add(jMenuCikis);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemKayitlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKayitlarActionPerformed
        PersonelForm frmPersonel = new PersonelForm();
        this.jDesktopPaneFORMLAR.add(frmPersonel);
        frmPersonel.show();
    }//GEN-LAST:event_jMenuItemKayitlarActionPerformed

    private void jTreeMENUValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeMENUValueChanged
        String secilen = jTreeMENU.getLastSelectedPathComponent().toString();
        System.out.println("Seçim yolu : " + secilen);
        switch (secilen) {
            case "Kayıtlar":
                PersonelForm frmPersonel = new PersonelForm();
                this.jDesktopPaneFORMLAR.add(frmPersonel);
                frmPersonel.show();
                break;
            case "Hakkında":
                HakkindaForm frmHakkinda = new HakkindaForm();
                this.jDesktopPaneFORMLAR.add(frmHakkinda);
                frmHakkinda.show();
                break;
            case "Kayıt":
                UrunKayitForm frmUrunKayit = new UrunKayitForm();
                this.jDesktopPaneFORMLAR.add(frmUrunKayit);
                frmUrunKayit.show();
                break;
            case "Rapor":
                UrunRaporForm frmUrunRapor = new UrunRaporForm();
                this.jDesktopPaneFORMLAR.add(frmUrunRapor);
                frmUrunRapor.show();
                break;
            case "ÇIKIŞ":
                System.exit(0);
                break;
        }
    }//GEN-LAST:event_jTreeMENUValueChanged

    private void jMenuItemHakkindaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHakkindaActionPerformed
        HakkindaForm frmHakkinda = new HakkindaForm();
        this.jDesktopPaneFORMLAR.add(frmHakkinda);
        frmHakkinda.show();
    }//GEN-LAST:event_jMenuItemHakkindaActionPerformed

    private void jMenuItemKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKayitActionPerformed
        UrunKayitForm frmUrunKayit = new UrunKayitForm();
        this.jDesktopPaneFORMLAR.add(frmUrunKayit);
        frmUrunKayit.show();
    }//GEN-LAST:event_jMenuItemKayitActionPerformed

    private void jMenuItemRaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRaporActionPerformed
        UrunRaporForm frmUrunRapor = new UrunRaporForm();
        this.jDesktopPaneFORMLAR.add(frmUrunRapor);
        frmUrunRapor.show();
    }//GEN-LAST:event_jMenuItemRaporActionPerformed

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
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPaneFORMLAR;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCikis;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemHakkinda;
    private javax.swing.JMenuItem jMenuItemKayit;
    private javax.swing.JMenuItem jMenuItemKayitlar;
    private javax.swing.JMenuItem jMenuItemRapor;
    private javax.swing.JMenu jMenuPERSONEL;
    private javax.swing.JMenu jMenuURUNLER;
    private javax.swing.JMenu jMenuYARDIM;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTreeMENU;
    // End of variables declaration//GEN-END:variables
}
