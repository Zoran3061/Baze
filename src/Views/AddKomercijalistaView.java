/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajKomercijalistuAction;
import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Milos PC
 */
public class AddKomercijalistaView extends GridPane {

    private ComboBox tabeleCB;

    private Label jmbgKomercijalistaLbl = new Label("Komercijalista jmbg:");
    private Label imeKomercijalistaLbl = new Label("Ime komercijaliste: ");
    private Label prezimeKomercijalistaLbl = new Label("Prezime komercijaliste: ");
    private Label adresaKomercijalistaLbl = new Label("Adresa komercijaliste: ");
    private Label brTelefonaKomercijalistaLbl = new Label("Broj telefona komercijaliste: ");

    private TextField jmbgKomercijalistaFld = new TextField();
    private TextField imeKomercijalistaFld = new TextField();
    private TextField prezimeKomercijalistaFld = new TextField();
    private TextField adresaKomercijalistaFld = new TextField();
    private TextField brTelefonaKomercijalistaFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddKomercijalistaView() {
        dodajBtn.setOnAction(new DodajKomercijalistuAction());

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(5);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(jmbgKomercijalistaLbl, 0, 1);
        add(jmbgKomercijalistaFld, 1, 1);

        add(imeKomercijalistaLbl, 0, 2);
        add(imeKomercijalistaFld, 1, 2);

        add(prezimeKomercijalistaLbl, 0, 3);
        add(prezimeKomercijalistaFld, 1, 3);

        add(adresaKomercijalistaLbl, 0, 4);
        add(adresaKomercijalistaFld, 1, 4);

        add(brTelefonaKomercijalistaLbl, 0, 5);
        add(brTelefonaKomercijalistaFld, 1, 5);

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

    public Label getJmbgKomercijalistaLbl() {
        return jmbgKomercijalistaLbl;
    }

    public void setJmbgKomercijalistaLbl(Label jmbgKomercijalistaLbl) {
        this.jmbgKomercijalistaLbl = jmbgKomercijalistaLbl;
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

    public TextField getJmbgKomercijalistaFld() {
        return jmbgKomercijalistaFld;
    }

    public void setJmbgKomercijalistaFld(TextField jmbgKomercijalistaFld) {
        this.jmbgKomercijalistaFld = jmbgKomercijalistaFld;
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

}
