/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Zamena;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Alek97
 */
public class UpdateZamenaAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Zamena z = Controller.getInstance().getUpdateZamenaView().getZ();

            int sifraLeka = Integer.valueOf(Controller.getInstance().getUpdateZamenaView().getSifraLekCb().getSelectionModel().getSelectedItem().toString());
            int sifraZamenaLeka = Integer.valueOf(Controller.getInstance().getUpdateZamenaView().getSifraZamenaCb().getSelectionModel().getSelectedItem().toString());

            z.setSifra_lek(sifraLeka);
            z.setZamena_sifra_lek(sifraZamenaLeka);

            Baza.connect();
            Baza.updateZamena(z);
            Baza.disconnect();

            OsveziTabelu.osveziTabelu();
            Controller.getInstance().getSideStage().close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText(null);
            alert.setContentText("Uspesno izmenjeno");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nisu uneti ispravni podaci");
            alert.showAndWait();
        }
    }

}
