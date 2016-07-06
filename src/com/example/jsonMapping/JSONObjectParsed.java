package com.example.jsonMapping;

import org.json.JSONObject;

public class JSONObjectParsed {

	private JSONObject object;
	private JSONObject config;

	public JSONObjectParsed(JSONObject config, JSONObject object) {
		this.object = object;
		this.config = config;
	}

	public JSONObject getObject() {
		return object;
	}

	public void setObject(JSONObject object) {
		this.object = object;
	}

	public JSONObject getConfig() {
		return config;
	}

	public void setConfig(JSONObject config) {
		this.config = config;
	}

}
