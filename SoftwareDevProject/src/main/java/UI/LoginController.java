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
import controllers.Manager;
import controllers.Utils;
import domeinKlassen.Docent;
import domeinKlassen.Student;

public class LoginController {

	public Label misluktLabel;
	public PasswordField WachtwoordPasswordField;
	public TextField GebruikersnaamTextField;
	public String bestandsNaam = "";

	public void LoginKnop(ActionEvent actionEvent) {	
		if (checkDocent() || checkStudent()) {
				Button source = (Button) actionEvent.getSource();
				Stage stage2 = (Stage) source.getScene().getWindow();
				stage2.close();
				FXMLLoader loader = new FXMLLoader(getClass().getResource(this.bestandsNaam));
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
			} 
		else {
			this.misluktLabel.setText("De combinatie van wachtwoord en gebruikersnaam klopt niet.");
			}
		}
	
	public boolean checkDocent() {
		for (Docent d : Manager.getInstance().getDocentenLijst()) {
			if (Utils.checkPassword(d, WachtwoordPasswordField.getText()) 
					&& GebruikersnaamTextField.getText().equals(String.valueOf(d.getDocentNummer()))) {
				Manager.getInstance().setIngelogdDocent(d);
				this.bestandsNaam = "Home2.fxml";
				return true;
			}
		}
		return false;
	}
	
	public boolean checkStudent() {
		for (Student s : Manager.getInstance().getStudentenLijst()) {
			if (Utils.checkPassword(s, WachtwoordPasswordField.getText())
					&& GebruikersnaamTextField.getText().equals(String.valueOf( s.getLeerlingNummer()))) {
				Manager.getInstance().setIngelogdStudent(s);
				this.bestandsNaam = "Home.fxml";
				return true;
			}
		}
		return false;
	}
}
