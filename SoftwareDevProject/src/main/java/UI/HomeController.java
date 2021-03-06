package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import controllers.Manager;
import domeinKlassen.Les;

public class HomeController {
	public Button GeplandeAfwezigheidKnop;
	public DatePicker overzichtDatePicker;
	public ListView<Les> vakkenListView;

	public void initialize() {
		this.overzichtDatePicker.setValue(LocalDate.now());
        toonLessen();
	}


	public void AbsentieBekijken(ActionEvent actionEvent) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AbsentieBekijkenLeerling.fxml"));
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
	
	public void toonLessen() {
		ObservableList<Les> lessen = FXCollections.observableArrayList();
		List<Les> lessenLijst = Manager.getInstance().getIngelogdStudent().getKlas().getRooster().getLessenLijst();
				for(Les les: lessenLijst) {
					if(overzichtDatePicker.getValue().equals(les.getDag())) {
						lessen.add(les);
					}
				}
				this.vakkenListView.setItems(FXCollections.observableArrayList(lessen));
			}
	
	public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = this.overzichtDatePicker.getValue().minusDays(1);
        this.overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = this.overzichtDatePicker.getValue().plusDays(1);
        this.overzichtDatePicker.setValue(dagLater);
}
    }
