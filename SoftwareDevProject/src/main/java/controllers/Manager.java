package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.Les;
import domeinKlassen.LesAbsentie;
import domeinKlassen.Rooster;
import domeinKlassen.SLB;
import domeinKlassen.Student;
import domeinKlassen.Vak;

public class Manager implements Serializable {
	
	private static final long serialVersionUID = -6613706280562535180L;
	
	private static final String filePath = "objecten.txt";
	
	private Student ingelogdStudent;
	private Docent ingelogdDocent;
	private Object ingelogdPersoon;

	private ArrayList<Student> studentenLijst = new ArrayList<>();
	private ArrayList<Docent> docentenLijst = new ArrayList<>();
	private ArrayList<Vak> vakkenLijst = new ArrayList<>();
	private ArrayList<Klas> klassenLijst = new ArrayList<>();
	private ArrayList<Les> lessenLijst = new ArrayList<>();
	private ArrayList<LesAbsentie> lesAbsentieLijst = new ArrayList<>();
	private ArrayList<Rooster> roosterLijst = new ArrayList<>();
	private ArrayList<SLB> slbLijst = new ArrayList<>();

	private static Manager manager;

	private Manager() {

	}

	public static Manager getInstance() {
		if (manager == null)
			manager = new Manager();
		return manager;
	}

	public void schrijfWeg() {
		try {
			FileWriter fw = new FileWriter(filePath, false);
			PrintWriter leegmaker = new PrintWriter(fw, false);
			leegmaker.flush();
			leegmaker.close();
			fw.close();
			
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectout = new ObjectOutputStream(fileOut);

			objectout.writeObject(Manager.getInstance());
			objectout.flush();
			objectout.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void leesIn() {
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			manager = (Manager) objectIn.readObject();
			objectIn.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void addStudent(Student s) {
		if (!studentenLijst.contains(s))
			studentenLijst.add(s);
	}
	
	public void addDocent(Docent d) {
		if (!docentenLijst.contains(d))
			docentenLijst.add(d);
	}
	
	public void addVak(Vak v) {
		if (!vakkenLijst.contains(v))
			vakkenLijst.add(v);
	}
	
	public void addKlas(Klas k) {
		if (!klassenLijst.contains(k))
			klassenLijst.add(k);
	}
	
	public void addLes(Les l) {
		if (!lessenLijst.contains(l))
			lessenLijst.add(l);
	}

	public void addlesAbsentie(LesAbsentie la) {
		if (!lesAbsentieLijst.contains(la))
			lesAbsentieLijst.add(la);
	}
	
	public void addRooster(Rooster r) {
		if (!roosterLijst.contains(r))
			roosterLijst.add(r);
	}
	
	public void addSLB(SLB slb) {
		if(!slbLijst.contains(slb))
			slbLijst.add(slb);
	}
	
	public Student getIngelogdStudent() {
		return ingelogdStudent;
	}
	
	public Docent getIngelogdDocent() {
		return ingelogdDocent;
	}
	
	public Object getIngelogdPersoon() {
		return ingelogdPersoon;
	}
	
	public ArrayList<Student> getStudentenLijst() {
		return studentenLijst;
	}
	
	public ArrayList<Docent> getDocentenLijst() {
		return docentenLijst;
	}
	
	public ArrayList<Vak> getVakkenLijst() {
		return vakkenLijst;
	}
	
	public ArrayList<Klas> getKlassenLijst() {
		return klassenLijst;
	}
	
	public ArrayList<Les> getLessenLijst() {
		return lessenLijst;
	}
	
	public ArrayList<LesAbsentie> getLesAbsentieLijst() {
		return lesAbsentieLijst;
	}
	
	public ArrayList<Rooster> getRoosterLijst() {
		return roosterLijst;
	}
	
	public ArrayList<SLB> getSlbLijst() {
		return slbLijst;
	}
	
	public static String getFilepath() {
		return filePath;
	}

	public void setIngelogdStudent(Student ingelogdStudent) {
		this.ingelogdStudent = ingelogdStudent;
	}

	public void setIngelogdDocent(Docent ingelogdDocent) {
		this.ingelogdDocent = ingelogdDocent;
	}

	public void setIngelogdPersoon(Object ingelogdPersoon) {
		this.ingelogdPersoon = ingelogdPersoon;
	}

	public void setStudentenLijst(ArrayList<Student> studentenLijst) {
		this.studentenLijst = studentenLijst;
	}

	public void setDocentenLijst(ArrayList<Docent> docentenLijst) {
		this.docentenLijst = docentenLijst;
	}

	public void setVakkenLijst(ArrayList<Vak> vakkenLijst) {
		this.vakkenLijst = vakkenLijst;
	}

	public void setKlassenLijst(ArrayList<Klas> klassenLijst) {
		this.klassenLijst = klassenLijst;
	}

	public void setLessenLijst(ArrayList<Les> lessenLijst) {
		this.lessenLijst = lessenLijst;
	}

	public void setLesAbsentieLijst(ArrayList<LesAbsentie> lesAbsentieLijst) {
		this.lesAbsentieLijst = lesAbsentieLijst;
	}

	public void setRoosterLijst(ArrayList<Rooster> roosterLijst) {
		this.roosterLijst = roosterLijst;
	}

	public void setSlbLijst(ArrayList<SLB> slbLijst) {
		this.slbLijst = slbLijst;
	}
}
