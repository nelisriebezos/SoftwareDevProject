package domeinKlassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rooster {
    private List<Les> lessenLijst = new ArrayList<>();

    public Rooster() {

    }

    public List<Les> getLessenLijst() {
        return Collections.unmodifiableList(lessenLijst);
    }

    public void addLes(Les les) {
        this.lessenLijst.add(les);
    }

    public void removeLes(Les les) {
        this.lessenLijst.remove(les);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rooster)) return false;
        Rooster rooster = (Rooster) o;
        return Objects.equals(getLessenLijst(), rooster.getLessenLijst());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLessenLijst());
    }

    @Override
    public String toString() {
        return "lessenLijst = " + this.lessenLijst;
    }
}
