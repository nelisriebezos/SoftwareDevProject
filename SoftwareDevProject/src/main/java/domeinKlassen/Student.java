package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;

    private int leerlingNummer;
    private Klas klas;
    private boolean isWelNietZiek;
    ArrayList<LesAbsentie> lesAbsentieLijst = new ArrayList<>();


    public Student(String emailAdres, String wachtwoord, String voorNaam, String achterNaam, int leerlingNummer) {
        super(emailAdres, wachtwoord, voorNaam, achterNaam);
        this.leerlingNummer = leerlingNummer;
    }

    public void setAbsent(Les les, Student stud) {
    	LesAbsentie l = new LesAbsentie();
    	l.setLes(les);
    	l.setStudent(stud);
    	lesAbsentieLijst.add(l);
    }
    
    public int getAbsentieAantal() {
    	if (lesAbsentieLijst == null) {
    		return 0;
    	}else {
    		return lesAbsentieLijst.size();
    	}
    	
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

    public void setWelNietZiek(boolean welNietZiek) {
        this.isWelNietZiek = welNietZiek;
    }

    public List<Vak> getVakken() {
        return Collections.unmodifiableList(getKlas().getVakkenLijst());
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
        return "Leerlingnummer: " + this.leerlingNummer + " Emailadres: " + super.emailAdres;
    }
}
