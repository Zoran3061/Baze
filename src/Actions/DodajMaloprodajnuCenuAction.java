/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Lek;
import Tabele.Maloprodajna_cena;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajMaloprodajnuCenuAction implements EventHandler<ActionEvent> {

    public DodajMaloprodajnuCenuAction() {
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            int id_apoteka = Integer.valueOf(Controller.getInstance()
                    .getAddMaloprodajnaCenaView().getIdApotekaCb().getSelectionModel().getSelectedItem().toString());
            int sifra_lek = Integer.valueOf(Controller.getInstance()
                    .getAddMaloprodajnaCenaView().getSifraLekCb().getSelectionModel().getSelectedItem().toString());
            int cena_lek = Integer.valueOf(Controller.getInstance()
                    .getAddMaloprodajnaCenaView().getCenaLekFld().getText());

            Maloprodajna_cena mCena = new Maloprodajna_cena(0, id_apoteka, sifra_lek, cena_lek);

            Baza.connect();
            ArrayList<Maloprodajna_cena> sveCene = Baza.getAllMaloprodajnaCena();
            Baza.disconnect();

            int count = 0;
            for (Maloprodajna_cena cena : sveCene) {
                if ((mCena.getApoteka_id() == cena.getApoteka_id()) && (mCena.getSifra_lek() == cena.getSifra_lek())) {
                    count++;
                }
            }

            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Cena za uneti lek i unetu apoteku vec postoji.");
                alert.showAndWait();
            } else {
                Baza.connect();
                Baza.addMaloprodajnaCena(mCena);
                Baza.disconnect();
                Controller.getInstance().getSideStage().close();
                OsveziTabelu.osveziTabelu();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Maloprodajna cena je uspesno ubacena u bazu");
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
