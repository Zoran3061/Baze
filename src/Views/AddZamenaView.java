/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajZamenuAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Lek;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Filip
 */
public class AddZamenaView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label idZamenaLbl = new Label("Zamena ID:");
    private Label sifraLekLbl = new Label("Sifra leka: ");
    private Label sifraZamenaLbl = new Label("Sifra zamene: ");

    private TextField idZamenaFld = new TextField();
    private ComboBox sifraLekCb = new ComboBox();
    private ComboBox sifraZamenaCb = new ComboBox();

    private Button dodajBtn = new Button("Dodaj");

    public AddZamenaView() {

        Baza.connect();
        ArrayList<Lek> lekovi = Baza.getAllLek();
        Baza.disconnect();

        ObservableList<String> lekoviOl = FXCollections.observableArrayList();

        for (int i = 0; i < lekovi.size(); i++) {
            lekoviOl.add(String.valueOf(lekovi.get(i).getSifra()));
        }

        sifraLekCb.setItems(lekoviOl);
        sifraZamenaCb.setItems(lekoviOl);
        sifraLekCb.getSelectionModel().selectFirst();
        sifraZamenaCb.getSelectionModel().selectFirst();

        dodajBtn.setOnAction(new DodajZamenuAction());

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(11);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(idZamenaLbl, 0, 1);
        add(idZamenaFld, 1, 1);

        add(sifraLekLbl, 0, 2);
        add(sifraLekCb, 1, 2);

        add(sifraZamenaLbl, 0, 3);
        add(sifraZamenaCb, 1, 3);

        add(dodajBtn, 1, 4);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public ComboBox getTabeleCB() {
        return tabeleCB;
    }

    public void setTabeleCB(ComboBox tabeleCB) {
        this.tabeleCB = tabeleCB;
    }

    public TextField getIdZamenaFld() {
        return idZamenaFld;
    }

    public void setIdZamenaFld(TextField idZamenaFld) {
        this.idZamenaFld = idZamenaFld;
    }

    public ComboBox getSifraLekCb() {
        return sifraLekCb;
    }

    public void setSifraLekCb(ComboBox sifraLekCb) {
        this.sifraLekCb = sifraLekCb;
    }

    public ComboBox getSifraZamenaCb() {
        return sifraZamenaCb;
    }

    public void setSifraZamenaCb(ComboBox sifraZamenaCb) {
        this.sifraZamenaCb = sifraZamenaCb;
    }

}
