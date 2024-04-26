package Actions;

import Controller.Controller;
import Tabele.Angazovanje;
import Baza.Baza;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Filip
 */
public class DodajAngazovanjeAction implements EventHandler<ActionEvent> {

    public DodajAngazovanjeAction() {
    
        
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            int apoteka_id = Integer.valueOf(Controller.getInstance()
                    .getAddAngazovanjeView().getApotekaIdCb().getSelectionModel().getSelectedItem().toString());
            String jmbg_farmaceut = Controller.getInstance()
                    .getAddAngazovanjeView().getJmbgFarmaceutCb().getSelectionModel().getSelectedItem().toString();
            int broj_meseci = Integer.valueOf(Controller.getInstance()
                    .getAddAngazovanjeView().getBrojMeseciFld().getText());
            int broj_dana = Integer.valueOf(Controller.getInstance()
                    .getAddAngazovanjeView().getBrojDanaFld().getText());

            Angazovanje a = new Angazovanje(0, apoteka_id, jmbg_farmaceut, broj_meseci, broj_dana);

            Baza.connect();
            Baza.addAngazovanje(a);
            Baza.disconnect();
            Controller.getInstance().getSideStage().close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText(null);
            alert.setContentText("Angazovanje je uspesno ubaceno u bazu");
            alert.showAndWait();
            
            OsveziTabelu.osveziTabelu();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nisu uneti ispravni podaci");

            alert.showAndWait();
        }
    }

}
