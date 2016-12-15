package model;

public class MostProfitClients {
	private String client;
	private float amount;
	private int ordersNum;
	private double average;

	public MostProfitClients(String client, double average) {
		super();
		this.client = client;
		this.average = average;
	}

	public MostProfitClients(String client, int ordersNum) {
		super();
		this.client = client;
		this.ordersNum = ordersNum;
	}
	
	

	public MostProfitClients(String client, float amount) {
		super();
		this.client = client;
		this.amount = amount;
	}

	public int getOrdersNum() {
		return ordersNum;
	}

	public void setOrdersNum(int ordersNum) {
		this.ordersNum = ordersNum;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
