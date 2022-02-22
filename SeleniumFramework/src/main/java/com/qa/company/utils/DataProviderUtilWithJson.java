package com.qa.company.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.company.constants.FrameworkConstants;

public class DataProviderUtilWithJson {

	@Test(dataProvider="FetchDataFromJsonArray")
	public void getDataFromJson(Map<String, String> map){

		map.forEach((k,v)->System.out.println(k + " : " + v));

	}

	//DataProvider with Simple Json data
	@DataProvider(name="FetchDataFromJson")
	public Object[] dataInJson() throws IOException, JsonMappingException, IOException{
		LinkedHashMap<Object, Object> map = new ObjectMapper().readValue(new File(FrameworkConstants.getSimpledatajsonpath()), new TypeReference<LinkedHashMap<Object, Object>>() {});
		return new Object[] {map};
	}

	//DataProvider with Array of Json data
	@SuppressWarnings("unchecked")
	@DataProvider(name="FetchDataFromJsonArray")
	public Object[] readJsonWithArray() throws IOException, ParseException{

		//parse the json file using FileReader
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader(FrameworkConstants.getArraydatajsonpath()));
		
		//convert the Java object to JSON Object
		JSONObject jsonObj = (JSONObject) obj;

		//get the array which holds the data
		JSONArray jsonArray = (JSONArray) jsonObj.get("userLogins");

		//create object for dataProvider
		Object[] data= new Object[jsonArray.size()];

		//create hashmap to store in key value pair
		LinkedHashMap<Object, Object> map = null;

		//loop to store key and value in map

		for(int i=0; i<jsonArray.size(); i++){
			map = new LinkedHashMap<>();
			JSONObject users = (JSONObject) jsonArray.get(i);
			map=new ObjectMapper().readValue(users.toString(), LinkedHashMap.class);
			data[i]=map;
		}
		return data;
	}
}
