package org.miguel;

public class WaterSource {

	private double waterPressure;
	private double waterTemperature;
	
	
	public double getWaterPressure() {
		return waterPressure;
	}
	public void setWaterPressure(double waterPressure) {
		this.waterPressure = waterPressure;
	}
	public double getWaterTemperature() {
		return waterTemperature;
	}
	public void setWaterTemperature(double waterTemperature) {
		this.waterTemperature = waterTemperature;
	}
	
	public void doSelfCheck(){
		System.out.println("Checking out parameters...");
	}
	
	
}
