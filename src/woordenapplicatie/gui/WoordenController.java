package woordenapplicatie.gui;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.ILogic;
import woordenapplicatie.LogicManager;
import woordenapplicatie.Logic;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable
{

    private ILogic logic;

    private static final String DEFAULT_TEXT =
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +

            "Heb je dan geen hoedje meer\n" +
            "Maak er één van bordpapier\n" +
            "Eén, twee, drie, vier\n" +
            "Hoedje van papier\n" + "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +

            "En als het hoedje dan niet past\n" +
            "Zetten we 't in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";

    /**
     * Alle ui elements uit het fxml bestand
     * Deze worden in de scene builder gekoppeld aan de juiste methoden
     */
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
    @FXML
    private Button btnTinyTest;
    @FXML
    private Button btnBigTest;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        logic = new LogicManager(new Logic());
        taInput.setText(DEFAULT_TEXT);
    }

    @FXML
    /**
     * Telt de totaal aantal woorden en de aantal verschillende woorden
     */ private void aantalAction(ActionEvent event)
    {
        String input = taInput.getText();
        taOutput.setText("Totaal aantal woorden: " + logic.splitString(input).length + "\n" + "Aantal verschillende woorden: " + logic.aantal(input));
    }

    @FXML
    /**
     * Laat de woorden in omgekeerde alfabetische volgorde zien
     */ private void sorteerAction(ActionEvent event)
    {
        StringBuilder stringBuilder = new StringBuilder();

        logic.sorteer(taInput.getText()).forEach(word -> stringBuilder.append(word).append(System.lineSeparator()));
        taOutput.setText(stringBuilder.toString());
    }

    @FXML
    /**
     * Houdt bij hoe vaak een bepaald woord voorkomt
     */ private void frequentieAction(ActionEvent event)
    {
        StringBuilder stringBuilder = new StringBuilder();
        logic.frequentie(taInput.getText()).forEach(stringIntegerEntry -> stringBuilder.append(stringIntegerEntry.getKey()).append(" ").append(stringIntegerEntry.getValue()).append(System.lineSeparator()));
        taOutput.setText(stringBuilder.toString());
    }

    @FXML
    /**
     * Houdt bij welk woord op welke regel staat
     */ private void concordatieAction(ActionEvent event)
    {
        StringBuilder stringBuilder = new StringBuilder();

        logic.concordantie(taInput.getText()).forEach((string, integers) -> stringBuilder.append(string).append(" ").append(Arrays.toString(integers.toArray())).append(String.format("%n")));
        taOutput.setText(stringBuilder.toString());
    }
}
