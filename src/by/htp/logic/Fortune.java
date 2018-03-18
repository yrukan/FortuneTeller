package by.htp.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import by.htp.bean.Client;
import by.htp.bean.ClientScanner;
import by.htp.bean.FortuneTeller;
import by.htp.bean.Prediction;

public class Fortune {

	private FortuneTeller fortune = new FortuneTeller();
	private Set<Client> clientsSet = new HashSet<>();
	private Map<Client, Prediction> predictions = new HashMap<>();
	private ClientScanner scan = new ClientScanner();

	public void startProcess() {
		do {
			Client client = fortune.setClient();
			clientsSet.add(client);
			int count = calcPredictionNumbersPerDayForClient(client);
			checkPredictionNumbersPerDayForClient(count, client);
		} while (scan.selectExit() != 0);

	}

	public int calcPredictionNumbersPerDayForClient(Client client){
		int count = 0;
		for (Client cl : clientsSet) {
			if (cl.hashCode() == client.hashCode())
				count = count + 1;
		}
		return count;
	}
	
	public void checkPredictionNumbersPerDayForClient(int count, Client client){
		if (count < 2) {
			clientsSet.add(client);
			Prediction prediction = fortune.setPrediction();
			predictions.put(client, prediction);
		} else
			System.out.println("Sorry, you can't get predictions twice a day for the same client");
	}
	
	public void printPredictions() {
		for (Entry<Client, Prediction> pr : predictions.entrySet())
			System.out.println(pr);
	}

}