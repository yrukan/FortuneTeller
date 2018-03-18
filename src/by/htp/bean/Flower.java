package by.htp.bean;

import java.util.LinkedList;
import java.util.List;

public class Flower {

	List<Petal> petals;

	public Flower() {
		super();
		this.petals = new LinkedList<>();
	}

	public Flower(List<Petal> petals) {
		super();
		this.petals = petals;
	}

	public List<Petal> getPetals() {
		return petals;
	}
	
	public String getPetalPrediction(int position) {
		position = this.calcListPosition(position);
		String prediction = this.getPetals().get(position).getPrediction();
		return prediction;
	}
		
	public void setPetals(List<Petal> petals) {
		this.petals = petals;
	}

	public void removePetal(int position) {
		position = this.calcListPosition(position);
		this.petals.remove(position);
	}

	public void addPetal(int position, Petal petal) {
		this.petals.add(position, petal);
	}

	public void addPetal(String prediction) {
		Petal petal = new Petal();
		petal.setPrediction(prediction);
		this.petals.add(petal);
	}

	public Flower addFlower(String[] predictions) {
		for (;;) {
			int n = (int) (Math.random() * 10);
			if (n > 0 && n < predictions.length) {
				for (int i = 0; i < n; i++) {
					this.addPetal(predictions[i]);
				}
				break;
			}
		}
		return this;
	}
	
	public void printFlower() {
		for (Petal s : this.petals) {
			System.out.println(s.getPrediction());
		}		
	}

	private int calcListPosition(int position){
		if(position > this.getPetals().size())
			return position % this.getPetals().size();
		else return position;
	}
}