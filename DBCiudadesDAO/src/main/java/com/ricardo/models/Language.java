package com.ricardo.models;

public class Language {
	private String name;
	private boolean isOfficial;
	private double percentage;
	
	public Language(String name, boolean isOfficial, double percentage) {
		super();
		this.name = name;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
}
