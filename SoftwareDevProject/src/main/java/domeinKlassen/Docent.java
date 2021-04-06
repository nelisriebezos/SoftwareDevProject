package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Docent extends Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;

    private int docentNummer;
    private Rooster rooster;
    private List<Klas> klassenLijst = new ArrayList<>();
    private List<Vak> vakkenLijst = new ArrayList<>();

    public Docent(String emailAdres, String wachtwoord, String voorNaam, String achterNaam, int docentNummer) {
        super(emailAdres, wachtwoord, voorNaam, achterNaam);
        this.docentNummer = docentNummer;
    }

    public int getDocentNummer() {
        return this.docentNummer;
    }

    public List<Klas> getKlassenLijst() {
        return Collections.unmodifiableList(klassenLijst);
    }

    public List<Vak> getVakkenLijst() {
        return Collections.unmodifiableList(vakkenLijst);
    }

    public void addKlas(Klas klas) {
        this.klassenLijst.add(klas);
    }

    public void addVak(Vak vak) {
        this.vakkenLijst.add(vak);
    }

    public void removeKlas(Klas klas) {
        this.klassenLijst.remove(klas);
    }

    public void removeVak(Vak vak) {
        this.vakkenLijst.remove(vak);
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
        if (!(o instanceof Docent)) return false;
        if (!super.equals(o)) return false;
        Docent docent = (Docent) o;
        return getDocentNummer() == docent.getDocentNummer() && Objects.equals(getKlassenLijst(),
                docent.getKlassenLijst()) && Objects.equals(getVakkenLijst(), docent.getVakkenLijst());
    }

    @Override
    public String toString() {
        return "Emailadres " + super.emailAdres + " docentnummer: " + this.docentNummer;
    }
}
