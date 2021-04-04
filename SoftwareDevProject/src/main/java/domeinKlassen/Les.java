package domeinKlassen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Les {
    private String naam;
    private LocalDateTime beginTijd;
    private LocalDateTime eindTijd;
    private Vak vak;
    private Rooster rooster;
    ArrayList<LesAbsentie> lesabsentieLijst = new ArrayList<>();

    public Les(String naam, LocalDateTime beginTijd, LocalDateTime eindTijd, Vak vak, Rooster rooster) {
        this.naam = naam;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.vak = vak;
        this.rooster = rooster;
    }

    public String getNaam() {
        return this.naam;
    }

    public LocalDateTime getBeginTijd() {
        return this.beginTijd;
    }

    public LocalDateTime getEindTijd() {
        return this.eindTijd;
    }

    public Vak getVak() {
        return this.vak;
    }

    public Rooster getRooster() {
        return this.rooster;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeginTijd(LocalDateTime beginTijd) {
        this.beginTijd = beginTijd;
    }

    public void setEindTijd(LocalDateTime eindTijd) {
        this.eindTijd = eindTijd;
    }

    public void setVak(Vak vak) {
        this.vak = vak;
    }

    public void setRooster(Rooster rooster) {
        this.rooster = rooster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Les)) return false;
        Les les = (Les) o;
        return getBeginTijd() == les.getBeginTijd() && getEindTijd() == les.getEindTijd() && Objects.equals(getNaam(),
                les.getNaam()) && Objects.equals(getVak(), les.getVak()) && Objects.equals(getRooster(),
                les.getRooster());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNaam(), getBeginTijd(), getEindTijd(), getVak(), getRooster());
    }

    @Override
    public String toString() {
        return this.naam + " van: " + this.beginTijd + " tot: " + this.eindTijd + " over: ";
    }
}
