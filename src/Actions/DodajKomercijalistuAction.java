/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Farmaceut;
import Tabele.Komercijalista;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class DodajKomercijalistuAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            String jmbg = Controller.getInstance().getAddKomercijalistaView().getJmbgKomercijalistaFld().getText();
            String imeKomercijalista = Controller.getInstance()
                    .getAddKomercijalistaView().getImeKomercijalistaFld().getText();
            String prezimeKomercijalista = Controller.getInstance()
                    .getAddKomercijalistaView().getPrezimeKomercijalistaFld().getText();
            String adresaKomercijalista = Controller.getInstance()
                    .getAddKomercijalistaView().getAdresaKomercijalistaFld().getText();
            String brojTelefona = Controller.getInstance()
                    .getAddKomercijalistaView().getBrTelefonaKomercijalistaFld().getText();

            Komercijalista k = new Komercijalista(jmbg, imeKomercijalista, prezimeKomercijalista, adresaKomercijalista, brojTelefona);

            int count = 0;

            Baza.connect();

            ArrayList<Komercijalista> komercijalisti = Baza.getAllKomercijalista();
            for (Komercijalista komercijalista : komercijalisti) {
                if (komercijalista.getJmbg().equals(jmbg)) {
                    count++;
                }
            }
            if (count > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Vec postoji komercijalista sa unetim ID");
                alert.showAndWait();
            } else {
                Baza.addKomercijalista(k);
                Controller.getInstance().getSideStage().close();
                OsveziTabelu.osveziTabelu();
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
