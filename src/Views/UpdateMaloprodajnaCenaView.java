/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.UpdateMaloprodajnaCenaAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Apoteka;
import Tabele.Lek;
import Tabele.Maloprodajna_cena;
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
public class UpdateMaloprodajnaCenaView extends GridPane {

    private Label idApotekaLbl = new Label("Apoteka ID:");
    private Label sifraLekLbl = new Label("Sifra leka: ");
    private Label cenaLekLbl = new Label("Cena leka: ");

    private ComboBox idApotekaCb = new ComboBox();
    private ComboBox sifraLekCb = new ComboBox();
    private TextField cenaLekFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    private Maloprodajna_cena mc;

    public UpdateMaloprodajnaCenaView() {

        mc = (Maloprodajna_cena) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();
        // uzet iz tabele na koji je kliknut
        setMc(mc);//setovan

        Baza.connect();
        ArrayList<Apoteka> apoteke = Baza.getAllApoteka();
        ArrayList<Lek> lekovi = Baza.getAllLek();
        Baza.disconnect();

        int lekIndeks = 0;
        int apotekaID = 0;

        ObservableList<String> apotekeOL = FXCollections.observableArrayList();
        ObservableList<String> sifraLekOL = FXCollections.observableArrayList();

        for (int i = 0; i < lekovi.size(); i++) {
            sifraLekOL.add(String.valueOf(lekovi.get(i).getSifra()));
            if (lekovi.get(i).getSifra() == mc.getSifra_lek()) {
                lekIndeks = i;
            }
        }
        for (int i = 0; i < apoteke.size(); i++) {
            apotekeOL.add(String.valueOf(apoteke.get(i).getId()));
            if (apoteke.get(i).getId() == mc.getApoteka_id()) {
                apotekaID = i;
            }
        }

        sifraLekCb.setItems(sifraLekOL);
        idApotekaCb.setItems(apotekeOL);
        sifraLekCb.getSelectionModel().select(lekIndeks);
        idApotekaCb.getSelectionModel().select(apotekaID);
        cenaLekFld.setText(String.valueOf(mc.getCena_leka()));

        dodajBtn.setOnAction(new UpdateMaloprodajnaCenaAction());

        add(idApotekaLbl, 0, 1);
        add(idApotekaCb, 1, 1);

        add(sifraLekLbl, 0, 2);
        add(sifraLekCb, 1, 2);

        add(cenaLekLbl, 0, 3);
        add(cenaLekFld, 1, 3);

        add(dodajBtn, 1, 5);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public ComboBox getIdApotekaCb() {
        return idApotekaCb;
    }

    public void setIdApotekaCb(ComboBox idApotekaCb) {
        this.idApotekaCb = idApotekaCb;
    }

    public ComboBox getSifraLekCb() {
        return sifraLekCb;
    }

    public void setSifraLekCb(ComboBox sifraLekCb) {
        this.sifraLekCb = sifraLekCb;
    }

    public TextField getCenaLekFld() {
        return cenaLekFld;
    }

    public void setCenaLekFld(TextField cenaLekFld) {
        this.cenaLekFld = cenaLekFld;
    }

    public Maloprodajna_cena getMc() {
        return mc;
    }

    public void setMc(Maloprodajna_cena mc) {
        this.mc = mc;
    }

}
