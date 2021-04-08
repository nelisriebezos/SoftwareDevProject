package UI;



import controllers.Manager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AbsentieDoorvoerenController {
	public Label ingelogdPersoon;
	public Label misluktLabel;
	public DatePicker beginDatum;
	public DatePicker eindDatum;
	public TextField beginTijd;
	public TextField eindTijd;
	
    public void initialize() {	
    	ingelogdPersoon.setText(Manager.getInstance().getIngelogdStudent().getVoorNaam());
    }

    public void Home(ActionEvent actionEvent) {
    	Manager.getInstance().schrijfWeg();
    	
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();

        initialize();
    }
    
    public void opslaan(ActionEvent actionEvent) {
    	
    }
    
    public void einddatumDatePicker(ActionEvent actionEvent) throws Exception{
    	try {
    		if(beginDatum.getValue().equals(null)) {
    			misluktLabel.setText("Begindatum is leeg.");
    		}
    	} catch(RuntimeException e) {misluktLabel.setText("Begindatum is leeg. Vul de begindatum in en dan opnieuw de einddatum.");
    	System.out.println("begindatum is leeg. Vul de begindatum in en dan opnieuw de einddatum.");
    	}
    	if(beginDatum.getValue().isAfter(eindDatum.getValue())) {
    		misluktLabel.setText("Voer een einddatum in die verder is dan de begindatum.");
    	}
    	
    }
}
