package Actions;


import Views.AddAngazovanjeView;
import Controller.Controller;
import Views.AddApotekaView;
import Views.AddDobavljacView;
import Views.AddDoktorView;
import Views.AddFarmaceutView;
import Views.AddKomercijalistaView;
import Views.AddLekView;
import Views.AddMaloprodajnaCenaView;
import Views.AddPacijentView;
import Views.AddReceptView;
import Views.AddUgovorView;
import Views.AddZamenaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Filip
 */
public class DodajAction implements EventHandler<ActionEvent> {

    public DodajAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        int izbor = 0;

        if(!Controller.getInstance().getSideStage().isShowing()){
            izbor = Controller.getInstance().getPocetniEkranView().getPocetniEkranTabeleCb().getSelectionModel().getSelectedIndex();
        } else{
            izbor = Controller.getInstance().getTabeleCb().getSelectionModel().getSelectedIndex();
        }
        switch (izbor) {
            case 0: {
                AddAngazovanjeView addAngazovanjeView = new AddAngazovanjeView();
                Scene scene = new Scene(addAngazovanjeView, 390, 345);
                Controller.getInstance().setAddAngazovanjeView(addAngazovanjeView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novo angazovanje");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 1: {
                AddApotekaView addApotekaView = new AddApotekaView();
                Scene scene = new Scene(addApotekaView, 390, 345);
                Controller.getInstance().setAddApotekaView(addApotekaView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novu apoteku");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 2: {
                AddDobavljacView addDobavljacView = new AddDobavljacView();
                Scene scene = new Scene(addDobavljacView, 390, 345);
                Controller.getInstance().setAddDobavljacView(addDobavljacView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novog dobavljaca");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 3: {
                AddDoktorView addDoktorView = new AddDoktorView();
                Scene scene = new Scene(addDoktorView, 390, 345);
                Controller.getInstance().setAddDoktorView(addDoktorView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novog doktora");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 4: {
                AddFarmaceutView addFarmaceutView = new AddFarmaceutView();
                Scene scene = new Scene(addFarmaceutView, 390, 345);
                Controller.getInstance().setAddFarmaceutView(addFarmaceutView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novog farmaceuta");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 5: {
                AddKomercijalistaView addKomercijalistaView = new AddKomercijalistaView();
                Scene scene = new Scene(addKomercijalistaView, 390, 345);
                Controller.getInstance().setAddKomercijalistaView(addKomercijalistaView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novog komercijalistu");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 6:{
                AddLekView addLekView = new AddLekView();
                Scene scene = new Scene(addLekView, 390, 345);
                Controller.getInstance().setAddLekView(addLekView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj nov lek");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 7:{
                AddMaloprodajnaCenaView addMaloprodajnaCenaView = new AddMaloprodajnaCenaView();
                Scene scene = new Scene(addMaloprodajnaCenaView, 390, 345);
                Controller.getInstance().setAddMaloprodajnaCenaView(addMaloprodajnaCenaView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novu maloprodajnu cenu");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 8:{
                AddPacijentView addPacijentView = new AddPacijentView();
                Scene scene = new Scene(addPacijentView, 390, 345);
                Controller.getInstance().setAddPacijentView(addPacijentView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj novog pacijenta");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 9:{
                AddReceptView addReceptView = new AddReceptView();
                Scene scene = new Scene(addReceptView, 390, 345);
                Controller.getInstance().setAddReceptView(addReceptView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj nov recept");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 10:{
                AddUgovorView addUgovorView = new AddUgovorView();
                Scene scene = new Scene(addUgovorView, 390, 455);
                Controller.getInstance().setAddUgovorView(addUgovorView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj nov ugovor");
                Controller.getInstance().getSideStage().show();
                break;
            }
            case 11:{
                AddZamenaView addZamenaView = new AddZamenaView();
                Scene scene = new Scene(addZamenaView, 390, 300);
                Controller.getInstance().setAddZamenaView(addZamenaView);
                Controller.getInstance().getSideStage().setScene(scene);
                Controller.getInstance().getSideStage().setTitle("Dodaj nov novu zamenu");
                Controller.getInstance().getSideStage().show();
                break;
            }
            default:
                break;
        }
    }
  
  
    
}
