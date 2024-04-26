/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.UpdateZamenaAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Lek;
import Tabele.Zamena;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Filip
 */
public class UpdateZamenaView extends GridPane {

    private Label sifraLekLbl = new Label("Sifra leka: ");
    private Label sifraZamenaLbl = new Label("Sifra zamene: ");

    private ComboBox sifraLekCb = new ComboBox();
    private ComboBox sifraZamenaCb = new ComboBox();

    private Button dodajBtn = new Button("Dodaj");

    private Zamena z;

    public UpdateZamenaView() {

        z = (Zamena) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();

        setZ(z);

        Baza.connect();
        ArrayList<Lek> lekovi = Baza.getAllLek();
        Baza.disconnect();

        ObservableList<String> lekoviOl = FXCollections.observableArrayList();

        int sl = 0;
        int slz = 0;
        for (int i = 0; i < lekovi.size(); i++) {
            lekoviOl.add(String.valueOf(lekovi.get(i).getSifra()));
            if (lekovi.get(i).getSifra() == z.getSifra_lek()) {
                sl = i;
            }
            if (lekovi.get(i).getSifra() == z.getZamena_sifra_lek()) {
                slz = i;
            }
        }

        sifraLekCb.setItems(lekoviOl);
        sifraZamenaCb.setItems(lekoviOl);
        sifraLekCb.getSelectionModel().select(sl);
        sifraZamenaCb.getSelectionModel().select(slz);

        dodajBtn.setOnAction(new UpdateZamenaAction());

        add(sifraLekLbl, 0, 2);
        add(sifraLekCb, 1, 2);

        add(sifraZamenaLbl, 0, 3);
        add(sifraZamenaCb, 1, 3);

        add(dodajBtn, 1, 4);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public ComboBox getSifraLekCb() {
        return sifraLekCb;
    }

    public void setSifraLekCb(ComboBox sifraLekCb) {
        this.sifraLekCb = sifraLekCb;
    }

    public ComboBox getSifraZamenaCb() {
        return sifraZamenaCb;
    }

    public void setSifraZamenaCb(ComboBox sifraZamenaCb) {
        this.sifraZamenaCb = sifraZamenaCb;
    }

    public Zamena getZ() {
        return z;
    }

    public void setZ(Zamena z) {
        this.z = z;
    }

}
