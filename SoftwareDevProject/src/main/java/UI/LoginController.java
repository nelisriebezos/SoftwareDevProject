package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public Label misluktLabel;
    public PasswordField WachtwoordPasswordField;
    public TextField GebruikersnaamTextField;
    public void LoginKnop(ActionEvent actionEvent) {
        String ww = "ww";
        String geb = "geb";
        if(WachtwoordPasswordField.getText().equals(ww) && GebruikersnaamTextField.getText().equals(geb)){
            Button source = (Button)actionEvent.getSource();
            Stage stage2 = (Stage)source.getScene().getWindow();
            stage2.close();
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                System.out.println("Het bestand kan niet ingeladen worden");
            }

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
            initialize();
        }
        else{
        misluktLabel.setText("De combinatie van wachtwoord en gebruikersnaam klopt niet.");}

    }

    public void initialize() {
    }
}
