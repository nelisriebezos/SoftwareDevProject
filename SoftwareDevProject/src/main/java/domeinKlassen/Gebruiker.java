package domeinKlassen;

import java.io.Serializable;
import java.util.Objects;

import controllers.Utils;

public class Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String emailAdres;
    protected String wachtwoord;
    protected String voorNaam;
    protected String achterNaam;

    public Gebruiker(String emailAdres, String wachtwoord, String voorNaam, String achterNaam) {
        this.emailAdres = emailAdres;
        this.wachtwoord = Utils.hashPassword(wachtwoord);
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
    }

    public String getEmailAdres() {
        return this.emailAdres;
    }

    public String getWachtwoord() {
        return this.wachtwoord;
    }

    public String getVoorNaam() {
        return this.voorNaam;
    }

    public String getAchterNaam() {
        return this.achterNaam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gebruiker)) return false;
        Gebruiker gebruiker = (Gebruiker) o;
        return Objects.equals(getEmailAdres(), gebruiker.getEmailAdres()) && Objects.equals(getWachtwoord(),
                gebruiker.getWachtwoord()) && Objects.equals(getVoorNaam(), gebruiker.getVoorNaam()) &&
                Objects.equals(getAchterNaam(), gebruiker.getAchterNaam());
    }

    @Override
    public String toString() {
        return this.emailAdres;
    }
}
