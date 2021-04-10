package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controllers.Manager;

public class Student extends Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;

    private int leerlingNummer;
    private SLB slb;
    private Klas klas;
    private boolean isWelNietZiek = false;
    ArrayList<LesAbsentie> lesAbsentieLijst = new ArrayList<>();


    public Student(String emailAdres, String wachtwoord, String voorNaam, String achterNaam, int leerlingNummer) {
        super(emailAdres, wachtwoord, voorNaam, achterNaam);
        this.leerlingNummer = leerlingNummer;
    }

    public void setAbsent(Les les, Student stud) {
    	LesAbsentie l = new LesAbsentie();
    	l.setLes(les);
    	l.setStudent(stud);
    	
    	Boolean exists = false;
    	for (LesAbsentie la : this.lesAbsentieLijst) {
    		if (la.equals(l)) {
    			exists = true;
    		}
    	}
    	if (!exists) {
    		this.lesAbsentieLijst.add(l);
    	}
    	
    	Manager.getInstance().addlesAbsentie(l);
    }
    
    public boolean getAbsent(Les les) {
    	for (LesAbsentie la : lesAbsentieLijst) {
    		if (la.getLes().equals(les)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int getTotaalAbsentieAantal() {
    	if (lesAbsentieLijst == null) {
    		return 0;
    	}else {
    		return this.lesAbsentieLijst.size();
    	}
    }
    
    public int getGeselecteerdVakAbsentie(Vak vak) {
    	int vakAbsentie = 0;
    	for (LesAbsentie la : lesAbsentieLijst) {
    		if (la.getLes().getVak().equals(vak)) {
    			vakAbsentie += 1;
    		}
    	}
    	return vakAbsentie;
    }
 

    public SLB getSlb() {
		return slb;
	}

	public void setSlb(SLB slb) {
		this.slb = slb;
	}

	public int getLeerlingNummer() {
        return this.leerlingNummer;
    }

    public Klas getKlas() {
        return this.klas;
    }

    public void setKlas(Klas klas) {
        this.klas = klas;
    }

    public boolean getIsWelNietZiek() {
        return this.isWelNietZiek;
    }
    
    public List<Vak> getVakken() {
        return Collections.unmodifiableList(getKlas().getVakkenLijst());
    }

    public void setWelNietZiek(boolean welNietZiek) {
        this.isWelNietZiek = welNietZiek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getLeerlingNummer() == student.getLeerlingNummer();
    }

    @Override
    public String toString() {
        return this.voorNaam + " " + this.achterNaam;
    }
}
