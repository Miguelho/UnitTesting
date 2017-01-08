package org.miguel;

public class WateringScheduler {

	private Integer numberOfPlantsScheduledOnDate = new Integer (-1);
	
	private WaterSource waterSource;
	
	public WateringScheduler(){}
	
	public Integer getNumberOfPlantsScheduledOnDate(String wantedDate) {
		// TODO Auto-generated method stub
		return this.numberOfPlantsScheduledOnDate;
	}
	
	public Integer getTotalNumberOfPlants(Machine theMachine, Place thePlace) {
		// TODO Auto-generated method stub
		return Integer.valueOf((int) Math.random());
	}
	
	private WateringScheduler(WaterSource theWaterSource){
		this.waterSource = theWaterSource;
	}
	
	public static WateringScheduler getWateringScheduler(){
		
		WaterSource waterSource = new WaterSource();
		
		waterSource.setWaterPressure(1);
				
		return new WateringScheduler(waterSource);
	}

	public WaterSource getWaterSource() {
		return this.waterSource;
	}

}
