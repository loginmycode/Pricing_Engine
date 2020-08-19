package com.benchhire.interview;

import java.util.Arrays;

public class PriceEngine {

	public static void main(String[] args) {
		
		//To understand working flow of the project uncomment all the System.out.println() in all source files.
		
		try {
			float sum=0;
			System.out.println(" start ");
			CycleStoreService cycleStoreService=new CycleStoreService();
			
			
			Cycle[] cycles = cycleStoreService.loadCycles();//calling load cycle method in cycleStoreService
			
			System.out.println(" before calculating prices ");
			System.out.println(Arrays.toString(cycles));

			cycleStoreService.calculatePrices(cycles); //calculating the price
	
			System.out.println(" calculation is done ");
			//System.out.println(Arrays.toString(cycles));
			for (int i = 0; i < cycles.length; i++) {
				System.out.println(cycles[i].getId()+" and price is "+cycles[i].getPrice());//Checking price of each cycle
				sum+=cycles[i].getPrice();
			}
			
			System.out.println("The totol price of all cycles ="+sum); //Sum of all cycles
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
