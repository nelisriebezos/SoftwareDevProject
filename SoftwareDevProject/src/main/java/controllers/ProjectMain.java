package controllers;
import domeinKlassen.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import UI.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;


public class ProjectMain extends Application{
    public static void main(String[] args) throws IOException {
        Vak OOP = new Vak("OOP");
        Vak OOAD = new Vak("OOAD");

        Klas SG14 = new Klas(14);
        Klas SG15 = new Klas(15);
        SG14.addVak(OOP);
        SG14.addVak(OOAD);

        Student s1 = new Student("Gerard.Hartong@student.hu.nl", "sinterklaas364", "Gerard", "Harting", 1023045);
        Student s2 = new Student("Jelle.vanBroek@student.hu.nl", "kerstman", "Jelle", "van Broek", 1034839);
        Student s3 = new Student("Christa.Lange@student.hu.nl", "konijnenvoer", "Christa", "Lange", 1472890);
        Student s4 = new Student("Dante.Jawel@student.hu.nl", "watiseenwachtwoord", "Dante", "Jawel", 1432907);
        Student s5 = new Student("Sophie.Dielemans@student.hu.nl", "ditiseenwachtwoord", "Sophie", "Dielemans", 1234678);
        Student s6 = new Student("Ingmar.Boomstam@student.hu.nl", "ingmarisbest", "Ingmar", "Boomstam", 1094789);


        Docent d1 = new Docent("Karin.Haring@docent.hu.nl", "supersterkwachtwoord20", "Karin", "Haring", 4320832);
        d1.addKlas(SG14);
        d1.addKlas(SG15);
        d1.addVak(OOP);

        Docent d2 = new Docent("Brian.Honing@docent.hu.nl", "eenmindersterkwachtwoord", "Brian", "Honing", 4321934);
        d2.addKlas(SG15);
        d2.addVak(OOAD);

        SLB slb1 = new SLB("Berend.Botje@docent.hu.nl", "woawoiewo", "Berend", "Botje");
        SG15.addStudent(s1);
        SG14.addStudent(s2);
        SG14.addStudent(s3);
        Docent.setDocent(d1);
        Student.setStudent(s1);
        launch(args);
    }


    public void start(Stage stage) throws Exception {
        String fxmlPagina = "/UI/login.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
        Parent root = loader.load();
        stage.setTitle("Home");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
