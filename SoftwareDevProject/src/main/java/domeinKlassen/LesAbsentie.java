package domeinKlassen;

import java.io.Serializable;

public class LesAbsentie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Student student;
	private Les les;

	public Student getStudent() {
		return student;
	}
	
	public Les getLes() {
		return les;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setLes(Les les) {
		this.les = les;
	}
	
	
}
