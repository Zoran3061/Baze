/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Baza.Baza;
import Controller.Controller;
import Tabele.Angazovanje;
import Tabele.Apoteka;
import Tabele.Dobavljac;
import Tabele.Doktor;
import Tabele.Farmaceut;
import Tabele.Komercijalista;
import Tabele.Lek;
import Tabele.Maloprodajna_cena;
import Tabele.Pacijent;
import Tabele.Recept;
import Tabele.Ugovor;
import Tabele.Zamena;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Filip
 */
public class ObrisiAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        if (Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Izaberite objekat za brisanje");
            alert.showAndWait();
        } else {
            int tabela = Controller.getInstance().getPocetniEkranView().getPocetniEkranTabeleCb().getSelectionModel().getSelectedIndex();
            switch (tabela) {
                case 0: {
                    Baza.connect();
                    Baza.delete((Angazovanje) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 1: {
                    Baza.connect();
                    Baza.delete((Apoteka) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 2: {
                    Baza.connect();
                    Baza.delete((Dobavljac) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 3: {
                    Baza.connect();
                    Baza.delete((Doktor) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 4: {
                    Baza.connect();
                    Baza.delete((Farmaceut) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 5: {
                    Baza.connect();
                    Baza.delete((Komercijalista) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 6: {
                    Baza.connect();
                    Baza.delete((Lek) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 7: {
                    Baza.connect();
                    Baza.delete((Maloprodajna_cena) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 8: {
                    Baza.connect();
                    Baza.delete((Pacijent) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 9: {
                    Baza.connect();
                    Baza.delete((Recept) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 10: {
                    Baza.connect();
                    Baza.delete((Ugovor) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
                case 11: {
                    Baza.connect();
                    Baza.delete((Zamena) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem());
                    Baza.disconnect();
                    break;
                }
            }
            OsveziTabelu.osveziTabelu();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText(null);
            alert.setContentText("Uspesno obrisano");
            alert.showAndWait();
        }
    }
}
