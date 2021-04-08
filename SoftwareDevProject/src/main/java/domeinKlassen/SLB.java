package domeinKlassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SLB extends Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Student> studentenLijst = new ArrayList<>();

    public SLB(String emailAdres, String wachtwoord, String voorNaam, String achterNaam) {
        super(emailAdres, wachtwoord, voorNaam, achterNaam);
    }
    
    public boolean addStudent(Student student) {
        if (!studentenLijst.contains(student)) {
            studentenLijst.add(student);
            return true;
        }
        return false;
    }

    public List<Student> getStudentenLijst() {
        return Collections.unmodifiableList(studentenLijst);
    }

    public void setStudentenLijst(List<Student> studentenLijst) {
        this.studentenLijst = studentenLijst;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
