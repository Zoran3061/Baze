/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.DodajPacijentaAction;
import Actions.UpdatePacijentAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Doktor;
import Tabele.Pacijent;
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
 * @author Milos PC
 */
public class UpdatePacijentView extends GridPane {

    private Label jmbgDoktorLbl = new Label("Doktor jmbg: ");
    private Label imeLbl = new Label("Ime pacijenta: ");
    private Label adresaLbl = new Label("Adresa pacijenta: ");
    private Label starostLbl = new Label("Starost pacijenta: ");

    private ComboBox jmbgDoktorCb = new ComboBox();
    private TextField imeFld = new TextField();
    private TextField adresaFld = new TextField();
    private TextField starostFld = new TextField();
    private Pacijent p1;

    private Button dodajBtn = new Button("Izmeni");

    public UpdatePacijentView() {
        p1 = (Pacijent) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();
        setP1(p1);
        dodajBtn.setOnAction(new DodajPacijentaAction());

        Baza.connect();
        ArrayList<Doktor> doktori = Baza.getAllDoktor();
        Baza.disconnect();

        ObservableList<String> doktoriOl = FXCollections.observableArrayList();
        int indeksDoktor = 0;

        for (int i = 0; i < doktori.size(); i++) {
            doktoriOl.add(String.valueOf(doktori.get(i).getJmbg()));
            if (doktori.get(i).getJmbg().equals(p1.getJmbg())) {
                indeksDoktor = i;
            }
        }

        jmbgDoktorCb.setItems(doktoriOl);
        jmbgDoktorCb.getSelectionModel().select(indeksDoktor);
        imeFld.setText(p1.getIme());
        adresaFld.setText(p1.getAdresa());
        starostFld.setText(String.valueOf(p1.getStarost_pacijent()));
        dodajBtn.setOnAction(new UpdatePacijentAction());

        add(jmbgDoktorLbl, 0, 0);
        add(jmbgDoktorCb, 1, 0);

        add(imeLbl, 0, 1);
        add(imeFld, 1, 1);

        add(adresaLbl, 0, 2);
        add(adresaFld, 1, 2);

        add(starostLbl, 0, 3);
        add(starostFld, 1, 3);

        add(dodajBtn, 1, 4);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }
    public ComboBox getJmbgDoktorCb() {
        return jmbgDoktorCb;
    }

    public void setJmbgDoktorCb(ComboBox jmbgDoktorCb) {
        this.jmbgDoktorCb = jmbgDoktorCb;
    }

    public TextField getImeFld() {
        return imeFld;
    }

    public void setImeFld(TextField imeFld) {
        this.imeFld = imeFld;
    }

    public TextField getAdresaFld() {
        return adresaFld;
    }

    public void setAdresaFld(TextField adresaFld) {
        this.adresaFld = adresaFld;
    }

    public TextField getStarostFld() {
        return starostFld;
    }

    public void setStarostFld(TextField starostFld) {
        this.starostFld = starostFld;
    }

    public Pacijent getP1() {
        return p1;
    }

    public void setP1(Pacijent p1) {
        this.p1 = p1;
    }

}
