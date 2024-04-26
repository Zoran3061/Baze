/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Recept;
import java.time.ZoneId;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajReceptAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {

            if (Controller.getInstance().getAddReceptView().getDatumDp()
                    .getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Datum nije izabran");
                alert.showAndWait();
            } else {

                String jmbg_pacijent = Controller.getInstance()
                        .getAddReceptView().getJmbgPacijentCb().getSelectionModel().getSelectedItem().toString();
                int sifra_lek = Integer.valueOf(Controller.getInstance()
                        .getAddReceptView().getSifraLekCb().getSelectionModel().getSelectedItem().toString());
                String jmbg_doktor = Controller.getInstance()
                        .getAddReceptView().getJmbgDoktorCb().getSelectionModel().getSelectedItem().toString();
                java.util.Date utilDatum
                        = java.util.Date.from(
                                Controller.getInstance().getAddReceptView().getDatumDp()
                                        .getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDate = new java.sql.Date(utilDatum.getTime());
                int kolicina_lekova = Integer.valueOf(Controller.getInstance()
                        .getAddReceptView().getKolicinaLekovaFld().getText());

                Recept r = new Recept(0, jmbg_pacijent, sifra_lek, jmbg_doktor, sqlDate, kolicina_lekova);

                Baza.connect();
                Baza.addRecept(r);
                Baza.disconnect();
                OsveziTabelu.osveziTabelu();
                Controller.getInstance().getSideStage().close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Recept je uspesno ubacen u bazu");
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
