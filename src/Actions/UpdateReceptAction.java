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
public class UpdateReceptAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Recept r = Controller.getInstance().getUpdateReceptView().getR();

            String jmbg_pacijent = Controller.getInstance()
                    .getUpdateReceptView().getJmbgPacijentCb().getSelectionModel().getSelectedItem().toString();
            int sifra_lek = Integer.valueOf(Controller.getInstance()
                    .getUpdateReceptView().getSifraLekCb().getSelectionModel().getSelectedItem().toString());
            String jmbg_doktor = Controller.getInstance()
                    .getUpdateReceptView().getJmbgDoktorCb().getSelectionModel().getSelectedItem().toString();
            java.util.Date utilDatum
                    = java.util.Date.from(
                            Controller.getInstance().getUpdateReceptView().getDatumDp()
                                    .getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(utilDatum.getTime());
            int kolicina_lekova = Integer.valueOf(Controller.getInstance()
                    .getUpdateReceptView().getKolicinaLekovaFld().getText());

            r.setJmbg_doktor(jmbg_doktor);
            r.setJmbg_pacijent(jmbg_pacijent);
            r.setSifra_lek(sifra_lek);
            r.setDatum(sqlDate);
            r.setKolicina_lekova(kolicina_lekova);

            Baza.connect();
            Baza.updateRecept(r);
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
            alert.setContentText("Kolicina lekova mora biti ceo broj");
            alert.showAndWait();
        }
    }
}
