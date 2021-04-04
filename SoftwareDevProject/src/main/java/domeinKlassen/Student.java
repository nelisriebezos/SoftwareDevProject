package domeinKlassen;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Student extends Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Student destudent;
    public static void setStudent(Student student) {
        destudent = student;
    }
    public static Student getStudent() {
        return destudent;
    }
    private int leerlingNummer;
    private Klas klas;
    private boolean isWelNietZiek;
    private int absent = 0;

    public Student(String emailAdres, String wachtwoord, String voorNaam, String achterNaam, int leerlingNummer) {
        super(emailAdres, wachtwoord, voorNaam, achterNaam);
        this.leerlingNummer = leerlingNummer;
    }

    public int getAbsent(){return absent;}

    public void verhoogAbsent() {absent += 1;}

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
