/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Dobavljac;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Alek97
 */
public class UpdateDobavljacAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Dobavljac d1 = Controller.getInstance().getUpdateDobavljacView().getD1();

        String imeDobavljac = (String) Controller.getInstance().getUpdateDobavljacView().getImeDobavljacFLd().getText();
        String telefonDobavljac = (String) Controller.getInstance().getUpdateDobavljacView().getTelefonDobavljacFld().getText();

        d1.setIme(imeDobavljac);
        d1.setBr_telefona(telefonDobavljac);

        Baza.connect();
        Baza.updateDobavljac(d1);
        Baza.disconnect();

        OsveziTabelu.osveziTabelu();
        Controller.getInstance().getSideStage().close();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obavestenje");
        alert.setHeaderText(null);
        alert.setContentText("Dobavljac je uspesno izmenjen");
        alert.showAndWait();
    }

}
