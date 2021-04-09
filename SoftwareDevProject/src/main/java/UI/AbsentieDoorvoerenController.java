package UI;



import controllers.Manager;
import domeinKlassen.Les;
import domeinKlassen.Student;
import domeinKlassen.Vak;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import controllers.Utils;


public class AbsentieDoorvoerenController {
	public Label ingelogdPersoon;
	public Label misluktLabel;
	public DatePicker beginDatum;
	public DatePicker eindDatum;
	public TextField beginTijd;
	public TextField eindTijd;
	
    public void initialize() {	
    	this.ingelogdPersoon.setText(Manager.getInstance().getIngelogdStudent().getVoorNaam());
    }

    public void Home(ActionEvent actionEvent) {
    	Manager.getInstance().schrijfWeg();
    	
        Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();

        initialize();
    }
    
    public void opslaan(ActionEvent actionEvent) {
		Student student = Manager.getInstance().getIngelogdStudent();
		for(Vak vak: student.getKlas().getVakkenLijst()) {
			for(Les les: vak.getLessenLijst()) {
				if(((les.getDag().isAfter(beginDatum.getValue()) || (les.getDag().isEqual(beginDatum.getValue())) 
						&& ((les.getDag().isBefore(eindDatum.getValue())) || (les.getDag().isEqual(eindDatum.getValue())))) 
						&& Utils.compareTime(beginTijd.getText(), eindTijd.getText()) >= 0)) {
					student.setAbsent(les, student);
					System.out.println(les.toString());
				}
			}
		Button source = (Button)actionEvent.getSource();
        Stage stage2 = (Stage)source.getScene().getWindow();
        stage2.close();
    	}
    }
    
    public void begintijdTextField(ActionEvent actionevent) {
    	if(beginTijd.getText().equals(null)) {
    		this.misluktLabel.setText("Begintijd is leeg.");
    	} else if(!beginTijd.getText().matches("[0-2][0-9]:[0-5][0-9]")) {
    		this.misluktLabel.setText("Voer een geldige begintijd in.");
    	} else {
    		this.misluktLabel.setText(null);
    	}
    }
    
    public void eindtijdTextField(ActionEvent actionevent) {
    	if(eindTijd.getText().equals(null)) {
    		this.misluktLabel.setText("eindTijd is leeg.");
    	} else if(!beginTijd.getText().matches("[0-2][0-9]:[0-5][0-9]")) {
    		this.misluktLabel.setText("Voer een geldige eindtijd in.");
    	} else if(Integer.parseInt(beginTijd.getText().split(":")[0]) > Integer.parseInt(eindTijd.getText().split(":")[0]) && !beginTijd.getText().equals(null)) {
    		this.misluktLabel.setText("Eindtijd ligt voor begintijd");
    	} else if((Integer.parseInt(beginTijd.getText().split(":")[0]) == Integer.parseInt(eindTijd.getText().split(":")[0]) && !beginTijd.getText().equals(null)) 
    			&& Integer.parseInt(beginTijd.getText().split(":")[1]) > Integer.parseInt(eindTijd.getText().split(":")[1]) && !beginTijd.getText().equals(null)) {
    		this.misluktLabel.setText("Eindtijd ligt voor begintijd");
    	} else {
    		this.misluktLabel.setText(null);
    	}
    }
    
    public void begindatumDatePicker(ActionEvent actionEvent) {
		if(beginDatum.getValue().equals(null)) {
			this.misluktLabel.setText("Begindatum is leeg.");
		} else if(beginDatum.getValue().isBefore(LocalDate.now())) {
			this.misluktLabel.setText("Begindatum ligt in het verleden.");
		} else {
			this.misluktLabel.setText(null);
		}
    }
    
    public void einddatumDatePicker(ActionEvent actionEvent) {
    	if(beginDatum.getValue().equals(null)) {
    		this.misluktLabel.setText("Eindatum is leeg");
    	} else if(beginDatum.getValue().isAfter(eindDatum.getValue())) {
    		this.misluktLabel.setText("Einddatum ligt voor begindatum");
    	} else {
    		this.misluktLabel.setText(null);
    	}
    }
}
