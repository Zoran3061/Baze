/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.UpdateApotekaAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Apoteka;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Milos PC
 */
public class UpdateApotekaView extends GridPane {

    private Label imeApotekaLbl = new Label("Ime apoteke: ");
    private Label adresaApotekaLbl = new Label("Adresa apoteke: ");
    private Label telefonApotekaLbl = new Label("Broj telefona: ");

    private TextField imeApotekaFld = new TextField();
    private TextField adresaApotekaFld = new TextField();
    private TextField telefonApotekaFld = new TextField();
    private Apoteka a1;

    private Button dodajBtn = new Button("Izmeni");

    public UpdateApotekaView() {

        Apoteka a1;
        a1 = (Apoteka) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();
        setA1(a1);
        Baza.connect();
        Baza.disconnect();

        imeApotekaFld.setText(a1.getIme());
        adresaApotekaFld.setText(a1.getAdresa());
        telefonApotekaFld.setText(a1.getBr_telefona());

        dodajBtn.setOnAction(new UpdateApotekaAction());

        add(imeApotekaLbl, 0, 0);
        add(imeApotekaFld, 1, 0);

        add(adresaApotekaLbl, 0, 1);
        add(adresaApotekaFld, 1, 1);

        add(telefonApotekaLbl, 0, 2);
        add(telefonApotekaFld, 1, 2);

        add(dodajBtn, 1, 3);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public TextField getImeApotekaFld() {
        return imeApotekaFld;
    }

    public void setImeApotekaFld(TextField imeApotekaFld) {
        this.imeApotekaFld = imeApotekaFld;
    }

    public TextField getAdresaApotekaFld() {
        return adresaApotekaFld;
    }

    public void setAdresaApotekaFld(TextField adresaApotekaFld) {
        this.adresaApotekaFld = adresaApotekaFld;
    }

    public TextField getTelefonApotekaFld() {
        return telefonApotekaFld;
    }

    public void setTelefonApotekaFld(TextField telefonApotekaFld) {
        this.telefonApotekaFld = telefonApotekaFld;
    }

    public Apoteka getA1() {
        return a1;
    }

    public void setA1(Apoteka a1) {
        this.a1 = a1;
    }

}
