package controllers;

import java.util.ArrayList;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.Les;
import domeinKlassen.LesAbsentie;
import domeinKlassen.Rooster;
import domeinKlassen.SLB;
import domeinKlassen.Student;
import domeinKlassen.Vak;

public class Objecten {
	static Student ingelogdStudent;
	static Docent ingelogdDocent;
	static Object ingelogdPersoon;
	static ArrayList<Student> studentenLijst = new ArrayList<>();
	static ArrayList<Docent> docentenLijst = new ArrayList<>();
	static ArrayList<Vak> vakkenLijst = new ArrayList<>();
	static ArrayList<Klas> klassenLijst = new ArrayList<>();
	static ArrayList<Les> lessenLijst = new ArrayList<>();
	static ArrayList<LesAbsentie> lesAbsentieLijst = new ArrayList<>();
	static ArrayList<Rooster> roosterLijst = new ArrayList<>();
	static ArrayList<SLB> slbLijst = new ArrayList<>();

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
			if (o instanceof Les) {
				lessenLijst.add((Les) o);
			}
			if (o instanceof LesAbsentie) {
				lesAbsentieLijst.add((LesAbsentie) o);
			}
			if (o instanceof Rooster) {
				roosterLijst.add((Rooster) o);
			}
			if (o instanceof SLB) {
				slbLijst.add((SLB) o);
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
	
	public static ArrayList<Les> getLessenLijst() {
		return lessenLijst;
	}

	public static ArrayList<LesAbsentie> getLesAbsentieLijst() {
		return lesAbsentieLijst;
	}

	public static ArrayList<Rooster> getRoosterLijst() {
		return roosterLijst;
	}

	public static ArrayList<SLB> getSlbLijst() {
		return slbLijst;
	}

	public static Object getIngelogdPersoon() {
		return ingelogdPersoon;
	}
	
	public static void addLesAbsentie(LesAbsentie la) {
		lesAbsentieLijst.add(la);
	}
	
	public static void setIngelogdStudent(Student ingelogdStudent) {
		Objecten.ingelogdStudent = ingelogdStudent;
	}

	public static void setIngelogdDocent(Docent ingelogdDocent) {
		Objecten.ingelogdDocent = ingelogdDocent;
	}

	public static Student getIngelogdStudent() {
		return ingelogdStudent;
	}

	public static Docent getIngelogdDocent() {
		return ingelogdDocent;
	}
	
	

}
