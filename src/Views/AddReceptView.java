/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajReceptAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Doktor;
import Tabele.Lek;
import Tabele.Pacijent;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Filip
 */
public class AddReceptView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label jmbgPacijentLbl = new Label("Pacijent jmbg:");
    private Label sifraLekLbl = new Label("Sifra leka: ");
    private Label jmbgDoktorLbl = new Label("Sifra doktora: ");
    private Label datumLb = new Label("Datum: ");
    private Label kolicinaLekovaLbl = new Label("Kolicina lekova: ");

    private ComboBox jmbgPacijentCb = new ComboBox();
    private ComboBox sifraLekCb = new ComboBox();
    private ComboBox jmbgDoktorCb = new ComboBox();
    private DatePicker datumDp = new DatePicker();
    private TextField kolicinaLekovaFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddReceptView() {
        dodajBtn.setOnAction(new DodajReceptAction());

        ArrayList<Doktor> doktori = new ArrayList<>();
        ArrayList<Lek> lekovi = new ArrayList<>();
        ArrayList<Pacijent> pacijenti = new ArrayList<>();
        Baza.connect();
        doktori = Baza.getAllDoktor();
        lekovi = Baza.getAllLek();
        pacijenti = Baza.getAllPacijent();
        Baza.disconnect();

        ObservableList<String> doktoriOl = FXCollections.observableArrayList();
        ObservableList<String> lekoviOl = FXCollections.observableArrayList();
        ObservableList<String> pacijentiOl = FXCollections.observableArrayList();

        for (int i = 0; i < doktori.size(); i++) {
            doktoriOl.add(String.valueOf(doktori.get(i).getJmbg()));
        }

        for (int i = 0; i < lekovi.size(); i++) {
            lekoviOl.add(String.valueOf(lekovi.get(i).getSifra()));
        }

        for (int i = 0; i < pacijenti.size(); i++) {
            pacijentiOl.add(String.valueOf(pacijenti.get(i).getJmbg()));
        }

        jmbgDoktorCb.setItems(doktoriOl);
        sifraLekCb.setItems(lekoviOl);
        jmbgPacijentCb.setItems(pacijentiOl);
        jmbgDoktorCb.getSelectionModel().selectFirst();
        sifraLekCb.getSelectionModel().selectFirst();
        jmbgPacijentCb.getSelectionModel().selectFirst();

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(9);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(jmbgPacijentLbl, 0, 1);
        add(jmbgPacijentCb, 1, 1);

        add(sifraLekLbl, 0, 2);
        add(sifraLekCb, 1, 2);

        add(jmbgDoktorLbl, 0, 3);
        add(jmbgDoktorCb, 1, 3);

        add(datumLb, 0, 4);
        add(datumDp, 1, 4);

        add(kolicinaLekovaLbl, 0, 5);
        add(kolicinaLekovaFld, 1, 5);

        add(dodajBtn, 1, 6);

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

    public ComboBox getJmbgPacijentCb() {
        return jmbgPacijentCb;
    }

    public void setJmbgPacijentCb(ComboBox jmbgPacijentCb) {
        this.jmbgPacijentCb = jmbgPacijentCb;
    }

    public ComboBox getSifraLekCb() {
        return sifraLekCb;
    }

    public void setSifraLekCb(ComboBox sifraLekCb) {
        this.sifraLekCb = sifraLekCb;
    }

    public ComboBox getJmbgDoktorCb() {
        return jmbgDoktorCb;
    }

    public void setJmbgDoktorCb(ComboBox jmbgDoktorCb) {
        this.jmbgDoktorCb = jmbgDoktorCb;
    }

    public DatePicker getDatumDp() {
        return datumDp;
    }

    public void setDatumDp(DatePicker datumDp) {
        this.datumDp = datumDp;
    }

    public TextField getKolicinaLekovaFld() {
        return kolicinaLekovaFld;
    }

    public void setKolicinaLekovaFld(TextField kolicinaLekovaFld) {
        this.kolicinaLekovaFld = kolicinaLekovaFld;
    }

}
