package UIcontrollers;

import domeinKlassen.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import controllers.Objecten;
import domeinKlassen.*;

public class AbsentieBekijkenLeerlingController {
    public Label datumZiekLabel;
    public Button ZiekmeldenKnop;
    public ComboBox vakkenCombobox;
    public ListView vakkenListView;
    public Label naamLeerlingLabel;
    public ListView absentieListView;

    public void initialize(){
        naamLeerlingLabel.setText(Objecten.getIngelogdStudent().getVoorNaam());
        List<Vak> vakken = Objecten.getIngelogdStudent().getVakken();
        vakkenCombobox.setItems(FXCollections.observableList(vakken));
    }

    public void Home(ActionEvent actionEvent) throws IOException {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();
        initialize();
    }


    public void MeldZiek(ActionEvent actionEvent) {    	
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDateTime = now.format(formatter);
        if(!Objecten.getIngelogdStudent().getIsWelNietZiek()){
            datumZiekLabel.setText("");
            ZiekmeldenKnop.setText("Ziekmelden");
            Objecten.getIngelogdStudent().setWelNietZiek(true);
        }
        else{
        datumZiekLabel.setText("Je bent ziekgemeld vanaf:\n" + formatedDateTime);
        ZiekmeldenKnop.setText("Beter melden");
        Objecten.getIngelogdStudent().setWelNietZiek(false);
        }

    }

    public void VakkengekozenOnAction(ActionEvent actionEvent) {
        ObservableList<Object> studentnaam= FXCollections.observableArrayList(vakkenCombobox.getValue());
        vakkenListView.setItems(studentnaam);
        
        List<Integer> absentieAantal = FXCollections.observableArrayList(Objecten.getIngelogdStudent().getAbsentieAantal());
        absentieListView.setItems((ObservableList) absentieAantal);
    }

}
