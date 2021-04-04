package controllers;

import java.io.IOException;

public class ProjectMain {

	public static void main(String[] args) {
		try {
			Initializer.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}