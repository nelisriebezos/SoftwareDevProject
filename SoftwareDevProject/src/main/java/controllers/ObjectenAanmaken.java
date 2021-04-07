package controllers;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.Les;
import domeinKlassen.Rooster;
import domeinKlassen.SLB;
import domeinKlassen.Student;
import domeinKlassen.Vak;

public class ObjectenAanmaken {
	public static void main(String[] args) throws FileNotFoundException {
		List<Student> studentenLijst14 = new ArrayList<>();
		List<Student> studentenLijst15 = new ArrayList<>();

		Vak OOP = new Vak("OOP");
		Vak OOAD = new Vak("OOAD");

		Klas SG14 = new Klas(14);
		Klas SG15 = new Klas(15);

		Student s1 = new Student("Gerard.Hartong@student.hu.nl", "sinterklaas364", "Gerard", "Harting", 1023045);
		Student s2 = new Student("Jelle.vanBroek@student.hu.nl", "kerstman", "Jelle", "van Broek", 1034839);
		Student s3 = new Student("Christa.Lange@student.hu.nl", "konijnenvoer", "Christa", "Lange", 1472890);
		Student s4 = new Student("Dante.Jawel@student.hu.nl", "watiseenwachtwoord", "Dante", "Jawel", 1432907);
		Student s5 = new Student("Sophie.Dielemans@student.hu.nl", "ditiseenwachtwoord", "Sophie", "Dielemans", 1234678);
		Student s6 = new Student("Ingmar.Boomstam@student.hu.nl", "ingmarisbest", "Ingmar", "Boomstam", 1094789);

		studentenLijst14.add(s1);
		studentenLijst14.add(s2);
		studentenLijst14.add(s3);
		studentenLijst15.add(s4);
		studentenLijst15.add(s5);
		studentenLijst15.add(s6);

		Docent d1 = new Docent("Karin.Haring@docent.hu.nl", "supersterkwachtwoord20", "Karin", "Haring", 4320832);
		Docent d2 = new Docent("Brian.Honing@docent.hu.nl", "eenmindersterkwachtwoord", "Brian", "Honing", 4321934);
		SLB slb1 = new SLB("Berend.Botje@docent.hu.nl", "woawoiewo", "Berend", "Botje");

		
		Les l1a = new Les("OOAD Les 1", "13:30", "15:30",LocalDate.now().plusDays(1) ,OOAD);
		Les l2a = new Les("OOAD Les 2", "13:30", "15:30",LocalDate.now().plusDays(3) ,OOAD);
		Les l3a = new Les("OOP les 1", "08:00", "10:00", LocalDate.now().plusDays(1), OOP);
		Les l4a = new Les("OOP les 2", "08:00", "10:00", LocalDate.now().plusDays(3), OOP);
		
		Les l1b = new Les("OOAD Les 1", "17:30", "20:30",LocalDate.now() ,OOAD);
		Les l2b = new Les("OOAD Les 2", "17:30", "20:30",LocalDate.now().plusDays(1) ,OOAD);
		Les l3b = new Les("OOP les 1", "10:00", "12:00", LocalDate.now(), OOP);
		Les l4b = new Les("OOP les 2", "10:00", "12:00", LocalDate.now().plusDays(1), OOP);
		
		Rooster kr1 = new Rooster(SG14);
		Rooster kr2 = new Rooster(SG15);
		Rooster dr1 = new Rooster(d1);
		Rooster dr2 = new Rooster(d2);
		
		kr1.voegLesToe(l1a);
		kr1.voegLesToe(l2a);
		kr1.voegLesToe(l3a);
		kr1.voegLesToe(l4a);
		
		l1a.setRooster(kr1);
		l2a.setRooster(kr1);
		l3a.setRooster(kr1);
		l4a.setRooster(kr1);
		
		l1b.setRooster(kr2);
		l2b.setRooster(kr2);
		l3b.setRooster(kr2);
		l4b.setRooster(kr2);
		
		
		kr2.voegLesToe(l1b);
		kr2.voegLesToe(l2b);
		kr2.voegLesToe(l3b);
		kr2.voegLesToe(l4b);
		
		dr1.voegLesToe(l3a);
		dr1.voegLesToe(l4a);
		dr1.voegLesToe(l3b);
		dr1.voegLesToe(l4b);
		
		dr2.voegLesToe(l1a);
		dr2.voegLesToe(l2a);
		dr2.voegLesToe(l1b);
		dr2.voegLesToe(l2b);
		
		OOP.addDocent(d1);
		OOP.addKlas(SG14);
		OOP.addKlas(SG15);

		OOAD.addDocent(d2);
		OOAD.addKlas(SG14);
		OOAD.addKlas(SG15);

		SG14.addStudent(s1);
		SG14.addStudent(s2);
		SG14.addStudent(s3);
		SG14.addDocent(d1);
		SG14.addDocent(d2);
		SG14.setSlb(slb1);
		SG14.addVak(OOP);
		SG14.addVak(OOAD);
		SG14.setRooster(kr1);

		SG15.addStudent(s4);
		SG15.addStudent(s5);
		SG15.addStudent(s6);
		SG15.addDocent(d1);
		SG15.addDocent(d2);
		SG15.setSlb(slb1);
		SG15.addVak(OOP);
		SG15.addVak(OOAD);
		SG15.setRooster(kr2);

		for (Student s : studentenLijst14) {
			s.setKlas(SG14);
		}
		for (Student s : studentenLijst15) {
			s.setKlas(SG15);
		}

		d1.addKlas(SG14);
		d1.addKlas(SG15);
		d1.addVak(OOP);
		d1.setRooster(dr1);
		
		d2.addKlas(SG15);
		d2.addVak(OOAD);
		d2.setRooster(dr2);
		
		slb1.addStudent(s1);
		slb1.addStudent(s2);

		
		Manager manager = Manager.getInstance();
		manager.voegVakToe(OOP);
		manager.voegVakToe(OOAD);
		manager.voegKlasToe(SG14);
		manager.voegKlasToe(SG15);
		manager.voegStudentToe(s1);
		manager.voegStudentToe(s2);
		manager.voegStudentToe(s3);
		manager.voegStudentToe(s4);
		manager.voegStudentToe(s5);
		manager.voegStudentToe(s6);
		manager.voegDocentToe(d1);
		manager.voegDocentToe(d2);
		manager.voegSLBToe(slb1);
		manager.voegRoosterToe(kr1);
		manager.voegRoosterToe(kr2);
		manager.voegRoosterToe(dr1);
		manager.voegRoosterToe(dr2);

		manager.schrijfWeg();
	}

}
