/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hafta13_fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label etiket;
    private TranslateTransition tt;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Tıkladınız!");
        etiket.setText("Merhaba!");
        tt.setDuration(Duration.seconds(5));
        tt.setNode(etiket); 
        tt.setToY(-200);
        tt.setToX(-100);
        tt.setAutoReverse(true);
        tt.setCycleCount(TranslateTransition.INDEFINITE);
        tt.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tt = new TranslateTransition();
    }    
    
}
