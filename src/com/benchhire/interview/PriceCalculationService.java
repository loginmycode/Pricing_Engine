package com.benchhire.interview;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.JsonObject;

public class PriceCalculationService implements Runnable {

	BlockingQueue<Cycle> cycleQueue;
	public static int POOL_SIZE=3;
	int noOfCycles;
	int completedCycles;
	ConversionService conversionService=new ConversionService();

	public PriceCalculationService(BlockingQueue<Cycle> cycleQueue,int noOfCycles) {
		super();
		this.cycleQueue = cycleQueue;
		this.noOfCycles=noOfCycles;
	}

	@Override
	public void run() {
		
		int count=0;
	    ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);   
	
			try {
				
				while(count<noOfCycles) {
					
					
					Cycle cycle=cycleQueue.take();// taken from blocking queue
					
					//System.out.println(cycle.getId()+"  cycle  has taken for  calculation");
					
					
					PriceCalculationJob job=new PriceCalculationJob(cycle,this);
					
					pool.submit(job);//pool.execute(job)
					
					count++;
					
				}
				
				
				//System.out.println("all cycles are given for calculation of price----------------->");
				
				
				
				// while checking the completedCycles count --> no other threads shouldn't increment count
				synchronized (this) {
					
					while(completedCycles!=noOfCycles) {
						
						//System.out.println(" still calculation is going on");
						this.wait();//this.wait(1000);
					}
				}
				
				
				//System.out.println("###################### calculation is completed #############################");
				pool.shutdown();

				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	
		
	}
	
	public synchronized void  increamentCompletedCycles() {
		this.completedCycles++;
	}
	
	public Cycle calculatePrice(Cycle cycle) throws IOException {

		// some how we are calculating price
		float price=1000.0f*((float)Math.random());;
		cycle.setPrice(price);
		
		// cycle.getPricingDate().getYear() //deprecated
		
		String[] strArray=	cycle.getPricingDate().toString().split(" "); //Wed Aug 19 20:51:58 IST 2020
		
		JsonObject prices=conversionService.loadPrices(strArray[strArray.length-1]);
	  	
		JsonObject framePrices=	((JsonObject)prices.get("frame"));
		float framePrice= framePrices.get(cycle.getFrame()).getAsFloat();
		
		JsonObject handlebarPrices=	((JsonObject)prices.get("handlebar"));
		float handlebarPrice= handlebarPrices.get(cycle.getHandlebar()).getAsFloat();
		
		JsonObject seatingPrices=	((JsonObject)prices.get("seating"));
		float seatingPrice= seatingPrices.get(cycle.getSeating()).getAsFloat();
		
		JsonObject wheelsPrices=	((JsonObject)prices.get("wheels"));
		float wheelsPrice= wheelsPrices.get(cycle.getWheels()).getAsFloat();
		
		JsonObject chainAssemblePrices=	((JsonObject)prices.get("chainAssemble"));
		float chainAssemblePrice= chainAssemblePrices.get(cycle.getChainAssemble()).getAsFloat();
		
		float totalPrice=framePrice+handlebarPrice+seatingPrice+wheelsPrice+chainAssemblePrice;
	  
		
		cycle.setPrice(totalPrice);
	  
		
		return cycle;
	}
}
