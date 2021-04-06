package UIcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import controllers.Objecten;
import domeinKlassen.Docent;

public class HomeController {
	public Button GeplandeAfwezigheidKnop;

	public void initialize() {
//		if (Objecten.getIngelogdPersoon() instanceof Docent) {
//			GeplandeAfwezigheidKnop.setVisible(false);
//		}
	}

	public boolean checkDocentOfStudent() {
//		if (Objecten.getIngelogdPersoon() instanceof Docent) {
//			return true;
//		}
		return false;
	}

	public void AbsentieBekijken(ActionEvent actionEvent) {
		String bestand = "";
		if (checkDocentOfStudent()) {
			bestand = "AbsentieBekijkenDocenten.fxml";
		} else {
			bestand = "AbsentieBekijkenLeerling.fxml";

			FXMLLoader loader = new FXMLLoader(getClass().getResource(bestand));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e) {
				System.out.println("Het opgegeven bestand kan niet geopend worden.");
			}

			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.initModality(Modality.APPLICATION_MODAL);
			newStage.showAndWait();
		}
	}

	public void GeplandeAfwezigheid(ActionEvent actionEvent) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AbsentieDoorvoeren.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			System.out.println("Het opgegeven bestand kan niet geopend worden.");
		}

		Stage newStage = new Stage();
		newStage.setScene(new Scene(root));
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.showAndWait();
		initialize();
	}
}
