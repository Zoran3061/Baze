/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Doktor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class UpdateDoktorAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Doktor d = Controller.getInstance().getUpdateDoktorView().getD();

            String ime = Controller.getInstance().getUpdateDoktorView().getImeDoktorFld().getText();
            String adresa = Controller.getInstance().getUpdateDoktorView().getAdresaDoktorFld().getText();
            int starost = Integer.valueOf(Controller.getInstance().getUpdateDoktorView().getStarostDoktorFld().getText());

            d.setIme(ime);
            d.setAdresa(adresa);
            d.setStarost(starost);

            Baza.connect();
            Baza.updateDoktor(d);
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
            alert.setContentText("Starost mora biti ceo broj");
            alert.showAndWait();
        }
    }

}
