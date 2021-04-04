package UI;

import javafx.event.ActionEvent;
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
import java.util.ArrayList;

import controllers.objectLijsten;
import domeinKlassen.Docent;
import domeinKlassen.Student;

public class LoginController {

	public Label misluktLabel;
	public PasswordField WachtwoordPasswordField;
	public TextField GebruikersnaamTextField;

	public void LoginKnop(ActionEvent actionEvent) {
//		for (Student s : objectLijsten.getStudentenLijst()) {
//			if (WachtwoordPasswordField.getText().equals(s.getWachtwoord())
//					&& GebruikersnaamTextField.getText().equals(String.valueOf( s.getLeerlingNummer()))) {
				
				Button source = (Button) actionEvent.getSource();
				Stage stage2 = (Stage) source.getScene().getWindow();
				stage2.close();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
//			} else {
//				misluktLabel.setText("De combinatie van wachtwoord en gebruikersnaam klopt niet.");
//			}
		}
	}
//}
