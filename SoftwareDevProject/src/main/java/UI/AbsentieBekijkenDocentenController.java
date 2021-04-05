package UI;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbsentieBekijkenDocentenController {
    private Docent lijst = Docent.getDocent();
    public ComboBox klassenComboBox;
    public ComboBox kiesLeerlingComboBox;
    public ListView absentListView;
    public ListView leerlingListView;

    public void initialize(){
        List<Klas> klas = this.lijst.getKlassenLijst();
        klassenComboBox.setItems(FXCollections.observableList(klas));
    }



    public void Home(ActionEvent actionEvent) throws IOException {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
    }

    public void BekijkLeerlingButton(ActionEvent actionEvent) {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AbsentieBekijkenLeerling.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("Het bestand kan niet gevonden worden.");
        }

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        initialize();
    }

    public void kiesLeerlingOnAction(ActionEvent actionEvent) {
        ObservableList<Object> studentnaam= FXCollections.observableArrayList();
        List<Integer> inttest = FXCollections.observableArrayList();
        Klas klas = (Klas) klassenComboBox.getValue();
        for(Student s1: klas.getStudentenLijst()){
         studentnaam.add(s1.getVoorNaam());
         inttest.add(s1.getAbsentieAantal());
        }
        kiesLeerlingComboBox.setItems(studentnaam);
        absentListView.setItems((ObservableList) inttest);
        leerlingListView.setItems(FXCollections.observableArrayList(studentnaam));
    }

    public void AbsentieWijzigenOnAction(ActionEvent actionEvent) {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AbsentieWijzigen.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("Het bestand kan niet gevonden worden.");
        }

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        initialize();
    }
    }
