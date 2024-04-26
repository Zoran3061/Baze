package Actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Filip
 */
public class OsveziTabeluAction implements EventHandler<ActionEvent> {

    public OsveziTabeluAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        OsveziTabelu.osveziTabelu();
    }

}
