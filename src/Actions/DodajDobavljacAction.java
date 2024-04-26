/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Dobavljac;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class DodajDobavljacAction implements EventHandler<ActionEvent> {

    /*  private int id;
    private String ime;
    private String br_telefona;
     */
    @Override
    public void handle(ActionEvent event) {
        try {
            int id = Integer.valueOf(Controller.getInstance()
                    .getAddDobavljacView().getIdDobavljacFld().getText());
            String ime = Controller.getInstance()
                    .getAddDobavljacView().getImeDobavljacFLd().getText();
            String br_telefona = Controller.getInstance()
                    .getAddDobavljacView().getTelefonDobavljacFld().getText();

            Dobavljac d = new Dobavljac(id, ime, br_telefona);

            int count = 0;

            Baza.connect();

            ArrayList<Dobavljac> dobavljaci = Baza.getAllDobavljac();
            for (Dobavljac dobavljac : dobavljaci) {
                if (dobavljac.getId() == id) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji dobavljac sa unetim ID");
                alert.showAndWait();
            } else {
                Baza.addDobavljac(d);
                Controller.getInstance().getSideStage().close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Dobavljac je uspesno ubacen u bazu");
                OsveziTabelu.osveziTabelu();
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
