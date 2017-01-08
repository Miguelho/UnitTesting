package org.miguel.model;

import org.miguel.WaterSource;
import org.miguel.WateringScheduler;

public class PlantWaterer extends Tool{
	
	private WaterSource waterSource;
	
	private WateringScheduler wateringScheduler;

	public PlantWaterer(){}
	
	public PlantWaterer(WaterSource waterSource, WateringScheduler wateringScheduler){
		
		this.waterSource = waterSource;
		this.wateringScheduler = wateringScheduler;
	}

	public WaterSource getWaterSource() {
		return waterSource;
	}

	public WateringScheduler getWateringScheduler() {
		return wateringScheduler;
	}
	
	public void describe(){
		this.toString();
	}

	@Override
	public String toString() {
		return "PlantWaterer [waterSource=" + waterSource + ", wateringScheduler=" + wateringScheduler +", price=" + this.getPrice().toString() +"]";
	}
	
	
	
	

}
