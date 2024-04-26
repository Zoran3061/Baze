/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Actions.OsveziTabelu;
import Views.PocetniEkranView;
import Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Milos PC
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        PocetniEkranView pocetniEkranView = new PocetniEkranView();
        Controller.getInstance().setPocetniEkranView(pocetniEkranView);
        Scene scene = new Scene(pocetniEkranView, 800, 600);
        Controller.getInstance().setMainScene(scene);
        primaryStage.setScene(scene);
        primaryStage.setTitle("IT350 projekat");
        primaryStage.setResizable(false);
        OsveziTabelu.osveziTabelu();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
