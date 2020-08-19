package com.benchhire.interview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Validations {

	Map<String, ArrayList<String>> componetTypes;
	
	// input validations
	public String validate(Cycle cycle) { //Validating all the possibilities failures;
		
			String message="";
			
			if(cycle==null)
				 return "give proper object";
			
			if(cycle.getFrame()==null || cycle.getFrame().trim().equals(""))
				message=" give proper frame \n";
			
			if(cycle.getHandlebar()==null || cycle.getHandlebar().trim().equals(""))
				message=message+" give proper handlebar \n";
			
			if(cycle.getSeating()==null || cycle.getSeating().trim().equals(""))
				message=" give proper seating \n";
			
			if(cycle.getWheels()==null || cycle.getWheels().trim().equals(""))
				message=" give proper wheels \n";
			
			if(cycle.getChainAssemble()==null || cycle.getChainAssemble().trim().equals(""))
				message=" give proper chainAssemble \n";
			
			if(cycle.getPricingDate()==null )
				message=" give proper pricing date \n";
			
		  
		   
		return  message.length()==0? Constants.SUCCESS:message;
		
	}
	
	public void name() {
		
	}
	
	// doing business/login validation
	public String businessValidate(Cycle cycle) throws IOException {
		
		String message="";
		
		if(componetTypes==null)
			componetTypes=new ConversionService().loadComponentTypes();
		
		ArrayList<String>frameTypes=componetTypes.get("frame");
		if(!frameTypes.contains(cycle.getFrame()))
			message=message+cycle.getFrame()+" frame is not available \n";
		
		ArrayList<String>handlebarTypes=componetTypes.get("handlebar");
		if(!handlebarTypes.contains(cycle.getHandlebar()))
			message=message+cycle.getHandlebar()+" handlebar is not available \n";
		
		ArrayList<String>seatingTypes=componetTypes.get("seating");
		if(!seatingTypes.contains(cycle.getSeating()))
			message=message+cycle.getSeating()+" seating is not available \n";
		
		ArrayList<String>wheelsTypes=componetTypes.get("wheels");
		if(!wheelsTypes.contains(cycle.getWheels()))
			message=message+cycle.getWheels()+" wheels is not available \n";
		
		ArrayList<String>chainAssembleTypes=componetTypes.get("chainAssemble");
		if(!chainAssembleTypes.contains(cycle.getChainAssemble()))
			message=message+cycle.getChainAssemble()+" chainAssemble is not available \n";
		
		
		return  message.length()==0? Constants.SUCCESS:message;
			
		
	
	}
	
	
	
	
}
