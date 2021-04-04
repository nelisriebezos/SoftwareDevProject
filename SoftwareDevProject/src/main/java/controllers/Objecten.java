package controllers;

import java.util.ArrayList;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.Student;
import domeinKlassen.Vak;

public class Objecten {
	static Object ingelogdPersoon;
	static ArrayList<Student> studentenLijst = new ArrayList<>();
	static ArrayList<Docent> docentenLijst = new ArrayList<>();
	static ArrayList<Vak> vakkenLijst = new ArrayList<>();
	static ArrayList<Klas> klassenLijst = new ArrayList<>();
	
	public static void LijstSetter(ArrayList<Object> objl) {
		for (Object o : objl) {
			if (o instanceof Student) {
				studentenLijst.add((Student) o);
			}
			if (o instanceof Docent) {
				docentenLijst.add((Docent) o);
			}
			if (o instanceof Vak) {
				vakkenLijst.add((Vak) o);
			}
			if (o instanceof Klas) {
				klassenLijst.add((Klas) o);
			}
		}
	}
	
	public static ArrayList<Student> getStudentenLijst() {
		return studentenLijst;
	}

	public static ArrayList<Docent> getDocentenLijst() {
		return docentenLijst;
	}

	public static ArrayList<Vak> getVakkenLijst() {
		return vakkenLijst;
	}

	public static ArrayList<Klas> getKlassenLijst() {
		return klassenLijst;
	}

	public static Object getIngelogdPersoon() {
		return ingelogdPersoon;
	}

	public static void setIngelogdPersoon(Object ingelogdPersoon) {
		Objecten.ingelogdPersoon = ingelogdPersoon;
	}
	
	
}
