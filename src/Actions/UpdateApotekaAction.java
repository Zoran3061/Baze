/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Apoteka;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class UpdateApotekaAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Apoteka a1 = Controller.getInstance().getUpdateApotekaView().getA1();
        String imeApoteka = (String) Controller.getInstance().getUpdateApotekaView().getImeApotekaFld().getText();
        String adresaApoteka = (String) Controller.getInstance().getUpdateApotekaView().getAdresaApotekaFld().getText();
        String brTelefonApoteka = (String) Controller.getInstance().getUpdateApotekaView().getTelefonApotekaFld().getText();
        a1.setIme(imeApoteka);
        a1.setAdresa(adresaApoteka);
        a1.setBr_telefona(brTelefonApoteka);
        Baza.connect();
        Baza.updateApoteka(a1);
        Baza.disconnect();

        OsveziTabelu.osveziTabelu();
        Controller.getInstance().getSideStage().close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obavestenje");
        alert.setHeaderText(null);
        alert.setContentText("Apoteka je uspesno izmenjena");
        alert.showAndWait();
    }

}
