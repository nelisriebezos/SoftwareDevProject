package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import controllers.Manager;
import domeinKlassen.*;

public class AbsentieBekijkenLeerlingController {
	public Label datumZiekLabel;
	public Button ZiekmeldenKnop;
	public ComboBox vakkenCombobox;
	public ListView vakkenListView;
	public Label naamLeerlingLabel;
	public ListView absentieListView;

	public void initialize() {
		naamLeerlingLabel.setText(Manager.getInstance().getIngelogdStudent().getVoorNaam());
		List<Vak> vakken = Manager.getInstance().getIngelogdStudent().getVakken();
		vakkenCombobox.setItems(FXCollections.observableList(vakken));
		if (Manager.getInstance().getIngelogdStudent().getIsWelNietZiek()) {
			ZiekmeldenKnop.setText("Beter melden");
		}
	}

	public void Home(ActionEvent actionEvent) throws IOException {
		Manager.getInstance().schrijfWeg();

		Button source = (Button) actionEvent.getSource();
		Stage stage2 = (Stage) source.getScene().getWindow();
		stage2.close();
		initialize();
	}

	public void MeldZiek(ActionEvent actionEvent) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatedDateTime = now.format(formatter);

		if (!Manager.getInstance().getIngelogdStudent().getIsWelNietZiek()) {
			System.out.println("meld ziek");
			List<Les> lessenlijst = Manager.getInstance().getIngelogdStudent().getKlas().getRooster().getLessenLijst();
			for (Les l : lessenlijst) {
				if (l.getDag().equals(LocalDate.now())) {
					Manager.getInstance().getIngelogdStudent().setAbsent(l, Manager.getInstance().getIngelogdStudent());
				}
			}
			datumZiekLabel.setText("Je bent ziekgemeld vanaf:\n" + formatedDateTime);
			ZiekmeldenKnop.setText("Beter melden");
			Manager.getInstance().getIngelogdStudent().setWelNietZiek(true);

		} else {
			System.out.println("meld beter");
			datumZiekLabel.setText("");
			ZiekmeldenKnop.setText("Ziekmelden");
			Manager.getInstance().getIngelogdStudent().setWelNietZiek(false);

		}

	}

	public void VakkengekozenOnAction(ActionEvent actionEvent) {
		ObservableList<Object> studentnaam = FXCollections.observableArrayList(vakkenCombobox.getValue());
		vakkenListView.setItems(studentnaam);

		List<Les> lessenlijst = Manager.getInstance().getIngelogdStudent().getKlas().getRooster().getLessenLijst();
		List<Integer> absentieAantal = FXCollections
				.observableArrayList(Manager.getInstance().getIngelogdStudent().getTotaalAbsentieAantal());
		absentieListView.setItems((ObservableList) absentieAantal);
	}

}
