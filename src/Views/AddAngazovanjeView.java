package Views;

import Actions.DodajAction;
import Controller.Controller;
import Actions.DodajAngazovanjeAction;
import Baza.Baza;
import Tabele.Apoteka;
import Tabele.Farmaceut;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Filip
 */
public class AddAngazovanjeView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label apotekaIdLbl = new Label("Apoteka ID:");
    private Label jmbgFarmaceutLbl = new Label("JMBG Farmaceuta: ");
    private Label brojMeseciLbl = new Label("Broj meseci: ");
    private Label brojDanaLbl = new Label("Broj dana: ");

    private ComboBox apotekaIdCb = new ComboBox();
    private ComboBox jmbgFarmaceutCb = new ComboBox();
    private TextField brojMeseciFld = new TextField();
    private TextField brojDanaFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddAngazovanjeView() {

        Baza.connect();
        ArrayList<Apoteka> apoteke = Baza.getAllApoteka();
        ArrayList<Farmaceut> farmaceuti = Baza.getAllFarmaceut();
        Baza.disconnect();

        ObservableList<String> apotekeOL = FXCollections.observableArrayList();
        ObservableList<String> farmaceutiOL = FXCollections.observableArrayList();

        for (int i = 0; i < apoteke.size(); i++) {
            apotekeOL.add(String.valueOf(apoteke.get(i).getId()));
        }

        for (int i = 0; i < farmaceuti.size(); i++) {
            farmaceutiOL.add(farmaceuti.get(i).getJmbg());
        }

        apotekaIdCb.setItems(apotekeOL);
        apotekaIdCb.getSelectionModel().select(0);
        jmbgFarmaceutCb.setItems(farmaceutiOL);
        jmbgFarmaceutCb.getSelectionModel().select(0);

        dodajBtn.setOnAction(new DodajAngazovanjeAction());

        Controller.getInstance().setTabeleCb(tabeleCB);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(apotekaIdLbl, 0, 1);
        add(apotekaIdCb, 1, 1);

        add(jmbgFarmaceutLbl, 0, 2);
        add(jmbgFarmaceutCb, 1, 2);

        add(brojMeseciLbl, 0, 3);
        add(brojMeseciFld, 1, 3);

        add(brojDanaLbl, 0, 4);
        add(brojDanaFld, 1, 4);

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

    public ComboBox getApotekaIdCb() {
        return apotekaIdCb;
    }

    public void setApotekaIdCb(ComboBox apotekaIdCb) {
        this.apotekaIdCb = apotekaIdCb;
    }

    public ComboBox getJmbgFarmaceutCb() {
        return jmbgFarmaceutCb;
    }

    public void setJmbgFarmaceutCb(ComboBox jmbgFarmaceutCb) {
        this.jmbgFarmaceutCb = jmbgFarmaceutCb;
    }

    public TextField getBrojMeseciFld() {
        return brojMeseciFld;
    }

    public void setBrojMeseciFld(TextField brojMeseciFld) {
        this.brojMeseciFld = brojMeseciFld;
    }

    public TextField getBrojDanaFld() {
        return brojDanaFld;
    }

    public void setBrojDanaFld(TextField brojDanaFld) {
        this.brojDanaFld = brojDanaFld;
    }

}
