/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.UpdateFarmaceutAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Farmaceut;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Milos PC
 */
public class UpdateFarmaceutView extends GridPane {

    private Label jmbgFarmaceutLbl = new Label("Farmaceut jmbg:");
    private Label imeFarmaceutLbl = new Label("Ime farmaceuta: ");
    private Label prezimeFarmaceutLbl = new Label("Prezime farmaceuta: ");

    private Label adresaFarmaceutLbl = new Label("Adresa farmaceuta : ");
    private Label strucnaSpremaFarmaceutLbl = new Label("Strucna sprema farmaceuta : ");

    private TextField jmbgFarmaceutFld = new TextField();
    private TextField imeFarmaceutFld = new TextField();
    private TextField prezimeFarmaceutFld = new TextField();
    private TextField adresaFarmaceutFld = new TextField();
    private TextField strucnaSpremaFamraceutFld = new TextField();
    private Farmaceut f1;

    private Button dodajBtn = new Button("Izmeni");

    public UpdateFarmaceutView() {
        f1 = (Farmaceut) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();

        setF1(f1);
        Baza.connect();
        Baza.disconnect();

        imeFarmaceutFld.setText(f1.getIme());
        prezimeFarmaceutFld.setText(f1.getPrezime());
        adresaFarmaceutFld.setText(f1.getAdresa());
        strucnaSpremaFamraceutFld.setText(f1.getStrucnaSprema());

        dodajBtn.setOnAction(new UpdateFarmaceutAction());

        add(imeFarmaceutLbl, 0, 0);
        add(imeFarmaceutFld, 1, 0);

        add(prezimeFarmaceutLbl, 0, 1);
        add(prezimeFarmaceutFld, 1, 1);

        add(adresaFarmaceutLbl, 0, 2);
        add(adresaFarmaceutFld, 1, 2);

        add(strucnaSpremaFarmaceutLbl, 0, 3);
        add(strucnaSpremaFamraceutFld, 1, 3);

        add(dodajBtn, 1, 4);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public Label getJmbgFarmaceutLbl() {
        return jmbgFarmaceutLbl;
    }

    public void setJmbgFarmaceutLbl(Label jmbgFarmaceutLbl) {
        this.jmbgFarmaceutLbl = jmbgFarmaceutLbl;
    }

    public Label getImeFarmaceutLbl() {
        return imeFarmaceutLbl;
    }

    public void setImeFarmaceutLbl(Label imeFarmaceutLbl) {
        this.imeFarmaceutLbl = imeFarmaceutLbl;
    }

    public Label getAdresaFarmaceutLbl() {
        return adresaFarmaceutLbl;
    }

    public void setAdresaFarmaceutLbl(Label adresaFarmaceutLbl) {
        this.adresaFarmaceutLbl = adresaFarmaceutLbl;
    }

    public Label getStrucnaSpremaFarmaceutLbl() {
        return strucnaSpremaFarmaceutLbl;
    }

    public void setStrucnaSpremaFarmaceutLbl(Label strucnaSpremaFarmaceutLbl) {
        this.strucnaSpremaFarmaceutLbl = strucnaSpremaFarmaceutLbl;
    }

    public TextField getJmbgFarmaceutFld() {
        return jmbgFarmaceutFld;
    }

    public void setJmbgFarmaceutFld(TextField jmbgFarmaceutFld) {
        this.jmbgFarmaceutFld = jmbgFarmaceutFld;
    }

    public TextField getImeFarmaceutFld() {
        return imeFarmaceutFld;
    }

    public void setImeFarmaceutFld(TextField imeFarmaceutFld) {
        this.imeFarmaceutFld = imeFarmaceutFld;
    }

    public TextField getAdresaFarmaceutFld() {
        return adresaFarmaceutFld;
    }

    public void setAdresaFarmaceutFld(TextField adresaFarmaceutFld) {
        this.adresaFarmaceutFld = adresaFarmaceutFld;
    }

    public TextField getStrucnaSpremaFamraceutFld() {
        return strucnaSpremaFamraceutFld;
    }

    public void setStrucnaSpremaFamraceutFld(TextField strucnaSpremaFamraceutFld) {
        this.strucnaSpremaFamraceutFld = strucnaSpremaFamraceutFld;
    }

    public Button getDodajBtn() {
        return dodajBtn;
    }

    public void setDodajBtn(Button dodajBtn) {
        this.dodajBtn = dodajBtn;
    }

    public Label getPrezimeFarmaceutLbl() {
        return prezimeFarmaceutLbl;
    }

    public void setPrezimeFarmaceutLbl(Label prezimeFarmaceutLbl) {
        this.prezimeFarmaceutLbl = prezimeFarmaceutLbl;
    }

    public TextField getPrezimeFarmaceutFld() {
        return prezimeFarmaceutFld;
    }

    public void setPrezimeFarmaceutFld(TextField prezimeFarmaceutFld) {
        this.prezimeFarmaceutFld = prezimeFarmaceutFld;
    }

    public Farmaceut getF1() {
        return f1;
    }

    public void setF1(Farmaceut f1) {
        this.f1 = f1;
    }

}
