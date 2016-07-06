package com.example.models;
import org.json.JSONObject;

import com.example.jsonMapping.*;
import com.example.jsonParsers.ParserInterpreterUtilities;
import com.example.utilities.Utilities;

public class CheckpointBean extends JSONObjectModel {
	private String name;
	private String clockTime;
	private String relativeTime;
	private double pace;
	private String isCrossed;

	public CheckpointBean() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override public JSONObjectModel autoPopulateData(JSONObject config,
	 * JSONObject json) {
	 * 
	 * name = ParserInterpreterUtilities.getStringValue("checkpointName",
	 * config, json); clockTime =
	 * ParserInterpreterUtilities.getStringValue("clockTime", config, json);
	 * relativeTime = ParserInterpreterUtilities.getStringValue( "relativeTime",
	 * config, json); pace = ParserInterpreterUtilities.getDoubleValue("pace",
	 * config, json); isCrossed =
	 * ParserInterpreterUtilities.getStringValue("isCrossed", config, json);
	 * 
	 * return this; }
	 */
}
