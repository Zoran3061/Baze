/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajMaloprodajnuCenuAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Apoteka;
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
public class AddMaloprodajnaCenaView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label idApotekaLbl = new Label("Apoteka ID:");
    private Label sifraLekLbl = new Label("Sifra leka: ");
    private Label cenaLekLbl = new Label("Cena leka: ");

    private ComboBox idApotekaCb = new ComboBox();
    private ComboBox sifraLekCb = new ComboBox();
    private TextField cenaLekFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddMaloprodajnaCenaView() {
        ArrayList<Apoteka> apoteke = new ArrayList<>();
        ArrayList<Lek> lekovi = new ArrayList<>();
        Baza.connect();
        lekovi = Baza.getAllLek();
        apoteke = Baza.getAllApoteka();
        Baza.disconnect();

        ObservableList<String> apotekeOL = FXCollections.observableArrayList();
        ObservableList<String> sifraLekOL = FXCollections.observableArrayList();

        for (int i = 0; i < lekovi.size(); i++) {
            sifraLekOL.add(String.valueOf(lekovi.get(i).getSifra()));
        }

        for (int i = 0; i < apoteke.size(); i++) {
            apotekeOL.add(String.valueOf(apoteke.get(i).getId()));
        }

        sifraLekCb.setItems(sifraLekOL);
        idApotekaCb.setItems(apotekeOL);
        sifraLekCb.getSelectionModel().selectFirst();
        idApotekaCb.getSelectionModel().selectFirst();

        dodajBtn.setOnAction(new DodajMaloprodajnuCenuAction());

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(7);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(idApotekaLbl, 0, 1);
        add(idApotekaCb, 1, 1);

        add(sifraLekLbl, 0, 2);
        add(sifraLekCb, 1, 2);

        add(cenaLekLbl, 0, 3);
        add(cenaLekFld, 1, 3);

        add(dodajBtn, 1, 5);

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

    public ComboBox getIdApotekaCb() {
        return idApotekaCb;
    }

    public void setIdApotekaCb(ComboBox idApotekaCb) {
        this.idApotekaCb = idApotekaCb;
    }

    public ComboBox getSifraLekCb() {
        return sifraLekCb;
    }

    public void setSifraLekCb(ComboBox sifraLekCb) {
        this.sifraLekCb = sifraLekCb;
    }

    public TextField getCenaLekFld() {
        return cenaLekFld;
    }

    public void setCenaLekFld(TextField cenaLekFld) {
        this.cenaLekFld = cenaLekFld;
    }

}
