package com.example.models;

import java.util.ArrayList;

import org.json.JSONObject;

import com.example.jsonMapping.*;
import com.example.jsonParsers.ParserInterpreterUtilities;

public class RunnerBean extends JSONObjectModel {

	private Double distance;
	private String currentDate;
	private double percentage;
	private int bibNo;
	private String estimatedFinish;
	private ArrayList<CheckpointBean> checkpoints;

	public RunnerBean() {
		checkpoints = new ArrayList<CheckpointBean>();
	}

	/*
	 * @Override public JSONObjectModel populateData(JSONObject config,
	 * JSONObject json) { // TODO Auto-generated method stub distance =
	 * ParserInterpreterUtilities.getDoubleValue("distance", config, json); date
	 * = ParserInterpreterUtilities.getStringValue("currentDate", config, json);
	 * percentage = ParserInterpreterUtilities.getDoubleValue("percentage",
	 * config, json); estimatedFinish =
	 * ParserInterpreterUtilities.getStringValue( "estimatedFinish", config,
	 * json);
	 * 
	 * JSONArrayParsed checkpointCollection = ParserInterpreterUtilities
	 * .getArray("checkpoints", config, json);
	 * 
	 * try { for (int i = 0; i < checkpointCollection.getArray().length(); i++)
	 * { JSONObject object = (JSONObject) checkpointCollection
	 * .getArray().get(i);
	 * 
	 * checkpoints.add(new CheckpointBean().populateData(
	 * checkpointCollection.getConfig(), object));
	 * 
	 * } } catch (Exception exp) {
	 * 
	 * } return this; }
	 */
}
