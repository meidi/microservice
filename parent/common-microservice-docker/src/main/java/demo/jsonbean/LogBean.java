package demo.jsonbean;

import demo.jsonbean.consumer.Consumer;

public class LogBean {
	
	private String client_ip;
	
	private Consumer consumer;

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	
	

}
