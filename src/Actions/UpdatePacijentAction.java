/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Pacijent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class UpdatePacijentAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Pacijent p = Controller.getInstance().getUpdatePacijentView().getP1();
            String jmbgDoktor;
            jmbgDoktor = (Controller.getInstance().getUpdatePacijentView().getJmbgDoktorCb().getSelectionModel().getSelectedItem().toString());
            String imePacijent = (String) Controller.getInstance().getUpdatePacijentView().getImeFld().getText();
            String adresaPacijent = (String) Controller.getInstance().getUpdatePacijentView().getAdresaFld().getText();
            int starost = Integer.valueOf(Controller.getInstance().getUpdatePacijentView().getStarostFld().getText());

            p.setJmbg_doktor(jmbgDoktor);
            p.setIme(imePacijent);
            p.setAdresa(adresaPacijent);
            p.setStarost_pacijent(starost);

            Baza.connect();
            Baza.updatePacijent(p);
            Baza.disconnect();

            OsveziTabelu.osveziTabelu();
            Controller.getInstance().getSideStage().close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText(null);
            alert.setContentText("Pacijent je uspesno Izmenjen!");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Godine moraju biti ceo broj");
            alert.showAndWait();
        }
    }
}
