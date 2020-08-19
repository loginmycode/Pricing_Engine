package com.benchhire.interview;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class ConversionService {
	
	public  List<Cycle> loadCycles() throws IOException {
		
		Gson gson=new Gson();
		Type cyclesListType=new TypeToken<List<Cycle>>() {}.getType();

		
		List<Cycle> cycles=gson.fromJson(new FileReader(Constants.CYCLES_DATA_PATH), cyclesListType); //Listing cycles from json file
					
		return cycles;
	
}

public   JsonObject loadPrices(String year) throws IOException {
	
		Gson gson=new Gson(); // for converting json to java object 
		//passing path of json file
		JsonObject pricesObject=gson.fromJson(new FileReader(Constants.PRICES_DATA_PATH), JsonObject.class) ;
		
		JsonObject yearPriceObject=	(JsonObject)pricesObject.get(year);

		return yearPriceObject;
}

// load available part types 
public  Map<String, ArrayList<String>> loadComponentTypes() throws IOException{
	Gson gson=new Gson();
	
	
	Type mapType=new TypeToken<Map<String, ArrayList<String>>>() {}.getType();
	Map<String, ArrayList<String>> alvilableParts=gson.fromJson(new FileReader(Constants.PARTS_DATA_PATH), mapType);

	return alvilableParts;
}


}
