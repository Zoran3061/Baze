package Views;

import Actions.DodajAction;
import Actions.IzmeniAction;
import Actions.ObrisiAction;
import Actions.OsveziTabeluAction;
import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Filip
 */
public class PocetniEkranView extends VBox {

    private TableView tabela = new TableView();
    private ComboBox tabeleCb = new ComboBox();
    private ComboBox pocetniEkranTabeleCb = new ComboBox();
    private Button dodajBtn = new Button("Dodaj");
    private Button obrisiBtn = new Button("Obrisi");
    private Button izmeniBtn = new Button("Izmeni");

    public PocetniEkranView() {
        ObservableList<String> tabelaList
                = FXCollections.observableArrayList(
                        "Angazovanje",
                        "Apoteka",
                        "Dobavljac",
                        "Doktor",
                        "Farmaceut",
                        "Komercijalista",
                        "Lek",
                        "Maloprodajna cena",
                        "Pacijent",
                        "Recept",
                        "Ugovor",
                        "Zamena"
                );

        tabela.setMaxWidth(700);
        tabela.setMinWidth(700);

        tabeleCb.setItems(tabelaList);
        pocetniEkranTabeleCb.setItems(tabelaList);
        tabeleCb.getSelectionModel().select(0);
        pocetniEkranTabeleCb.getSelectionModel().select(0);
        tabeleCb.setOnAction(new OsveziTabeluAction());
        Controller.getInstance().setTabeleCb(tabeleCb);
        pocetniEkranTabeleCb.setOnAction(new OsveziTabeluAction());
        dodajBtn.setOnAction(new DodajAction());
        izmeniBtn.setOnAction(new IzmeniAction());

        obrisiBtn.setOnAction(new ObrisiAction());

        getChildren().addAll(pocetniEkranTabeleCb, tabela, getButtons());
        setSpacing(15);
        setPadding(new Insets(70, 50, 60, 50));
    }

    private FlowPane getButtons() {
        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(dodajBtn, obrisiBtn, izmeniBtn);
        fp.setHgap(15);
        fp.setAlignment(Pos.BOTTOM_RIGHT);
        return fp;
    }

    public TableView getTabela() {
        return tabela;
    }

    public void setTabela(TableView tabela) {
        this.tabela = tabela;
    }

    public ComboBox getTabeleCb() {
        return tabeleCb;
    }

    public void setTabeleCb(ComboBox tabeleCb) {
        this.tabeleCb = tabeleCb;
    }

    public ComboBox getPocetniEkranTabeleCb() {
        return pocetniEkranTabeleCb;
    }

    public void setPocetniEkranTabeleCb(ComboBox pocetniEkranTabeleCb) {
        this.pocetniEkranTabeleCb = pocetniEkranTabeleCb;
    }

}
