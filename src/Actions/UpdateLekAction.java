/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Farmaceut;
import Tabele.Lek;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class UpdateLekAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Lek l = Controller.getInstance().getUpdateLekView().getL1();
        int dobavljacId;
        dobavljacId = Integer.valueOf(Controller.getInstance().getUpdateLekView().getDobavljacCb().getSelectionModel().getSelectedItem().toString());
        String imeLek = (String) Controller.getInstance().getUpdateLekView().getImeLekFld().getText();
        l.setDobavljac_id(dobavljacId);
        l.setIme(imeLek);
        Baza.connect();
        Baza.updateLek(l);
        Baza.disconnect();

        OsveziTabelu.osveziTabelu();
        Controller.getInstance().getSideStage().close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obavestenje");
        alert.setHeaderText(null);
        alert.setContentText("Lek je uspesno Izmenjen!");
        alert.showAndWait();
    }

}
