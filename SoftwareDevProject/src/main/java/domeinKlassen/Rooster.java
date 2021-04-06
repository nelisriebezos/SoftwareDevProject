package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;

public class Rooster implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Docent docent;
	private Klas klas;
	ArrayList<Les> lessenLijst = new ArrayList<>();
	
	public Rooster(Object eigenaar) {
		if (eigenaar instanceof Klas) {
			this.klas = (Klas) eigenaar;
		}
		if (eigenaar instanceof Docent) {
			this.docent = (Docent) eigenaar;
		}
	}
	
	public void voegLesToe(Les l) {
		this.lessenLijst.add(l);
	}

	public Docent getDocent() {
		return docent;
	}

	public void setDocent(Docent docent) {
		this.docent = docent;
	}

	public Klas getKlas() {
		return klas;
	}

	public void setKlas(Klas klas) {
		this.klas = klas;
	}

	public ArrayList<Les> getLessenLijst() {
		return lessenLijst;
	}

	public void setLessenLijst(ArrayList<Les> lessenLijst) {
		this.lessenLijst = lessenLijst;
	}
	
	
}
