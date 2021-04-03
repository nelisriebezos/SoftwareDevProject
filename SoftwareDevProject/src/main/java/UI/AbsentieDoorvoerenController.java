package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AbsentieDoorvoerenController {
    public void initialize() {
    }



    public void Home2(ActionEvent actionEvent) {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();

        initialize();
    }
}
