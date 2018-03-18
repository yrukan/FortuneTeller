package by.htp.bean;

public class Prediction {
	private String topic;
	private String value;
	
	public Prediction(){
		
	}
	
	public Prediction(String topic, String value) {
		super();
		this.topic = topic;
		this.value = value;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Prediction [predictionTopic=" + topic + ", predictionValue=" + value + "]";
	}
	
}
