/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Apoteka;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class DodajApotekuAction implements EventHandler<ActionEvent> {

    public DodajApotekuAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            int apoteka_id = Integer.valueOf(Controller.getInstance()
                    .getAddApotekaView().getIdApotekaFld().getText());
            String imeApoteka = Controller.getInstance()
                    .getAddApotekaView().getImeApotekaFld().getText();
            String adresaApoteka = Controller.getInstance()
                    .getAddApotekaView().getAdresaApotekaFld().getText();
            String telefonApoteka = Controller.getInstance()
                    .getAddApotekaView().getTelefonApotekaFld().getText();

            Apoteka a = new Apoteka(apoteka_id, imeApoteka, adresaApoteka, telefonApoteka);

            int count = 0;

            Baza.connect();

            ArrayList<Apoteka> apoteke = Baza.getAllApoteka();
            for (Apoteka apoteka : apoteke) {
                if (apoteka.getId() == apoteka_id) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji apoteka sa unetim ID");
                alert.showAndWait();
            } else {
                Baza.addApoteka(a);
                Controller.getInstance().getSideStage().close();
                OsveziTabelu.osveziTabelu();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Apoteka je uspesno ubacena u bazu");
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
