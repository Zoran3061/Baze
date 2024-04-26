/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajLekAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Dobavljac;
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
public class AddLekView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label idLekLbl = new Label("Lek ID:");
    private Label dobavljacLbl = new Label("Dobavljac: ");
    private Label imeLekLbl = new Label("Ime leka: ");

    private TextField idLekFld = new TextField();
    private ComboBox dobavljacCb = new ComboBox();
    private TextField imeLekFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddLekView() {
        ArrayList<Dobavljac> dobavljaci = new ArrayList<>();
        Baza.connect();
        dobavljaci = Baza.getAllDobavljac();
        Baza.disconnect();

        ObservableList<String> dobavljaciOL = FXCollections.observableArrayList();

        for (int i = 0; i < dobavljaci.size(); i++) {
            dobavljaciOL.add(String.valueOf(dobavljaci.get(i).getId()));
        }

        dobavljacCb.setItems(dobavljaciOL);
        dobavljacCb.getSelectionModel().selectFirst();

        dodajBtn.setOnAction(new DodajLekAction());

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(6);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(idLekLbl, 0, 1);
        add(idLekFld, 1, 1);

        add(dobavljacLbl, 0, 2);
        add(dobavljacCb, 1, 2);

        add(imeLekLbl, 0, 3);
        add(imeLekFld, 1, 3);

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

    public TextField getIdLekFld() {
        return idLekFld;
    }

    public void setIdLekFld(TextField idLekFld) {
        this.idLekFld = idLekFld;
    }

    public ComboBox getDobavljacCb() {
        return dobavljacCb;
    }

    public void setDobavljacCb(ComboBox dobavljacCb) {
        this.dobavljacCb = dobavljacCb;
    }

    public TextField getImeLekFld() {
        return imeLekFld;
    }

    public void setImeLekFld(TextField imeLekFld) {
        this.imeLekFld = imeLekFld;
    }

}
