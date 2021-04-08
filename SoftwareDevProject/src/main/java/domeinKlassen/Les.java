package domeinKlassen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Les implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String naam;
    private String beginTijd;
    private String eindTijd;
    private LocalDate dag;
    private Vak vak;
    private Rooster rooster;
    ArrayList<LesAbsentie> lesAbsentieLijst = new ArrayList<>();

    public Les(String naam, String beginTijd, String eindTijd, LocalDate dag, Vak vak) {
        this.naam = naam;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.dag = dag;
        this.vak = vak;
    }

    public String getNaam() {
        return this.naam;
    }

    public String getBeginTijd() {
        return this.beginTijd;
    }

    public String getEindTijd() {
        return this.eindTijd;
    }

    public LocalDate getDag() {
    	return this.dag;
    }
    
    public Vak getVak() {
        return this.vak;
    }
    
    public Rooster getRooster() {
		return this.rooster;
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
                les.getNaam()) && Objects.equals(getVak(), les.getVak());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNaam(), getBeginTijd(), getEindTijd(), getVak());
    }

    @Override
    public String toString() {
        return this.naam + " van: " + this.beginTijd + " tot: " + this.eindTijd;
    }
}
