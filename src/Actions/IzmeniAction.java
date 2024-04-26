/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Controller.Controller;
import Views.UpdateAngazovanjeView;
import Views.UpdateApotekaView;
import Views.UpdateDobavljacView;
import Views.UpdateDoktorView;
import Views.UpdateFarmaceutView;
import Views.UpdateKomercijalistaView;
import Views.UpdateLekView;
import Views.UpdateMaloprodajnaCenaView;
import Views.UpdatePacijentView;
import Views.UpdateReceptView;
import Views.UpdateUgovorView;
import Views.UpdateZamenaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 *
 * @author Milos PC
 */
public class IzmeniAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            int izbor = 0;

            if (!Controller.getInstance().getSideStage().isShowing()) {
                izbor = Controller.getInstance().getPocetniEkranView().getPocetniEkranTabeleCb().getSelectionModel().getSelectedIndex();
            } else {
                izbor = Controller.getInstance().getTabeleCb().getSelectionModel().getSelectedIndex();
            }
            switch (izbor) {
                case 0: {
                    UpdateAngazovanjeView updateAngazovanjeView = new UpdateAngazovanjeView();
                    Scene scene = new Scene(updateAngazovanjeView, 390, 345);
                    Controller.getInstance().setUpdateAngazovanjeView(updateAngazovanjeView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni angazovanje");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 1: {
                    UpdateApotekaView updateApotekaView = new UpdateApotekaView();
                    Scene scene = new Scene(updateApotekaView, 390, 345);
                    Controller.getInstance().setUpdateApotekaView(updateApotekaView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni apoteku");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 2: {
                    UpdateDobavljacView updateDobavljacView = new UpdateDobavljacView();
                    Scene scene = new Scene(updateDobavljacView, 390, 345);
                    Controller.getInstance().setUpdateDobavljacView(updateDobavljacView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni dobavljaca");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 3: {
                    UpdateDoktorView updateDoktorView = new UpdateDoktorView();
                    Scene scene = new Scene(updateDoktorView, 390, 345);
                    Controller.getInstance().setUpdateDoktorView(updateDoktorView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni doktora");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 4: {
                    UpdateFarmaceutView updateFarmaceutView = new UpdateFarmaceutView();
                    Scene scene = new Scene(updateFarmaceutView, 390, 345);
                    Controller.getInstance().setUpdateFarmaceutView(updateFarmaceutView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni farmaceuta");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 5: {
                    UpdateKomercijalistaView updateKomercijalistaView = new UpdateKomercijalistaView();
                    Scene scene = new Scene(updateKomercijalistaView, 390, 345);
                    Controller.getInstance().setUpdateKomercijalistaView(updateKomercijalistaView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni komercijalistu");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 6: {
                    UpdateLekView updateLekView = new UpdateLekView();
                    Scene scene = new Scene(updateLekView, 390, 345);
                    Controller.getInstance().setUpdateLekView(updateLekView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni lek");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 7: {
                    UpdateMaloprodajnaCenaView updateMaloprodajnaCenaView = new UpdateMaloprodajnaCenaView();
                    Scene scene = new Scene(updateMaloprodajnaCenaView, 390, 345);
                    Controller.getInstance().setUpdateMaloprodajnaCenaView(updateMaloprodajnaCenaView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni maloprodajnu cenu");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 8: {
                    UpdatePacijentView updatePacijentView = new UpdatePacijentView();
                    Scene scene = new Scene(updatePacijentView, 390, 345);
                    Controller.getInstance().setUpdatePacijentView(updatePacijentView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni pacijenta");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 9: {
                    UpdateReceptView updateReceptView = new UpdateReceptView();
                    Scene scene = new Scene(updateReceptView, 390, 345);
                    Controller.getInstance().setUpdateReceptView(updateReceptView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni recept");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 10: {
                    UpdateUgovorView updateUgovorView = new UpdateUgovorView();
                    Scene scene = new Scene(updateUgovorView, 390, 345);
                    Controller.getInstance().setUpdateUgovorView(updateUgovorView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni ugovor");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
                case 11: {
                    UpdateZamenaView updateZamenaView = new UpdateZamenaView();
                    Scene scene = new Scene(updateZamenaView, 390, 345);
                    Controller.getInstance().setUpdateZamenaView(updateZamenaView);
                    Controller.getInstance().getSideStage().setScene(scene);
                    Controller.getInstance().getSideStage().setTitle("Izmeni zamenu");
                    Controller.getInstance().getSideStage().show();
                    break;
                }
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Izaberite objekat za update");
            alert.showAndWait();
        }

    }

}
