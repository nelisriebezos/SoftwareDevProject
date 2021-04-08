package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Vak implements Serializable {

    private static final long serialVersionUID = 1L;

    private String naam;
    private List<Docent> docentenLijst = new ArrayList<>();
    private List<Klas> klassenLijst = new ArrayList<>();
    private List<Les> lessenLijst = new ArrayList<>();

    public Vak(String naam) {
        this.naam = naam;
    }
    
    public void addDocent(Docent docent) {
        this.docentenLijst.add(docent);
    }

    public void addKlas(Klas klas) {
        this.klassenLijst.add(klas);
    }

    public void addLes(Les les) {
        this.lessenLijst.add(les);
    }

    public void removeDocent(Docent docent) {
        this.docentenLijst.remove(docent);
    }

    public void removeKlas(Klas klas) {
        this.klassenLijst.remove(klas);
    }

    public void removeLes(Les les) {
        this.lessenLijst.remove(les);
    }

    public String getNaam() {
        return this.naam;
    }

    public List<Docent> getDocentenLijst() {
        return Collections.unmodifiableList(this.docentenLijst);
    }

    public List<Klas> getKlassenLijst() {
        return Collections.unmodifiableList(this.klassenLijst);
    }

    public List<Les> getLessenLijst() {
        return Collections.unmodifiableList(this.lessenLijst);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vak)) return false;
        Vak vak = (Vak) o;
        return Objects.equals(getNaam(), vak.getNaam()) && Objects.equals(getDocentenLijst(), vak.getDocentenLijst()) &&
                Objects.equals(getKlassenLijst(), vak.getKlassenLijst()) && Objects.equals(getLessenLijst(),
                vak.getLessenLijst());
    }

    @Override
    public String toString() {
        return this.naam;
    }
}
