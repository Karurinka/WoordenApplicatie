package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.ILogic;
import woordenapplicatie.Logic;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable
{

    private static final String DEFAULT_TEXT = "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Heb je dan geen hoedje meer\n" +
            "Maak er één van bordpapier\n" +
            "Eén, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "En als het hoedje dan niet past\n" +
            "Zetten we 't in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";

    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    private ILogic logic;
    private String words;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        taInput.setText(DEFAULT_TEXT);
        words = taInput.getText();
        logic = new Logic(words);
    }

    @FXML
    /**
     * Telt de totaal aantal woorden en de aantal verschillende woorden
     */
    private void aantalAction(ActionEvent event)
    {
        taOutput.setText(logic.aantal());
    }

    @FXML
    /**
     * Laat de woorden in omgekeerde alfabetische volgorde zien
     */
    private void sorteerAction(ActionEvent event)
    {
        logic.sorteer();
    }

    @FXML
    /**
     * Houdt bij hoe vaak een bepaald woord voorkomt
     */
    private void frequentieAction(ActionEvent event)
    {
        logic.frequentie();
    }

    @FXML
    /**
     *
     */
    private void concordatieAction(ActionEvent event)
    {
        logic.concordantie();
    }

}
