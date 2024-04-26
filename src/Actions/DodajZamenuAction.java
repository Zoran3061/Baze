/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Zamena;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajZamenuAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {

            int zamena_id = Integer.valueOf(Controller.getInstance()
                    .getAddZamenaView().getIdZamenaFld().getText());
            int sifra_lek = Integer.valueOf(Controller.getInstance()
                    .getAddZamenaView().getSifraLekCb().getSelectionModel().getSelectedItem().toString());
            int sifra_zamena = Integer.valueOf(Controller.getInstance()
                    .getAddZamenaView().getSifraZamenaCb().getSelectionModel().getSelectedItem().toString());

            Zamena z = new Zamena(zamena_id, sifra_lek, sifra_zamena);

            Baza.connect();
            ArrayList<Zamena> zamene = Baza.getAllZamena();
            Baza.disconnect();

            int count = 0;
            for (Zamena zamena : zamene) {
                if (zamena.getZamena_id() == zamena_id) {
                    count++;
                }
            }

            int count2 = 0;
            if (sifra_lek == sifra_zamena) {
                count2++;
            }

            if (count2 > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Lek ne moze biti zamena za samog sebe.");
                alert.showAndWait();
            } else if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("ID zamene vec postoji.");
                alert.showAndWait();
            } else {
                Baza.connect();
                Baza.addZamena(z);
                Baza.disconnect();
                OsveziTabelu.osveziTabelu();
                Controller.getInstance().getSideStage().close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Zamena je uspesno ubacena u bazu");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nisu uneti ispravni podaci");
            alert.showAndWait();
        }
    }
}
