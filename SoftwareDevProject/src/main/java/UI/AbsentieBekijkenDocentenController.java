package UI;

import domeinKlassen.Klas;
import domeinKlassen.Les;
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
	public Label alAbsent;
	public ComboBox<Les> lesComboBox;
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Home2.fxml"));
		Parent root = loader.load();
	}

	public void kiesLeerlingOnAction(ActionEvent actionEvent) {
		Klas geselecteerdeKlas = klassenComboBox.getValue();
		List<Les> lessenLijst = geselecteerdeKlas.getRooster().getLessenLijst();
		lesComboBox.setItems(FXCollections.observableList(lessenLijst));
		ObservableList<Object> studentnaam = FXCollections.observableArrayList();
		List<Integer> absentie = FXCollections.observableArrayList();

		for (Student s : geselecteerdeKlas.getStudentenLijst()) {
			studentnaam.add(s);
			absentie.add(s.getTotaalAbsentieAantal());
		}
		absentListView.setItems((ObservableList) absentie);
		leerlingListView.setItems(FXCollections.observableArrayList(studentnaam));

	}

	public void selecteerLes(ActionEvent actionEvent) {
		ObservableList<Object> studentnaam = FXCollections.observableArrayList();

		Les geselecteerdeLes = (Les) lesComboBox.getValue();

		for (Student s : geselecteerdeLes.getRooster().getKlas().getStudentenLijst()) {
			studentnaam.add(s);
		}
		kiesLeerlingComboBox.setItems(studentnaam);
	}

	public void zetAbsent(ActionEvent actionEvent) {
		Les geselecteerdeLes = (Les) lesComboBox.getValue();
		Student geselecteerdeStudent = (Student) kiesLeerlingComboBox.getValue();
		List<Integer> absentie = FXCollections.observableArrayList();

		if (geselecteerdeStudent.getAbsent(geselecteerdeLes)) {
			alAbsent.setText("Student is al absent");
		} else {
			alAbsent.setText("");
			geselecteerdeStudent.setAbsent(geselecteerdeLes, geselecteerdeStudent);

			for (Student s : geselecteerdeLes.getRooster().getKlas().getStudentenLijst()) {
				System.out.println(s.getTotaalAbsentieAantal());
				absentie.add(s.getTotaalAbsentieAantal());
			}
			absentListView.setItems((ObservableList) absentie);
		}
	}
}
