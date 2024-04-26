/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Alek97
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Actions.UpdateDobavljacAction;
import Controller.Controller;
import Tabele.Dobavljac;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Milos PC
 */
public class UpdateDobavljacView extends GridPane {

    private Label imeDobavljacLbl = new Label("Ime dobavljaca: ");
    private Label br_telefonaDobavljacLbl = new Label("Broj telefona : ");

    private TextField imeDobavljacFLd = new TextField();
    private TextField telefonDobavljacFld = new TextField();

    private Button dodajBtn = new Button("Dodaj");

    private Dobavljac d1;

    public UpdateDobavljacView() {

        d1 = (Dobavljac) Controller.getInstance().getPocetniEkranView().getTabela().getSelectionModel().getSelectedItem();

        imeDobavljacFLd.setText(d1.getIme());
        telefonDobavljacFld.setText(d1.getBr_telefona());

        dodajBtn.setOnAction(new UpdateDobavljacAction());

        add(imeDobavljacLbl, 0, 2);
        add(imeDobavljacFLd, 1, 2);

        add(br_telefonaDobavljacLbl, 0, 3);
        add(telefonDobavljacFld, 1, 3);

        add(dodajBtn, 1, 5);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);
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

    public Dobavljac getD1() {
        return d1;
    }

    public void setA1(Dobavljac d1) {
        this.d1 = d1;
    }

}
