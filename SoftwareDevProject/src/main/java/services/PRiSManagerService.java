//package services;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import domeinKlassen.Docent;
//import domeinKlassen.Student;
//
//public class PRiSManagerService implements Serializable {
//	private List<Docent> alleDocenten = new ArrayList<>();
//	private List<Student> alleStudenten = new ArrayList<>();
//
//	private static PRiSManagerService theManager;
//
//	private PRiSManagerService() {
//
//	}
//
//	public static PRiSManagerService getInstance() {
//		if (theManager == null)
//			theManager = new PRiSManagerService();
//		return theManager;
//	}
//
//	public boolean schrijfWeg() {
//		oos.writeObject(theManager.getInstance());
//		return false;
//	}
//
//	public boolean leesIn() {
//		// fis en ois
//		theManager = (PRiSManagerService) OIS.readobject();
//		return true;
//	}
//
//	public boolean voegStudentToe(Student s) {
//		if (!alleStudenten.contains(s))
//			return alleStudenten.add(s);
//		return false;
//	}
//
//	public static void main(String[] args) {
//			PRiSManagerService manager = PRiSManagerService.getInstance();
//			manager.voegStudentToe(new Student(Peitje))
//			
//		}
//}
