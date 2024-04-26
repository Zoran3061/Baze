/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajKomercijalistuAction;
import Actions.UpdateKomercijalistaAction;
import Controller.Controller;
import Tabele.Komercijalista;
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
public class UpdateKomercijalistaView extends GridPane {

    private Label imeKomercijalistaLbl = new Label("Ime komercijaliste: ");
    private Label prezimeKomercijalistaLbl = new Label("Prezime komercijaliste: ");
    private Label adresaKomercijalistaLbl = new Label("Adresa komercijaliste: ");
    private Label brTelefonaKomercijalistaLbl = new Label("Broj telefona komercijaliste: ");

    private TextField imeKomercijalistaFld = new TextField();
    private TextField prezimeKomercijalistaFld = new TextField();
    private TextField adresaKomercijalistaFld = new TextField();
    private TextField brTelefonaKomercijalistaFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    private Komercijalista k;

    public UpdateKomercijalistaView() {
        k = (Komercijalista) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();

        imeKomercijalistaFld.setText(k.getIme());
        prezimeKomercijalistaFld.setText(k.getPrezime());
        adresaKomercijalistaFld.setText(k.getAdresa());
        brTelefonaKomercijalistaFld.setText(k.getBr_telefona());

        dodajBtn.setOnAction(new UpdateKomercijalistaAction());

        add(imeKomercijalistaLbl, 0, 0);
        add(imeKomercijalistaFld, 1, 0);

        add(prezimeKomercijalistaLbl, 0, 1);
        add(prezimeKomercijalistaFld, 1, 1);

        add(adresaKomercijalistaLbl, 0, 2);
        add(adresaKomercijalistaFld, 1, 2);

        add(brTelefonaKomercijalistaLbl, 0, 3);
        add(brTelefonaKomercijalistaFld, 1, 3);

        add(dodajBtn, 1, 4);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public Label getImeKomercijalistaLbl() {
        return imeKomercijalistaLbl;
    }

    public void setImeKomercijalistaLbl(Label imeKomercijalistaLbl) {
        this.imeKomercijalistaLbl = imeKomercijalistaLbl;
    }

    public Label getPrezimeKomercijalistaLbl() {
        return prezimeKomercijalistaLbl;
    }

    public void setPrezimeKomercijalistaLbl(Label prezimeKomercijalistaLbl) {
        this.prezimeKomercijalistaLbl = prezimeKomercijalistaLbl;
    }

    public Label getAdresaKomercijalistaLbl() {
        return adresaKomercijalistaLbl;
    }

    public void setAdresaKomercijalistaLbl(Label adresaKomercijalistaLbl) {
        this.adresaKomercijalistaLbl = adresaKomercijalistaLbl;
    }

    public Label getBrTelefonaKomercijalistaLbl() {
        return brTelefonaKomercijalistaLbl;
    }

    public void setBrTelefonaKomercijalistaLbl(Label brTelefonaKomercijalistaLbl) {
        this.brTelefonaKomercijalistaLbl = brTelefonaKomercijalistaLbl;
    }

    public TextField getImeKomercijalistaFld() {
        return imeKomercijalistaFld;
    }

    public void setImeKomercijalistaFld(TextField imeKomercijalistaFld) {
        this.imeKomercijalistaFld = imeKomercijalistaFld;
    }

    public TextField getPrezimeKomercijalistaFld() {
        return prezimeKomercijalistaFld;
    }

    public void setPrezimeKomercijalistaFld(TextField prezimeKomercijalistaFld) {
        this.prezimeKomercijalistaFld = prezimeKomercijalistaFld;
    }

    public TextField getAdresaKomercijalistaFld() {
        return adresaKomercijalistaFld;
    }

    public void setAdresaKomercijalistaFld(TextField adresaKomercijalistaFld) {
        this.adresaKomercijalistaFld = adresaKomercijalistaFld;
    }

    public TextField getBrTelefonaKomercijalistaFld() {
        return brTelefonaKomercijalistaFld;
    }

    public void setBrTelefonaKomercijalistaFld(TextField brTelefonaKomercijalistaFld) {
        this.brTelefonaKomercijalistaFld = brTelefonaKomercijalistaFld;
    }

    public Button getDodajBtn() {
        return dodajBtn;
    }

    public void setDodajBtn(Button dodajBtn) {
        this.dodajBtn = dodajBtn;
    }

    public Komercijalista getK() {
        return k;
    }

    public void setK(Komercijalista k) {
        this.k = k;
    }

}
