/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajDoktorAction;
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
public class AddDoktorView extends GridPane {

    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label jmbgDoktorLbl = new Label("Doktor jmbg:");
    private Label imeDoktorLbl = new Label("Ime doktora: ");
    private Label adresaDoktorLbl = new Label("Adresa doktora: ");
    private Label starostDoktorLbl = new Label("Starost doktora: ");

    private TextField jmbgDoktorFld = new TextField();
    private TextField imeDoktorFld = new TextField();
    private TextField adresaDoktorFld = new TextField();
    private TextField starostDoktorFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddDoktorView() {
        dodajBtn.setOnAction(new DodajDoktorAction());

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(3);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(jmbgDoktorLbl, 0, 1);
        add(jmbgDoktorFld, 1, 1);

        add(imeDoktorLbl, 0, 2);
        add(imeDoktorFld, 1, 2);

        add(adresaDoktorLbl, 0, 3);
        add(adresaDoktorFld, 1, 3);

        add(starostDoktorLbl, 0, 4);
        add(starostDoktorFld, 1, 4);

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

    public Label getJmbgDoktorLbl() {
        return jmbgDoktorLbl;
    }

    public void setJmbgDoktorLbl(Label jmbgDoktorLbl) {
        this.jmbgDoktorLbl = jmbgDoktorLbl;
    }

    public Label getImeDoktorLbl() {
        return imeDoktorLbl;
    }

    public void setImeDoktorLbl(Label imeDoktorLbl) {
        this.imeDoktorLbl = imeDoktorLbl;
    }

    public Label getAdresaDoktorLbl() {
        return adresaDoktorLbl;
    }

    public void setAdresaDoktorLbl(Label adresaDoktorLbl) {
        this.adresaDoktorLbl = adresaDoktorLbl;
    }

    public Label getStarostDoktorLbl() {
        return starostDoktorLbl;
    }

    public void setStarostDoktorLbl(Label starostDoktorLbl) {
        this.starostDoktorLbl = starostDoktorLbl;
    }

    public TextField getJmbgDoktorFld() {
        return jmbgDoktorFld;
    }

    public void setJmbgDoktorFld(TextField jmbgDoktorFld) {
        this.jmbgDoktorFld = jmbgDoktorFld;
    }

    public TextField getImeDoktorFld() {
        return imeDoktorFld;
    }

    public void setImeDoktorFld(TextField imeDoktorFld) {
        this.imeDoktorFld = imeDoktorFld;
    }

    public TextField getAdresaDoktorFld() {
        return adresaDoktorFld;
    }

    public void setAdresaDoktorFld(TextField adresaDoktorFld) {
        this.adresaDoktorFld = adresaDoktorFld;
    }

    public TextField getStarostDoktorFld() {
        return starostDoktorFld;
    }

    public void setStarostDoktorFld(TextField starostDoktorFld) {
        this.starostDoktorFld = starostDoktorFld;
    }

    public Button getDodajBtn() {
        return dodajBtn;
    }

    public void setDodajBtn(Button dodajBtn) {
        this.dodajBtn = dodajBtn;
    }

}
