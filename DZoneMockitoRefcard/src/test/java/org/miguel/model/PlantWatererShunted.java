package org.miguel.model;

import org.miguel.WaterSource;
import org.miguel.WateringScheduler;

public class PlantWatererShunted extends PlantWaterer{

	public PlantWatererShunted(WaterSource waterSource, WateringScheduler wateringScheduler, Price price, String name){
		super(waterSource,wateringScheduler);
		this.setPrice(price);
		this.setName(name);
	}
	
	
}
