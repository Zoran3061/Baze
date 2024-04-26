/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajAction;
import Actions.DodajDobavljacAction;
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
public class AddDobavljacView extends GridPane {

    /*     private int id;
    private String ime;
    private String br_telefona;*/
    private ComboBox tabeleCB = Controller.getInstance().getPocetniEkranView().getTabeleCb();

    private Label idDobavljacLb1 = new Label("Dobavljac ID:");
    private Label imeDobavljacLbl = new Label("Ime dobavljaca: ");
    private Label br_telefonaDobavljacLbl = new Label("Broj telefona : ");

    private TextField idDobavljacFld = new TextField();
    private TextField imeDobavljacFLd = new TextField();

    private TextField telefonDobavljacFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    public AddDobavljacView() {
        dodajBtn.setOnAction(new DodajDobavljacAction());

        tabeleCB = Controller.getInstance().getTabeleCb();
        tabeleCB.getSelectionModel().select(2);
        tabeleCB.setOnAction(new DodajAction());

        add(tabeleCB, 0, 0);

        add(idDobavljacLb1, 0, 1);
        add(idDobavljacFld, 1, 1);

        add(imeDobavljacLbl, 0, 2);
        add(imeDobavljacFLd, 1, 2);

        add(br_telefonaDobavljacLbl, 0, 3);
        add(telefonDobavljacFld, 1, 3);

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

    public Label getIdDobavljacLb1() {
        return idDobavljacLb1;
    }

    public void setIdDobavljacLb1(Label idDobavljacLb1) {
        this.idDobavljacLb1 = idDobavljacLb1;
    }

    public Label getImeDobavljacLbl() {
        return imeDobavljacLbl;
    }

    public void setImeDobavljacLbl(Label imeDobavljacLbl) {
        this.imeDobavljacLbl = imeDobavljacLbl;
    }

    public Label getBr_telefonaDobavljacLbl() {
        return br_telefonaDobavljacLbl;
    }

    public void setBr_telefonaDobavljacLbl(Label br_telefonaDobavljacLbl) {
        this.br_telefonaDobavljacLbl = br_telefonaDobavljacLbl;
    }

    public TextField getIdDobavljacFld() {
        return idDobavljacFld;
    }

    public void setIdDobavljacFld(TextField idDobavljacFld) {
        this.idDobavljacFld = idDobavljacFld;
    }

    public TextField getImeDobavljacFLd() {
        return imeDobavljacFLd;
    }

    public void setImeDobavljacFLd(TextField imeDobavljacFLd) {
        this.imeDobavljacFLd = imeDobavljacFLd;
    }

    public TextField getTelefonDobavljacFld() {
        return telefonDobavljacFld;
    }

    public void setTelefonDobavljacFld(TextField telefonDobavljacFld) {
        this.telefonDobavljacFld = telefonDobavljacFld;
    }

    public Button getDodajBtn() {
        return dodajBtn;
    }

    public void setDodajBtn(Button dodajBtn) {
        this.dodajBtn = dodajBtn;
    }

}
