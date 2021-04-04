package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class ControllerMethoden {
	private static final String filePath = "objecten.txt";

	public static String getFilePath() {
		return filePath;
	}

	public void writeObjectToFile(Object serObj) {
		try {
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
