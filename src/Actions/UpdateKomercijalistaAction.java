/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Komercijalista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class UpdateKomercijalistaAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Komercijalista k = Controller.getInstance().getUpdateKomercijalistaView().getK();
        String ime = Controller.getInstance().getUpdateKomercijalistaView().getImeKomercijalistaFld().getText();
        String prezime = Controller.getInstance().getUpdateKomercijalistaView().getPrezimeKomercijalistaFld().getText();
        String adresa = Controller.getInstance().getUpdateKomercijalistaView().getAdresaKomercijalistaFld().getText();
        String telefon = Controller.getInstance().getUpdateKomercijalistaView().getBrTelefonaKomercijalistaFld().getText();

        k.setIme(ime);
        k.setPrezime(prezime);
        k.setAdresa(adresa);
        k.setBr_telefona(telefon);

        Baza.connect();
        Baza.updateKomercijalista(k);
        Baza.disconnect();

        OsveziTabelu.osveziTabelu();
        Controller.getInstance().getSideStage().close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obavestenje");
        alert.setHeaderText(null);
        alert.setContentText("Uspesno promenjeno");
        alert.showAndWait();

    }

}
