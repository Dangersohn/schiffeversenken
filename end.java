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

public class end {

    @FXML
    private Button bt_startstart;

    @FXML
    private Button bt_einstellungen;

    @FXML
    private Label lab_win;



    @FXML
    private Button btn_quit;

      @FXML
    void quit(ActionEvent event) {
        Stage stage = (Stage) btn_quit.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    void einstellungen(ActionEvent event) {

    }

    @FXML
    void spielfeldOeffnen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("playground.fxml"));
            //SplitPane page = (SplitPane) FXMLLoader.load(Main.class.getResource("win/win.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Win!");
            String css = Main.class.getResource("playground.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {

        }
    }
}