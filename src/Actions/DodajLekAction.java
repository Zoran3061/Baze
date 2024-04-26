/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Angazovanje;
import Tabele.Lek;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajLekAction implements EventHandler<ActionEvent> {

    public DodajLekAction() {
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            int sifra_lek = Integer.valueOf(Controller.getInstance()
                    .getAddLekView().getIdLekFld().getText());
            int id_dobavljac = Integer.valueOf(Controller.getInstance()
                    .getAddLekView().getDobavljacCb().getSelectionModel().getSelectedItem().toString());
            String ime_lek = Controller.getInstance()
                    .getAddLekView().getImeLekFld().getText();

            Lek l = new Lek(sifra_lek, id_dobavljac, ime_lek);

            Baza.connect();
            ArrayList<Lek> lekovi = Baza.getAllLek();
            Baza.disconnect();

            int count = 0;
            for (Lek lek : lekovi) {
                if (l.getSifra() == lek.getSifra()) {
                    count++;
                }
            }

            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji lek sa unetom sifrom");
                OsveziTabelu.osveziTabelu();
                alert.showAndWait();
            } else {
                Baza.connect();
                Baza.addLek(l);
                Baza.disconnect();
                OsveziTabelu.osveziTabelu();
                Controller.getInstance().getSideStage().close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Lek je uspesno ubacen u bazu");
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
