import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class setting {

    @FXML
    private TextField int_zerstoerer;

    @FXML
    private TextField int_uboot;

    @FXML
    private TextField int_schlacht;

    @FXML
    private TextField int_kreuzer;

    @FXML
    INTEGER schiffslanege() {
        int schlacht = Integer.parseInt(int_schlacht);
        int kreuzer = Integer.parseInt(int_kreuzer);
        int zerstoerer = Integer.parseInt(int_zerstoerer);
        int uboot = Integer.parseInt(int_uboot);
    }

    @FXML
    public int schlacht = Integer.parseInt(int_schlacht);
    public int kreuzer = Integer.parseInt(int_kreuzer);
    public int zerstoerer = Integer.parseInt(int_zerstoerer);
    public int uboot = Integer.parseInt(int_uboot);

}
