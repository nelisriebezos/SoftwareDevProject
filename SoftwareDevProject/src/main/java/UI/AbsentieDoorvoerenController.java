package UI;

import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class AbsentieDoorvoerenController {
//	public Label ingelogdPersoon;
//	public DatePicker beginDatum;
//	public DatePicker eindDatum;
//	public TextField beginTijd;
//	public TextField eindTijd;
	
    public void initialize() {
    }

    public void Home(ActionEvent actionEvent) {
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();

        initialize();
    }
    
    public void opslaan(ActionEvent actionEvent) {
    	
    }
    
    
}
