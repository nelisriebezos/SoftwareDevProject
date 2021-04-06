package UI;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import controllers.Objecten;
import domeinKlassen.Klas;
import domeinKlassen.Les;
import domeinKlassen.Vak;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Home2Controller {
	
	public DatePicker overzichtDatePicker;
	public ListView<Les> vakkenListView;
	
	public void initialize() {
		overzichtDatePicker.setValue(LocalDate.now());
        toonLessen();
	}

	public void AbsentieBekijken(ActionEvent actionEvent) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AbsentieBekijkenDocenten.fxml"));
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
	
	public void toonLessen() {
		List<Vak> vakkenLijst = Objecten.getIngelogdDocent().getVakkenLijst();
			for(Vak vak: vakkenLijst) {
				List<Les> lessenLijst = vak.getLessenLijst();
				for(Les les: lessenLijst) {
					if(overzichtDatePicker.getValue().equals(les.getBeginTijd())) {
						ObservableList<Les> lessen = FXCollections.observableArrayList();
						lessen.add(les);
						vakkenListView.setItems(FXCollections.observableArrayList(lessen));
					}
				}
			}
			
		
	}
	
	public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = overzichtDatePicker.getValue().minusDays(1);
        overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = overzichtDatePicker.getValue().plusDays(1);
        overzichtDatePicker.setValue(dagLater);
    }
}
