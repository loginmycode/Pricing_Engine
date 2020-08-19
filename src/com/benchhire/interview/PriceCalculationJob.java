package com.benchhire.interview;

public class PriceCalculationJob implements Runnable {

	
	Cycle cycle;
	PriceCalculationService priceCalculationService;
			
	
	public PriceCalculationJob(Cycle cycle,PriceCalculationService priceCalculationService) {
		super();
		this.cycle = cycle;
		this.priceCalculationService=priceCalculationService;
		
	}
	
	@Override
	public void run() {
		try {
		
			
			//System.out.println(cycle.getId()+" pricing  started");
			
			priceCalculationService.calculatePrice(cycle);
			Thread.sleep(1000);
			
			
			//System.out.println(cycle.getId()+" pricing calculating is completed ");
			
			
			
			// while doing changes to increamentCount--> others threads shoudn't increment or check the count
			synchronized (priceCalculationService) {
				priceCalculationService.increamentCompletedCycles();
				priceCalculationService.notify();// notifyAll 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
