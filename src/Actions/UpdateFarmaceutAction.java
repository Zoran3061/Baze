/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Farmaceut;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class UpdateFarmaceutAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Farmaceut f1 = Controller.getInstance().getUpdateFarmaceutView().getF1();
        String imeFarmaceut = (String) Controller.getInstance().getUpdateFarmaceutView().getImeFarmaceutFld().getText();
        String prezimeFarmaceut = (String) Controller.getInstance().getUpdateFarmaceutView().getPrezimeFarmaceutFld().getText();
        String adresaFarmaceut = (String) Controller.getInstance().getUpdateFarmaceutView().getAdresaFarmaceutFld().getText();
        String strucnaSprema = (String) Controller.getInstance().getUpdateFarmaceutView().getStrucnaSpremaFamraceutFld().getText();
        f1.setIme(imeFarmaceut);
        f1.setPrezime(prezimeFarmaceut);
        f1.setAdresa(adresaFarmaceut);
        f1.setStrucnaSprema(strucnaSprema);
        Baza.connect();
        Baza.updateFarmaceut(f1);
        Baza.disconnect();

        OsveziTabelu.osveziTabelu();
        Controller.getInstance().getSideStage().close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obavestenje");
        alert.setHeaderText(null);
        alert.setContentText("Farmaceut je uspesno Izmenjen!");
        alert.showAndWait();
    }

}
