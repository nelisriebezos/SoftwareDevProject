package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ControllerMethoden {
	private static final String filePath = "objecten.txt";

	public static String getFilePath() {
		return filePath;
	}
	
	public static ArrayList<Object> writerObject() {
		ArrayList<Object> objectenLijst = new ArrayList<>();
		objectenLijst.add(Objecten.getStudentenLijst());
		objectenLijst.add(Objecten.getDocentenLijst());
		objectenLijst.add(Objecten.getVakkenLijst());
		objectenLijst.add(Objecten.getKlassenLijst());
		objectenLijst.add(Objecten.getLessenLijst());
		objectenLijst.add(Objecten.getLesAbsentieLijst());
		objectenLijst.add(Objecten.getRoosterLijst());
		objectenLijst.add(Objecten.getSlbLijst());
		
		return objectenLijst;
	}

	public static void writeObjectToFile(Object serObj) {
		try {
			PrintWriter leegmaker = new PrintWriter(filePath);
			leegmaker.close();
			
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectout = new ObjectOutputStream(fileOut);

			objectout.writeObject(serObj);
			objectout.flush();
			objectout.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public Object readObjectFromFIle(String filePath) {
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			ArrayList<Object> objlst = (ArrayList<Object>) objectIn.readObject();
			objectIn.close();
			return objlst;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
