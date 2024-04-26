/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Doktor;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class DodajDoktorAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        try {
            String jmbg = Controller.getInstance().getAddDoktorView().getJmbgDoktorFld().getText();
            String ime = Controller.getInstance()
                    .getAddDoktorView().getImeDoktorFld().getText();
            String adresa = Controller.getInstance()
                    .getAddDoktorView().getAdresaDoktorFld().getText();
            int starost = Integer.valueOf(Controller.getInstance().getAddDoktorView().getStarostDoktorFld().getText());

            Doktor d = new Doktor(jmbg, ime, adresa, starost);

            int count = 0;

            Baza.connect();

            ArrayList<Doktor> doktori = Baza.getAllDoktor();
            for (Doktor doktor : doktori) {
                if (doktor.getJmbg().equals(jmbg)) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji doktor sa unetim ID");
                alert.showAndWait();
            } else {
                Baza.addDoktor(d);
                Controller.getInstance().getSideStage().close();
                OsveziTabelu.osveziTabelu();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Doktor je uspesno ubacen u bazu");
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
