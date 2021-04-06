package UI;

import domeinKlassen.Klas;
import domeinKlassen.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import controllers.Objecten;

public class AbsentieBekijkenDocentenController {
	public ComboBox<Klas> klassenComboBox;
	public ComboBox<Object> kiesLeerlingComboBox;
	public ListView<Integer> absentListView;
	public ListView<Object> leerlingListView;

	public void initialize() {
		List<Klas> klassenLijst = Objecten.getIngelogdDocent().getKlassenLijst();
		klassenComboBox.setItems(FXCollections.observableList(klassenLijst));
	}

	public void Home(ActionEvent actionEvent) throws IOException {
		Button source = (Button) actionEvent.getSource();
		Stage stage2 = (Stage) source.getScene().getWindow();
		stage2.close();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
		Parent root = loader.load();
	}

	public void kiesLeerlingOnAction(ActionEvent actionEvent) {
		ObservableList<Object> studentnaam = FXCollections.observableArrayList();
		List<Integer> inttest = FXCollections.observableArrayList();
		Klas klas = (Klas) klassenComboBox.getValue();
		for (Student s1 : klas.getStudentenLijst()) {
			studentnaam.add(s1.getVoorNaam());
			inttest.add(s1.getAbsentieAantal());
		}
		kiesLeerlingComboBox.setItems(studentnaam);
		absentListView.setItems((ObservableList) inttest);
		leerlingListView.setItems(FXCollections.observableArrayList(studentnaam));
	}

	
	public void zetAbsent(ActionEvent actionEvent) {
		
	}
}
