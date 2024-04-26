/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajUgovorAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Apoteka;
import Tabele.Dobavljac;
import Tabele.Komercijalista;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Filip
 */
public class AddUgovorView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label ugovorIdLbl = new Label("Ugovor ID:");
    private Label idDobavljacLbl = new Label("Dobavljac ID: ");
    private Label idApotekaLbl = new Label("Apoteka ID: ");
    private Label jmbgKomercijalistaLbl = new Label("Komercijalista jmbg: ");
    private Label pocetakVazenjaLbl = new Label("Pocetak vazenja: ");
    private Label krajVazenjaLbl = new Label("Kraj vazenja: ");
    private Label tekstUgovoraLbl = new Label("Tekst ugovora: ");

    private TextField ugovorIdFld = new TextField();
    private ComboBox idDobavljacCb = new ComboBox();
    private ComboBox idApotekaCb = new ComboBox();
    private ComboBox jmbgKomercijalistaCb = new ComboBox();
    private DatePicker pocetakVazenjaDp = new DatePicker();
    private DatePicker krajVazenjaDp = new DatePicker();
    private TextArea tekstUgovoraTa = new TextArea();

    private Button dodajBtn = new Button("Dodaj");

    public AddUgovorView() {

        tekstUgovoraTa.setMaxWidth(200);
        dodajBtn.setOnAction(new DodajUgovorAction());

        ArrayList<Dobavljac> dobavljaci = new ArrayList<>();
        ArrayList<Apoteka> apoteke = new ArrayList<>();
        ArrayList<Komercijalista> komercijaliste = new ArrayList<>();
        Baza.connect();
        dobavljaci = Baza.getAllDobavljac();
        apoteke = Baza.getAllApoteka();
        komercijaliste = Baza.getAllKomercijalista();
        Baza.disconnect();

        ObservableList<String> dobavljaciOl = FXCollections.observableArrayList();
        ObservableList<String> apotekeOl = FXCollections.observableArrayList();
        ObservableList<String> komercijalisteOl = FXCollections.observableArrayList();

        for (int i = 0; i < dobavljaci.size(); i++) {
            dobavljaciOl.add(String.valueOf(dobavljaci.get(i).getId()));
        }

        for (int i = 0; i < apoteke.size(); i++) {
            apotekeOl.add(String.valueOf(apoteke.get(i).getId()));
        }

        for (int i = 0; i < komercijaliste.size(); i++) {
            komercijalisteOl.add(String.valueOf(komercijaliste.get(i).getJmbg()));
        }

        idDobavljacCb.setItems(dobavljaciOl);
        idApotekaCb.setItems(apotekeOl);
        jmbgKomercijalistaCb.setItems(komercijalisteOl);
        idApotekaCb.getSelectionModel().selectFirst();
        idDobavljacCb.getSelectionModel().selectFirst();
        jmbgKomercijalistaCb.getSelectionModel().selectFirst();

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(10);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(ugovorIdLbl, 0, 1);
        add(ugovorIdFld, 1, 1);

        add(idDobavljacLbl, 0, 2);
        add(idDobavljacCb, 1, 2);

        add(idApotekaLbl, 0, 3);
        add(idApotekaCb, 1, 3);

        add(jmbgKomercijalistaLbl, 0, 4);
        add(jmbgKomercijalistaCb, 1, 4);

        add(pocetakVazenjaLbl, 0, 5);
        add(pocetakVazenjaDp, 1, 5);

        add(krajVazenjaLbl, 0, 6);
        add(krajVazenjaDp, 1, 6);

        add(tekstUgovoraLbl, 0, 7);
        add(tekstUgovoraTa, 1, 7);

        add(dodajBtn, 1, 8);

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

    public TextField getUgovorIdFld() {
        return ugovorIdFld;
    }

    public void setUgovorIdFld(TextField ugovorIdFld) {
        this.ugovorIdFld = ugovorIdFld;
    }

    public ComboBox getIdDobavljacCb() {
        return idDobavljacCb;
    }

    public void setIdDobavljacCb(ComboBox idDobavljacCb) {
        this.idDobavljacCb = idDobavljacCb;
    }

    public ComboBox getIdApotekaCb() {
        return idApotekaCb;
    }

    public void setIdApotekaCb(ComboBox idApotekaCb) {
        this.idApotekaCb = idApotekaCb;
    }

    public ComboBox getJmbgKomercijalistaCb() {
        return jmbgKomercijalistaCb;
    }

    public void setJmbgKomercijalistaCb(ComboBox jmbgKomercijalistaCb) {
        this.jmbgKomercijalistaCb = jmbgKomercijalistaCb;
    }

    public DatePicker getPocetakVazenjaDp() {
        return pocetakVazenjaDp;
    }

    public void setPocetakVazenjaDp(DatePicker pocetakVazenjaDp) {
        this.pocetakVazenjaDp = pocetakVazenjaDp;
    }

    public DatePicker getKrajVazenjaDp() {
        return krajVazenjaDp;
    }

    public void setKrajVazenjaDp(DatePicker krajVazenjaDp) {
        this.krajVazenjaDp = krajVazenjaDp;
    }

    public TextArea getTekstUgovoraTa() {
        return tekstUgovoraTa;
    }

    public void setTekstUgovoraTa(TextArea tekstUgovoraTa) {
        this.tekstUgovoraTa = tekstUgovoraTa;
    }

}
