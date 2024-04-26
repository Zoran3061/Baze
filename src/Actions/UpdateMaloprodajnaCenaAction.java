/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Maloprodajna_cena;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Alek97
 */
public class UpdateMaloprodajnaCenaAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Maloprodajna_cena mc = Controller.getInstance().getUpdateMaloprodajnaCenaView().getMc();

            int apotekaId = Integer.valueOf(Controller.getInstance().getUpdateMaloprodajnaCenaView().getIdApotekaCb().getSelectionModel().getSelectedItem().toString());
            int sifraLeka = Integer.valueOf(Controller.getInstance().getUpdateMaloprodajnaCenaView().getSifraLekCb().getSelectionModel().getSelectedItem().toString());
            int cenaLeka = Integer.valueOf(Controller.getInstance().getUpdateMaloprodajnaCenaView().getCenaLekFld().getText());

            mc.setApoteka_id(apotekaId);
            mc.setSifra_lek(sifraLeka);
            mc.setCena_leka(cenaLeka);

            Baza.connect();
            Baza.updateMaloprodajnaCena(mc);
            Baza.disconnect();

            OsveziTabelu.osveziTabelu();
            Controller.getInstance().getSideStage().close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText(null);
            alert.setContentText("Uspesno promenjeno");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Cena leka mora biti broj");
            alert.showAndWait();
        }
    }

}
