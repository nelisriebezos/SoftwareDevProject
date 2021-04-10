package domeinKlassen;

import java.io.Serializable;

public class LesAbsentie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Student student;
	private Les les;

	public Student getStudent() {
		return this.student;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LesAbsentie other = (LesAbsentie) obj;
		if (les == null) {
			if (other.les != null)
				return false;
		} else if (!les.equals(other.les))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	
	
}
