/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hafta14;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ufukcelik
 */
public class FXMLrehberController implements Initializable {

    @FXML
    private TextField alanAD, alanSOYAD, alanEPOSTA, alanTELEFON, alanADRES, alanPOSTAKOD, alanSEHIR;
    @FXML
    private DatePicker alanTARIH;
    @FXML
    private TableView<Kisi> tabloKISILER;
    @FXML
    private TableColumn<Kisi, String> sütunAD;
    @FXML
    private TableColumn<Kisi, String> sütunSOYAD;

    private ObservableList<Kisi> kisiler = FXCollections.observableArrayList();

    @FXML
    private TabPane tabPaneREHBER;
    @FXML
    private Tab tabKISI;
    @FXML
    private Tab tabGRAFIK;
    @FXML
    private BarChart<String, Integer> barGrafik;
    @FXML
    private CategoryAxis eksenAylar;
    private ObservableList<String> ayAdlar = FXCollections.observableArrayList();

    public void dogumGrafikAyarla(List<Kisi> tumKisiler) {
        barGrafik.getData().clear();
        int[] aySayac = new int[12];
        for (Kisi k : tumKisiler) {
            int ay = k.getTarih().getMonthValue() - 1;
            aySayac[ay]++;
        }
        XYChart.Series<String, Integer> seriler = new XYChart.Series<>();
        for (int i = 0; i < aySayac.length; i++) {
            seriler.getData().add(new XYChart.Data<>(ayAdlar.get(i), aySayac[i]));
        }
        barGrafik.getData().add(seriler);
    }

    public void TabloKisilerDoldur() {
        sütunAD.setCellValueFactory(new PropertyValueFactory<Kisi, String>("ad"));
        sütunSOYAD.setCellValueFactory(new PropertyValueFactory<Kisi, String>("soyad"));
        tabloKISILER.setItems(kisiler);
        tabloKISILER.refresh();
    }

    public void KisiGoster(Kisi kisi) {
        if (kisi != null) {
            alanAD.setText(kisi.getAd());
            alanSOYAD.setText(kisi.getSoyad());
            alanTARIH.setValue(kisi.getTarih());
            alanEPOSTA.setText(kisi.getEposta());
            alanTELEFON.setText(kisi.getTelefon());
            alanADRES.setText(kisi.getAdres());
            alanPOSTAKOD.setText("" + kisi.getPostakod());
            alanSEHIR.setText(kisi.getSehir());
        } else {
            alanAD.setText("");
            alanSOYAD.setText("");
            alanTARIH.setValue(LocalDate.of(2000, 03, 18));
            alanEPOSTA.setText("");
            alanTELEFON.setText("");
            alanADRES.setText("");
            alanPOSTAKOD.setText("");
            alanSEHIR.setText("");
        }
    }

    public void dugmeYENIaksiyonu() {
        alanAD.setText("");
        alanSOYAD.setText("");
        alanTARIH.setValue(LocalDate.of(2000, 03, 18));
        alanEPOSTA.setText("");
        alanTELEFON.setText("");
        alanADRES.setText("");
        alanPOSTAKOD.setText("");
        alanSEHIR.setText("");
    }

    public void dugmeEKLEaksiyonu() {
        try {
            kisiler.add(new Kisi(alanAD.getText(), alanSOYAD.getText(), alanTARIH.getValue(),
                    alanEPOSTA.getText(), alanTELEFON.getText(), alanADRES.getText(),
                    Integer.parseInt(alanPOSTAKOD.getText()), alanSEHIR.getText()));
            TabloKisilerDoldur();
        } catch (NumberFormatException hata) {
            Alert uyari = new Alert(AlertType.ERROR);
            uyari.setTitle("HATA");
            uyari.setHeaderText("Posta Kodu Sayı Olmalıdır !!!");
            uyari.setContentText(hata.toString());
            uyari.showAndWait();
        }
    }

    public void dugmeGUNCELLEaksiyonu() {
        int secilen = tabloKISILER.getSelectionModel().getSelectedIndex();
        System.out.println("Seçilen Indeks = " + secilen);
        if (secilen != -1) {
            kisiler.get(secilen).setAd(alanAD.getText());
            kisiler.get(secilen).setSoyad(alanSOYAD.getText());
            kisiler.get(secilen).setTarih(alanTARIH.getValue());
            kisiler.get(secilen).setEposta(alanEPOSTA.getText());
            kisiler.get(secilen).setTelefon(alanTELEFON.getText());
            kisiler.get(secilen).setAdres(alanADRES.getText());
            kisiler.get(secilen).setPostakod(Integer.parseInt(alanPOSTAKOD.getText()));
            kisiler.get(secilen).setSehir(alanSEHIR.getText());
            TabloKisilerDoldur();
        } else {
            Alert uyari = new Alert(AlertType.ERROR);
            uyari.setTitle("HATA");
            uyari.setHeaderText("seçim Yapılmadı !!!");
            uyari.setContentText("Güncellemek için bir kayıt seçmelisiniz");
            uyari.showAndWait();
        }
    }

    public void dugmeSILaksiyonu() {
        int secilen = tabloKISILER.getSelectionModel().getSelectedIndex();
        System.out.println("Seçilen Indeks = " + secilen);
        if (secilen != -1) {
            kisiler.remove(secilen);
            TabloKisilerDoldur();
        } else {
            Alert uyari = new Alert(AlertType.ERROR);
            uyari.setTitle("HATA");
            uyari.setHeaderText("seçim Yapılmadı !!!");
            uyari.setContentText("Silmek için bir kayıt seçmelisiniz");
            uyari.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Kisi k1 = new Kisi("Asya", "GÜLCE", LocalDate.of(1998, 02, 24),
                "asya@mail.com", "0555000111222", "Cumhuriyet Mah.", 34000, "İstanbul");
        kisiler.add(k1);
        kisiler.add(new Kisi("Ali", "KARA", LocalDate.of(1980, 05, 30),
                "ali@mail.com", "0555000111222", "Hürriyet Mah.", 34000, "İstanbul"));
        kisiler.add(new Kisi("Ahmet", "BÜYÜK", LocalDate.of(2080, 05, 12), "abuyuk@hotmail.com", "05551112233", "Eskiciler MAhallesi", 13680, "Adana"));
        kisiler.add(new Kisi("Ayşe", "ÇİÇEK", LocalDate.of(2000, 05, 12), "ayse@gmail.com", "05551112233", "Güllübaba Caddesi", 42211, "Konya"));
        kisiler.add(new Kisi("Fatih", "VARNA", LocalDate.of(2001, 01, 26), "fvarna@gmail.com", "05551112233", "Babali Yokuşu", 34201, "İstanbul"));
        kisiler.add(new Kisi("Fatma", "DİLEK", LocalDate.of(1999, 03, 19), "fatma@gmail.com", "05551112233", "Güllübaba Caddesi", 42211, "Konya"));
        TabloKisilerDoldur();
        tabloKISILER.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> KisiGoster(newValue)
        );

        String[] aylar = {"OCAK", "ŞUBAT", "MART", "NİSAN", "MAYIS", "HAZİRAN",
            "TEMMUZ", "AĞUSTOS", "EYLÜL", "EKİM", "KASIM", "ARALIK"};
        ayAdlar.addAll(Arrays.asList(aylar));
        eksenAylar.setCategories(ayAdlar);
        tabPaneREHBER.getSelectionModel().selectedItemProperty().addListener(
          new ChangeListener<Tab>() {
                @Override
                public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                    if(newValue.equals(tabGRAFIK)) {
                        dogumGrafikAyarla(kisiler);
                    }
                }
            }
        );
    }

}
