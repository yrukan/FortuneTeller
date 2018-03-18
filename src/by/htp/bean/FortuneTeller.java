package by.htp.bean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FortuneTeller {

	private Map<String, Flower> predictions = new HashMap<>();
	private LinkedList<Flower> flowers = new LinkedList<>();
	private static int FLOWERS_NUMBER = 10;
	private ClientScanner scan = new ClientScanner();

	private static String love[] = { "Sorry... Not today", "Romantic evening today", "Huge love is coming",
			"Romantic holidays" };
	private static String work[] = { "Good", "Not good", "Acceptable", "Bad", "Not bad" };
	private static String finance[] = { "It's not time to increase your salary", "You will be a billioner", "Your salary will be increased in a month", "Don't open a credit account this year", "You should open a deposit" };

	public FortuneTeller() {
		this.setFlowers();
	}

	public Client setClient() {
		Client client = new Client();

		client.setName(scan.enterName());
		client.setSurname(scan.enterSurname());

		return client;
	}

	public Prediction setPrediction() {
		Prediction prediction = new Prediction();
		int choice = scan.selectTopic();
		if (choice != 0) {
			prediction.setTopic(this.getTopicName(choice));
			prediction.setValue(this.generatePrediction(choice));
		}
		return prediction;
	}

	public Flower selectFlowerByTopic(int choice) {
		Flower fl = null;
		switch (choice) {
		case 1: {
			fl = this.predictions.get("Love");
			this.predictions.remove("Love");
		}
			break;
		case 2: {
			fl = this.predictions.get("Work");
			this.predictions.remove("Work");
		}
		case 3: {
			fl = this.predictions.get("Finance");
			this.predictions.remove("Finance");
		}
			break;
		case 0:
			break;
		default:
			break;
		}
		return fl;
	}

	public String getTopicName(int choice) {
		String str = null;
		switch (choice) {
		case 1: {
			str = "Love";
		}
			break;
		case 2: {
			str = "Work";
		}
		case 3: {
			str = "Finance";
		}
			break;
		case 0:
			break;
		default:
			break;
		}
		return str;
	}

	public String generatePrediction(int choice) {

		Flower flower = this.selectFlowerByTopic(choice);
		int n = (int) (Math.random() * 10);
		String prediction = null;

		if (flower != null)
			prediction = getPrediction(flower, n);
		System.out.println("Your prediction is: " + prediction);
		return prediction;
	}

	private void setFlowers() {
		int flowerNum = 0;
		while (flowerNum < FLOWERS_NUMBER) {
			flowerNum = this.setFlowerPredictions("Love", love, flowerNum);
			flowerNum = this.setFlowerPredictions("Work", work, flowerNum);
			flowerNum = this.setFlowerPredictions("Finance", finance, flowerNum);
		}
		this.flowers.addAll(this.predictions.values());
	}

	private int setFlowerPredictions(String topic, String[] predictionValues, int flowerNum) {
		Flower fl = new Flower();
		this.predictions.put(topic, fl.addFlower(predictionValues));
		int num = flowerNum + 1;
		return num;
	}

	private String getPrediction(Flower flower, int n) {
		String prediction = "No flowers with petals";
		if (flower.getPetals() != null) {
			prediction = flower.getPetalPrediction(n);
			flower.removePetal(n);
		}
		return prediction;
	}

}
