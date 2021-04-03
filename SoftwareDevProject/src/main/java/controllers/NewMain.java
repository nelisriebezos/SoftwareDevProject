package controllers;

import java.io.IOException;

//NewMain.java
public class NewMain {

	public static void main(String[] args) {
		try {
			ProjectMain.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}