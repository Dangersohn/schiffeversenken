import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;

public class Main extends Application {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[]) null);

    }

@Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("start.fxml"));
           // BorderPane page = (BorderPane) FXMLLoader.load(Main.class.getResource("win.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            //String css = Main.class.getResource("playground.css").toExternalForm();
           // scene.getStylesheets().add(css);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Schiffeversenken");
             String css = Main.class.getResource("start.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.show();

        } catch (Exception ex) {

        }
    }

}