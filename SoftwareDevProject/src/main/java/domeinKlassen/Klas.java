package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Klas implements Serializable {

    private static final long serialVersionUID = 1L;

    private int klasNummer;
    private Rooster rooster;
    private List<Student> studentenLijst = new ArrayList<>();
    private List<Docent> docentenLijst = new ArrayList<>();
    private List<Vak> vakkenLijst = new ArrayList<>();

    public Klas(int klasNummer) {
        this.klasNummer = klasNummer;
    }
    
    public void addStudent(Student student) {
        this.studentenLijst.add(student);
    }

    public void addDocent(Docent docent) {
        this.docentenLijst.add(docent);
    }

    public void addVak(Vak vak) {
        this.vakkenLijst.add(vak);
    }

    public void removeStudent(Student student) {
        this.studentenLijst.remove(student);
    }

    public void removeDocent(Docent docent) {
        this.docentenLijst.remove(docent);
    }

    public void removeVak(Vak vak) {
        this.vakkenLijst.remove(vak);
    }

    public int getKlasNummer() {
        return this.klasNummer;
    }

    public List<Student> getStudentenLijst() {
        return Collections.unmodifiableList(this.studentenLijst);
    }

    public List<Docent> getDocentenLijst() {
        return Collections.unmodifiableList(this.docentenLijst);
    }

    public List<Vak> getVakkenLijst() {
        return Collections.unmodifiableList(this.vakkenLijst);
    }
    
    public Rooster getRooster() {
		return rooster;
	}

	public void setRooster(Rooster rooster) {
		this.rooster = rooster;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klas)) return false;
        Klas klas = (Klas) o;
        return getKlasNummer() == klas.getKlasNummer() &&
                Objects.equals(getStudentenLijst(), klas.getStudentenLijst()) && Objects.equals(getDocentenLijst(),
                klas.getDocentenLijst()) && Objects.equals(getVakkenLijst(), klas.getVakkenLijst());
    }

    @Override
    public String toString() {
        return "Klasnummer: " + this.klasNummer;
    }
}
