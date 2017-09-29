import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.util.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Button bt_0_0;

    @FXML
    private Button bt_0_1;

    @FXML
    private Button bt_0_2;

    @FXML
    private Button bt_0_3;

    @FXML
    private Button bt_1_0;

    @FXML
    private Button bt_1_1;

    @FXML
    private Button bt_1_2;

    @FXML
    private Button bt_1_3;

    @FXML
    private Button bt_0_4;

    @FXML
    private Button bt_1_4;

    @FXML
    private Button bt_0_5;

    @FXML
    private Button bt_1_5;

    @FXML
    private Button bt_0_6;

    @FXML
    private Button bt_1_6;

    @FXML
    private Button bt_0_7;

    @FXML
    private Button bt_1_7;

    @FXML
    private Button bt_0_8;

    @FXML
    private Button bt_1_8;

    @FXML
    private Button bt_0_9;

    @FXML
    private Button bt_1_9;

    @FXML
    private Button bt_2_0;

    @FXML
    private Button bt_2_1;

    @FXML
    private Button bt_3_0;

    @FXML
    private Button bt_3_1;

    @FXML
    private Button bt_4_0;

    @FXML
    private Button bt_4_1;

    @FXML
    private Button bt_5_0;

    @FXML
    private Button bt_5_1;

    @FXML
    private Button bt_6_0;

    @FXML
    private Button bt_6_1;

    @FXML
    private Button bt_7_0;

    @FXML
    private Button bt_7_1;

    @FXML
    private Button bt_8_0;

    @FXML
    private Button bt_8_1;

    @FXML
    private Button bt_2_2;

    @FXML
    private Button bt_2_3;

    @FXML
    private Button bt_2_4;

    @FXML
    private Button bt_2_5;

    @FXML
    private Button bt_2_6;

    @FXML
    private Button bt_2_7;

    @FXML
    private Button bt_2_8;

    @FXML
    private Button bt_2_9;

    @FXML
    private Button bt_3_2;

    @FXML
    private Button bt_3_3;

    @FXML
    private Button bt_3_4;

    @FXML
    private Button bt_3_5;

    @FXML
    private Button bt_3_6;

    @FXML
    private Button bt_3_7;

    @FXML
    private Button bt_3_8;

    @FXML
    private Button bt_3_9;

    @FXML
    private Button bt_4_2;

    @FXML
    private Button bt_4_3;

    @FXML
    private Button bt_4_4;

    @FXML
    private Button bt_4_5;

    @FXML
    private Button bt_4_6;

    @FXML
    private Button bt_4_7;

    @FXML
    private Button bt_4_9;

    @FXML
    private Button bt_5_2;

    @FXML
    private Button bt_5_3;

    @FXML
    private Button bt_5_4;

    @FXML
    private Button bt_5_5;

    @FXML
    private Button bt_5_6;

    @FXML
    private Button bt_5_7;

    @FXML
    private Button bt_5_8;

    @FXML
    private Button bt_5_9;

    @FXML
    private Button bt_6_2;

    @FXML
    private Button bt_6_3;

    @FXML
    private Button bt_6_4;

    @FXML
    private Button bt_6_5;

    @FXML
    private Button bt_6_6;

    @FXML
    private Button bt_6_7;

    @FXML
    private Button bt_6_8;

    @FXML
    private Button bt_6_9;

    @FXML
    private Button bt_7_2;

    @FXML
    private Button bt_7_3;

    @FXML
    private Button bt_7_4;

    @FXML
    private Button bt_7_5;

    @FXML
    private Button bt_7_6;

    @FXML
    private Button bt_7_7;

    @FXML
    private Button bt_7_8;

    @FXML
    private Button bt_7_9;

    @FXML
    private Button bt_8_2;

    @FXML
    private Button bt_8_3;

    @FXML
    private Button bt_8_4;

    @FXML
    private Button bt_8_5;

    @FXML
    private Button bt_8_6;

    @FXML
    private Button bt_8_7;

    @FXML
    private Button bt_8_8;

    @FXML
    private Button bt_8_9;

    @FXML
    private Button bt_9_0;

    @FXML
    private Button bt_9_1;

    @FXML
    private Button bt_9_2;

    @FXML
    private Button bt_9_3;

    @FXML
    private Button bt_9_4;

    @FXML
    private Button bt_9_5;

    @FXML
    private Button bt_9_6;

    @FXML
    private Button bt_9_7;

    @FXML
    private Button bt_9_8;

    @FXML
    private Button bt_9_9;

    @FXML
    private Label lab_schuss;

    @FXML
    private Label lab_miss;

    @FXML
    private Label lab_hit;

    @FXML
    Meer wasser = new Meer();
    int counter = 0; //Zählt Anzahl der Versuche 
    int counter_hit = 0; // Zählt treffer
    int counter_miss = 0; // Zählt misses
    boolean setzenClicked = false;

    @FXML
    void start(ActionEvent event) {

    }

    @FXML
    void schießen(ActionEvent event) {

        Object source = event.getSource();
        Button clickedButton = (Button) source; //ermittelt welcher Button gedrückt wurde

        String id = clickedButton.getId().toString();
        String[] numbers = id.replaceAll("^\\D+", "").split("\\D+");
        boolean beschossen = wasser.beschossen(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[0]));

        if (beschossen == false) {
            counter++; //Zählt Anzahl der Versuche
            String conv = Integer.toString(counter);
            lab_schuss.setText("Schüsse: " + conv); //setzt das Label Schüsse
            System.out.println("Sie benötigten bis jetzt " + counter + " Versuche.");
            String hit = wasser.schiesse(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[0]));
            if (hit == "Treffer") {
                counter_hit++;
                String conv_hit = Integer.toString(counter_hit);
                System.out.println("Treffer");
                lab_hit.setText("Treffer : " + conv_hit); //setzt das Label treffer
                clickedButton.setStyle("-fx-background-image: url(\"grafics/nuclear.png\");");
                clickedButton.setText("");
            } else {
                counter_miss++;
                System.out.println("Treffer");
                String conv_miss = Integer.toString(counter_miss);
                lab_miss.setText("Daneben : " + conv_miss); //setzt das Label treffer
                clickedButton.setStyle("-fx-background-image: url(\"grafics/sea.png\");");
                clickedButton.setText("");
            }
        } // end of if

        if (wasser.nochSchiffe() == false) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("end.fxml"));
                //SplitPane page = (SplitPane) FXMLLoader.load(Main.class.getResource("win/win.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Win!");
                String css = Main.class.getResource("start.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {

            }
        }
    }//End of schießen

    @FXML
    void reset(ActionEvent event) {
        wasser.reset();
        setzenClicked = false;
        System.out.println("----------------- RESET -------------------");
        wasser.konsolenausgabe();

    }//End of reset

    @FXML
    void initialize() {
        int counter = 0;
        int i = 1;

        if (setzenClicked != true) {
            for (i = 1; i <= 1; i++) { // ein Schlachtschiff mit 5 Feldern
                while (wasser.schiffGesetzt() == false) {
                    wasser.randomSchiffe(5);
                }
                wasser.schiffGesetzt = false;
            }

            System.out.println(" 5 er gesetzt in " + counter + " Versuchen");
            wasser.konsolenausgabe();

            for (i = 1; i <= 2; i++) { // zwei Kreuzer mit 4 Feldern
                while (wasser.schiffGesetzt() == false) {
                    wasser.randomSchiffe(4);
                }
                wasser.schiffGesetzt = false;
            }

            System.out.println(" 4 er gesetzt in " + counter + " Versuchen");
            wasser.konsolenausgabe();

            for (i = 1; i <= 3; i++) { // drei Zerstoerer mit 3 Feldern
                while ((wasser.schiffGesetzt() == false) && (counter < 50)) {
                    wasser.randomSchiffe(3);
                    counter++;
                }
                wasser.schiffGesetzt = false;
            }

            System.out.println(" 3 er gesetzt in " + counter + " Versuchen");
            wasser.konsolenausgabe();
            counter = 0;

            for (i = 1; i <= 4; i++) { // drei U-Boote mit 2 Feldern
                while ((wasser.schiffGesetzt() == false) && (counter < 100)) {
                    wasser.randomSchiffe(2);
                    counter++;
                }
                wasser.schiffGesetzt = false;
            }

            System.out.println(" 2 er gesetzt  in " + counter + " Versuchen");
            wasser.konsolenausgabe();
            counter = 0;

            setzenClicked = true;//verhindert erneutes setzen der Schiffe bei wiederholtem Click

        } else {
            System.out.println("Schiffe wurden bereits gesetzt");
        }

    }// End of setzen
}