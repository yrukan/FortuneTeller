package by.htp.runner;

import by.htp.logic.Fortune;

public class MainApp {

	public static void main(String[] args) {

		Fortune fortune = new Fortune();

		fortune.startProcess();
		fortune.printPredictions();

	}

}