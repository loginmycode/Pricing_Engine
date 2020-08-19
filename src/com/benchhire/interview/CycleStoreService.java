package com.benchhire.interview;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CycleStoreService {


	ConversionService conversionService=new ConversionService();
	Validations validations=new Validations();
	
	public Cycle[] loadCycles() throws  IOException {

		// some how we are loading cycles i.e json file or command line
		List<Cycle>cycleList=conversionService.loadCycles();
	
		
		 for (Iterator<Cycle> iterator = cycleList.iterator(); iterator.hasNext();) 
		 {
			Cycle cycle =  iterator.next();
			
			// input validation
			String message=validations.validate(cycle);
			if(message!=Constants.SUCCESS) {
				//System.out.println(" input error "+message);
				iterator.remove();
			}
			
			// business/logic validation
			message=validations.businessValidate(cycle);
			if(message!=Constants.SUCCESS) {
				//System.out.println(" logic error "+message);
				iterator.remove();
			}

		}
	
		
		Cycle[] cycles=new Cycle[cycleList.size()];
		
		
		
		
		
		
		return cycleList.toArray(cycles);
		

	}

	public Cycle[] calculatePrices(Cycle[] cycles) throws InterruptedException {
		

		BlockingQueue<Cycle> cycleQueue=new ArrayBlockingQueue<Cycle>(3);
		
		PriceCalculationService service=new PriceCalculationService(cycleQueue,cycles.length);
		
		Thread calicualtionThread=	new Thread(service);
		calicualtionThread.start();
		
		
		for (int i = 0; i < cycles.length; i++) {
			try {
				cycleQueue.put(cycles[i]);  // giving cycles for calculation of price
				
				//System.out.println(cycles[i].getId()+" given for  calculation");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		calicualtionThread.join(); // making current thread to wait until calculation is completed

		return cycles;
	}

	

}
