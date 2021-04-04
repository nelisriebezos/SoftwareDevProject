package UI;

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

import domeinKlassen.*;

public class AbsentieBekijkenLeerlingController {
    private Student lijst = Student.getStudent();
    public Label datumZiekLabel;
    public Button ZiekmeldenKnop;
    public ComboBox vakkenCombobox;
    public ListView vakkenListView;
    public Label naamLeerlingLabel;
    public ListView absentieListView;

    public void initialize(){
//        naamLeerlingLabel.setText(lijst.getVoorNaam() + " " + lijst.getAchterNaam());
//        List<Vak> vakken = lijst.getVak();
//        vakkenCombobox.setItems(FXCollections.observableList(vakken));
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
        if(!lijst.getIsWelNietZiek()){
            System.out.println("test");
            datumZiekLabel.setText("");
            ZiekmeldenKnop.setText("Ziekmelden");
            lijst.setWelNietZiek(true);
        }
        else{
        datumZiekLabel.setText("Je bent ziekgemeld vanaf:\n" + formatedDateTime);
        ZiekmeldenKnop.setText("Beter melden");
        lijst.setWelNietZiek(false);
        }

    }


    public void GeplandeAfwezigheid(ActionEvent actionEvent) {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("Absentiedoorvoeren.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("De file kan niet ingelezen worden.");
        }

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        initialize();
    }

    public void VakkengekozenOnAction(ActionEvent actionEvent) {
        ObservableList<Object> studentnaam= FXCollections.observableArrayList(vakkenCombobox.getValue());
        vakkenListView.setItems(studentnaam);
        List<Integer> inttest = FXCollections.observableArrayList(lijst.getAbsent());
        absentieListView.setItems((ObservableList) inttest);
    }

}
