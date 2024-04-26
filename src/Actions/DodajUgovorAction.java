/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Ugovor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajUgovorAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            java.sql.Date pocetak_vazenja;
            java.sql.Date kraj_vazenja;

            if (Controller.getInstance().getAddUgovorView().getPocetakVazenjaDp().getValue() == null) {
                pocetak_vazenja = null;
            } else {
                LocalDate pocetakVazenjaDp = Controller.getInstance().getAddUgovorView().getPocetakVazenjaDp().getValue();
                java.util.Date utilDatum = java.util.Date.from(pocetakVazenjaDp.atStartOfDay(ZoneId.systemDefault()).toInstant());
                pocetak_vazenja = new java.sql.Date(utilDatum.getTime());
            }

            if (Controller.getInstance().getAddUgovorView().getKrajVazenjaDp().getValue() == null) {
                kraj_vazenja = null;
            } else {
                LocalDate krajVazenjaDp = Controller.getInstance().getAddUgovorView().getKrajVazenjaDp().getValue();
                java.util.Date utilDatum = java.util.Date.from(krajVazenjaDp.atStartOfDay(ZoneId.systemDefault()).toInstant());
                kraj_vazenja = new java.sql.Date(utilDatum.getTime());
            }

            int id = Integer.valueOf(Controller.getInstance().getAddUgovorView().getUgovorIdFld().getText());
            int id_dobavljac = Integer.valueOf(Controller.getInstance()
                    .getAddUgovorView().getIdDobavljacCb().getSelectionModel().getSelectedItem().toString());
            int id_apoteka = Integer.valueOf(Controller.getInstance()
                    .getAddUgovorView().getIdApotekaCb().getSelectionModel().getSelectedItem().toString());
            String jmbg_komercijalista = Controller.getInstance()
                    .getAddUgovorView().getJmbgKomercijalistaCb().getSelectionModel().getSelectedItem().toString();
            String tekst_ugovor = Controller.getInstance().getAddUgovorView().getTekstUgovoraTa().getText();

            Ugovor u = new Ugovor(id, id_dobavljac, id_apoteka, jmbg_komercijalista, pocetak_vazenja, kraj_vazenja, tekst_ugovor);

            Baza.connect();
            ArrayList<Ugovor> ugovori = Baza.getAllUgovor();
            Baza.disconnect();

            int count = 0;

            for (Ugovor ugovor : ugovori) {
                if (ugovor.getId() == id) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Uneti ID vec postoji");
                alert.showAndWait();
            } else {
                Baza.connect();
                Baza.addUgovor(u);
                Baza.disconnect();
                OsveziTabelu.osveziTabelu();
                Controller.getInstance().getSideStage().close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Komercijalista je uspesno ubacen u bazu");
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
