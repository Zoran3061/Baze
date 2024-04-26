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
public class UpdateUgovorAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            java.sql.Date pocetak_vazenja;
            java.sql.Date kraj_vazenja;

            if (Controller.getInstance().getUpdateUgovorView().getPocetakVazenjaDp().getValue() == null) {
                pocetak_vazenja = null;
            } else {
                LocalDate pocetakVazenjaDp = Controller.getInstance().getUpdateUgovorView().getPocetakVazenjaDp().getValue();
                java.util.Date utilDatum = java.util.Date.from(pocetakVazenjaDp.atStartOfDay(ZoneId.systemDefault()).toInstant());
                pocetak_vazenja = new java.sql.Date(utilDatum.getTime());
            }

            if (Controller.getInstance().getUpdateUgovorView().getKrajVazenjaDp().getValue() == null) {
                kraj_vazenja = null;
            } else {
                LocalDate krajVazenjaDp = Controller.getInstance().getUpdateUgovorView().getKrajVazenjaDp().getValue();
                java.util.Date utilDatum = java.util.Date.from(krajVazenjaDp.atStartOfDay(ZoneId.systemDefault()).toInstant());
                kraj_vazenja = new java.sql.Date(utilDatum.getTime());
            }

            int id_dobavljac = Integer.valueOf(Controller.getInstance()
                    .getUpdateUgovorView().getIdDobavljacCb().getSelectionModel().getSelectedItem().toString());
            int id_apoteka = Integer.valueOf(Controller.getInstance()
                    .getUpdateUgovorView().getIdApotekaCb().getSelectionModel().getSelectedItem().toString());
            String jmbg_komercijalista = Controller.getInstance()
                    .getUpdateUgovorView().getJmbgKomercijalistaCb().getSelectionModel().getSelectedItem().toString();
            String tekst_ugovor = Controller.getInstance().getUpdateUgovorView().getTekstUgovoraTa().getText();

            Ugovor u = Controller.getInstance().getUpdateUgovorView().getU();

            u.setId_apoteka(id_apoteka);
            u.setId_dobavljac(id_dobavljac);
            u.setJmbg_komercijalista(jmbg_komercijalista);
            u.setKraj_vazenja(kraj_vazenja);
            u.setPocetak_vazenja(pocetak_vazenja);
            u.setTekst_ugovor(tekst_ugovor);

            Baza.connect();
            Baza.updateUgovor(u);
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
