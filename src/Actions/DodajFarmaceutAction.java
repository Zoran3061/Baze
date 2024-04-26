/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Farmaceut;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class DodajFarmaceutAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        try {
            String jmbg = Controller.getInstance().getAddFarmaceutView().getJmbgFarmaceutFld().getText();
            String imeFarmaceut = Controller.getInstance()
                    .getAddFarmaceutView().getImeFarmaceutFld().getText();
            String prezimeFarmaceut = Controller.getInstance()
                    .getAddFarmaceutView().getPrezimeFarmaceutFld().getText();
            String adresaFarmaceut = Controller.getInstance()
                    .getAddFarmaceutView().getAdresaFarmaceutFld().getText();
            String strucnaSprema = Controller.getInstance()
                    .getAddFarmaceutView().getStrucnaSpremaFamraceutFld().getText();

            Farmaceut f = new Farmaceut(jmbg, imeFarmaceut, prezimeFarmaceut, strucnaSprema, strucnaSprema);

            int count = 0;

            Baza.connect();

            ArrayList<Farmaceut> farmaceuti = Baza.getAllFarmaceut();
            for (Farmaceut farmaceut : farmaceuti) {
                if (farmaceut.getJmbg().equals(jmbg)) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji farmaceut sa unetim ID");
                alert.showAndWait();
            } else {
                Baza.addFarmaceut(f);
                Controller.getInstance().getSideStage().close();
                OsveziTabelu.osveziTabelu();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText(null);
                alert.setContentText("Farmaceut je uspesno ubacen u bazu");
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
