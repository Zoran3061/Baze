/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Actions.UpdateLekAction;
import Baza.Baza;
import Controller.Controller;
import Tabele.Dobavljac;
import Tabele.Lek;
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
public class UpdateLekView extends GridPane {

    private Label dobavljacLbl = new Label("Dobavljac: ");
    private Label imeLekLbl = new Label("Ime leka: ");

    private ComboBox dobavljacCb = new ComboBox();
    private TextField imeLekFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");
    private Lek l1;

    public UpdateLekView() {
        l1 = (Lek) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();
        setL1(l1);

        Baza.connect();
        ArrayList<Dobavljac> dobavljaci = Baza.getAllDobavljac();
        Baza.disconnect();

        ObservableList<String> dobavljaciOL = FXCollections.observableArrayList();

        int dobavljacIndeks = 0;

        for (int i = 0; i < dobavljaci.size(); i++) {
            dobavljaciOL.add(String.valueOf(dobavljaci.get(i).getId()));
            if (dobavljaci.get(i).getId() == l1.getDobavljac_id()) {
                dobavljacIndeks = i;
            }
        }

        dobavljacCb.setItems(dobavljaciOL);
        dobavljacCb.getSelectionModel().select(dobavljacIndeks);
        imeLekFld.setText(l1.getIme());
        dodajBtn.setOnAction(new UpdateLekAction());

        add(dobavljacLbl, 0, 2);
        add(dobavljacCb, 1, 2);

        add(imeLekLbl, 0, 3);
        add(imeLekFld, 1, 3);

        add(dodajBtn, 1, 5);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
    }

    public ComboBox getDobavljacCb() {
        return dobavljacCb;
    }

    public void setDobavljacCb(ComboBox dobavljacCb) {
        this.dobavljacCb = dobavljacCb;
    }

    public TextField getImeLekFld() {
        return imeLekFld;
    }

    public void setImeLekFld(TextField imeLekFld) {
        this.imeLekFld = imeLekFld;
    }

    public Lek getL1() {
        return l1;
    }

    public void setL1(Lek l1) {
        this.l1 = l1;
    }

}
