package controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Hex;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.SLB;
import domeinKlassen.Student;
import domeinKlassen.Vak;

public class ObjectenAanmaken {
	public static void main(String[] args) throws FileNotFoundException {
		ControllerMethoden objectIO = new ControllerMethoden();
		List<Student> studentenLijst14 = new ArrayList<>();
		List<Student> studentenLijst15 = new ArrayList<>();
		List<Object> objectenLijst = new ArrayList<Object>();

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

		SG15.addStudent(s4);
		SG15.addStudent(s5);
		SG15.addStudent(s6);
		SG15.addDocent(d1);
		SG15.addDocent(d2);
		SG15.setSlb(slb1);
		SG15.addVak(OOP);
		SG15.addVak(OOAD);

		for (Student s : studentenLijst14) {
			s.setKlas(SG14);
		}
		for (Student s : studentenLijst15) {
			s.setKlas(SG14);
		}

		d1.addKlas(SG14);
		d1.addKlas(SG15);
		d1.addVak(OOP);
		d2.addKlas(SG15);
		d2.addVak(OOAD);
		slb1.addStudent(s1);
		slb1.addStudent(s2);

		objectenLijst.add(OOP);
		objectenLijst.add(OOAD);
		objectenLijst.add(SG14);
		objectenLijst.add(SG15);
		objectenLijst.add(s1);
		objectenLijst.add(s2);
		objectenLijst.add(s3);
		objectenLijst.add(s4);
		objectenLijst.add(s5);
		objectenLijst.add(s6);
		objectenLijst.add(d1);
		objectenLijst.add(d2);
		objectenLijst.add(slb1);

		objectIO.writeObjectToFile(objectenLijst);
	}

}
