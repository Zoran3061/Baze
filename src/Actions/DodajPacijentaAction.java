/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Pacijent;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajPacijentaAction implements EventHandler<ActionEvent> {
    

    @Override
    public void handle(ActionEvent event) {
        try {
            String jmbg = Controller.getInstance().getAddPacijentView().getJmbgPacijentFld().getText();
            String jmbg_doktor = Controller.getInstance()
                    .getAddPacijentView().getJmbgDoktorCb().getSelectionModel().getSelectedItem().toString();
            String ime = Controller.getInstance()
                    .getAddPacijentView().getImeFld().getText();
            String adresa = Controller.getInstance()
                    .getAddPacijentView().getAdresaFld().getText();
            int starost_pacijenta = Integer.valueOf(Controller.getInstance()
                    .getAddPacijentView().getStarostFld().getText());

            Pacijent p = new Pacijent(jmbg, jmbg_doktor, ime, adresa, starost_pacijenta);

            int count = 0;

            Baza.connect();

            ArrayList<Pacijent> pacijenti = Baza.getAllPacijent();
            for (Pacijent pacijent : pacijenti) {
                if (pacijent.getJmbg().equals(jmbg)) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji pacijent sa unetim JMBG");
                alert.showAndWait();
            } else {
                Baza.addPacijent(p);
                OsveziTabelu.osveziTabelu();
                Controller.getInstance().getSideStage().close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Komercijalista je uspesno ubacen u bazu");
                alert.showAndWait();
            }
            Baza.disconnect();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nisu uneti ispravni podaci");
            alert.showAndWait();
        }
    }
}
