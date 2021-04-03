package UI;

import domeinKlassen.Docent;
import domeinKlassen.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    public Button GeplandeAfwezigheidKnop;
    private boolean isDocent = true;



    public void initialize() {
        if (isDocent){
            GeplandeAfwezigheidKnop.setVisible(false);
        }
    }


    public void AbsentieBekijken(ActionEvent actionEvent) {
        if (isDocent){
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("AbsentieBekijkenDocenten.fxml"));
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
        else{
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("AbsentieBekijkenLeerling.fxml"));
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
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AbsentieDoorvoeren.fxml"));
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
