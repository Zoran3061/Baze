/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.UpdateDoktorAction;
import Controller.Controller;
import Tabele.Doktor;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Filip
 */
public class UpdateDoktorView extends GridPane {

    private Label imeDoktorLbl = new Label("Ime doktora: ");
    private Label adresaDoktorLbl = new Label("Adresa doktora: ");
    private Label starostDoktorLbl = new Label("Starost doktora: ");

    private TextField imeDoktorFld = new TextField();
    private TextField adresaDoktorFld = new TextField();
    private TextField starostDoktorFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    Doktor d;

    public UpdateDoktorView() {
        Doktor d = (Doktor) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();

        setD(d);

        imeDoktorFld.setText(d.getIme());
        adresaDoktorFld.setText(d.getAdresa());
        starostDoktorFld.setText(String.valueOf(d.getStarost()));

        dodajBtn.setOnAction(new UpdateDoktorAction());
        add(imeDoktorLbl, 0, 0);
        add(imeDoktorFld, 1, 0);

        add(adresaDoktorLbl, 0, 1);
        add(adresaDoktorFld, 1, 1);

        add(starostDoktorLbl, 0, 2);
        add(starostDoktorFld, 1, 2);

        add(dodajBtn, 1, 3);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
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

    public Doktor getD() {
        return d;
    }

    public void setD(Doktor d) {
        this.d = d;
    }

}
