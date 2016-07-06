package com.example.jsonParsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.jsonMapping.JSONArrayParsed;
import com.example.jsonMapping.JSONObjectParsed;
import com.example.models.RunnerBean;
import com.example.utilities.Utilities;

import android.util.Log;
import com.example.facebookParsing.*;
public class ParserInterpreterUtilities {

	public static final String FIELD = "@";
	public static final String ARRAY = "$";
	public static final String ARRAY_FIRST = "0";
	public static final String ARRAY_RANGE = "..";
	public static final String ARRAY_RANGE_REGEX = "\\.\\.";
	public static final String ARRAY_LAST = "$";

	public static final String KEY = "key";
	public static final String OVERRIDE = "override";

	public static final String VALUE = "value";
	public static final String DEFAULT = "default";
	public static final String HARDCODE = "hardcode";

	public static final String ARRAY_KEY = "array";
	public static final String OBJECT_KEY = "objectKey";
	public static final String COMPOSITE_OBJECT_KEY = "object";

	public static Double getDoubleValue(String keyName, JSONObject config,
			JSONObject json) {

		Double value = Double.valueOf(0);

		try {

			if (config.has(keyName)) {
				Object configData = config.get(keyName);
				Object fetchedValue = new Object();

				if (configData instanceof JSONObject) {
					// handle key and override cases

					if (((JSONObject) configData).has(HARDCODE))
						value = ((JSONObject) configData).getDouble(HARDCODE);
					else {

						fetchedValue = getValue(
								(String) ((JSONObject) configData).get(KEY),
								json);
						value = castDouble(fetchedValue);

						if (((JSONObject) configData).has(OVERRIDE)) {
							JSONArray overrideValues = (JSONArray) ((JSONObject) configData)
									.get(OVERRIDE);
							for (int i = 0; i < overrideValues.length(); i++) {
								JSONObject overrideObject = overrideValues
										.getJSONObject(i);

								if (((Double) overrideObject.getDouble(VALUE))
										.compareTo(value) == 0)
									value = overrideObject.getDouble(OVERRIDE);

							}
						}
						// default value to be used if the string is empty
						if (((JSONObject) configData).has(DEFAULT)
								&& value.doubleValue() == 0.0)
							value = ((JSONObject) configData)
									.getDouble(DEFAULT);

					}

				} else if (configData instanceof String) {

					fetchedValue = getValue((String) configData, json);
					value = castDouble(fetchedValue);
				}
			}
		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME,
					String.format("The config for %s is improper", keyName));

		}

		return value;
	}

	public static Integer getIntegerValue(String keyName, JSONObject config,
			JSONObject json) {

		Integer value = Integer.valueOf(0);

		try {

			if (config.has(keyName)) {
				Object configData = config.get(keyName);
				Object fetchedValue = new Object();

				if (configData instanceof JSONObject) {
					// handle key and override cases

					if (((JSONObject) configData).has(HARDCODE))
						value = ((JSONObject) configData).getInt(HARDCODE);
					else {

						fetchedValue = getValue(
								(String) ((JSONObject) configData).get(KEY),
								json);
						value = castInt(fetchedValue);

						if (((JSONObject) configData).has(OVERRIDE)) {
							JSONArray overrideValues = (JSONArray) ((JSONObject) configData)
									.get(OVERRIDE);
							for (int i = 0; i < overrideValues.length(); i++) {
								JSONObject overrideObject = overrideValues
										.getJSONObject(i);

								if (((Integer) overrideObject.getInt(VALUE))
										.compareTo(value) == 0)
									value = overrideObject.getInt(OVERRIDE);
							}
						}

						// default value to be used if the string is empty
						if (((JSONObject) configData).has(DEFAULT)
								&& value.intValue() == 0)
							value = ((JSONObject) configData).getInt(DEFAULT);

					}

				} else if (configData instanceof String) {
					fetchedValue = getValue((String) configData, json);
					value = castInt(fetchedValue);
				}
			}
		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME,
					String.format("The config for %s is improper", keyName));
		}

		return value;

	}

	public static String getStringValue(String keyName, JSONObject config,
			JSONObject json) {
		String value = "";

		try {

			if (config.has(keyName)) {
				Object configData = config.get(keyName);
				Object fetchedValue = new Object();

				if (configData instanceof JSONObject) {
					// handle key and override cases

					if (((JSONObject) configData).has(HARDCODE))
						value = ((JSONObject) configData).getString(HARDCODE);
					else {

						fetchedValue = getValue(
								(String) ((JSONObject) configData).get(KEY),
								json);
						value = castString(fetchedValue);

						if (((JSONObject) configData).has(OVERRIDE)) {
							JSONArray overrideValues = (JSONArray) ((JSONObject) configData)
									.get(OVERRIDE);
							for (int i = 0; i < overrideValues.length(); i++) {
								JSONObject overrideObject = overrideValues
										.getJSONObject(i);

								if (overrideObject.getString(VALUE)
										.equalsIgnoreCase(value))
									value = overrideObject.getString(OVERRIDE);

							}
						}

						// default value to be used if the string is empty
						if (((JSONObject) configData).has(DEFAULT)
								&& value.isEmpty())
							value = ((JSONObject) configData)
									.getString(DEFAULT);

					}

				} else if (configData instanceof String) {
					fetchedValue = getValue((String) configData, json);
					value = castString(fetchedValue);
				}
			}
		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME,
					String.format("The config for %s is improper", keyName));

		}
		return value;
	}

	public static Boolean getBooleanValue(String keyName, JSONObject config,
			JSONObject json) {
		Boolean value = Boolean.FALSE;

		try {

			if (config.has(keyName)) {
				Object configData = config.get(keyName);
				Object fetchedValue = new Object();

				if (configData instanceof JSONObject) {
					// handle key and override cases

					if (((JSONObject) configData).has(HARDCODE))
						value = ((JSONObject) configData).getBoolean(HARDCODE);
					else {

						fetchedValue = getValue(
								(String) ((JSONObject) configData).get(KEY),
								json);
						value = castBoolean(fetchedValue);

						if (((JSONObject) configData).has(OVERRIDE)) {
							JSONArray overrideValues = (JSONArray) ((JSONObject) configData)
									.get(OVERRIDE);
							for (int i = 0; i < overrideValues.length(); i++) {
								JSONObject overrideObject = overrideValues
										.getJSONObject(i);

								if ((overrideObject.getBoolean(VALUE)) == value
										.booleanValue())
									value = overrideObject.getBoolean(OVERRIDE);

							}
						}

						// default value to be used
						if (((JSONObject) configData).has(DEFAULT))
							value = ((JSONObject) configData)
									.getBoolean(DEFAULT);

					}

				} else if (configData instanceof String) {
					fetchedValue = getValue((String) configData, json);
					value = castBoolean(fetchedValue);
				}
			}
		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME,
					String.format("The config for %s is improper", keyName));

		}
		return value;
	}

	private static Object getValue(String path, JSONObject json) {
		Object value = new Object();
		boolean valueFound = false;

		try {

			String hierarchy[], s;
			if (path.contains("->")) {
				hierarchy = path.split("->");
			} else {
				hierarchy = new String[1];
				hierarchy[0] = path;
			}

			Object probe = json;
			for (int i = 0; i < hierarchy.length; i++) {
				s = hierarchy[i].trim();
				if (s.startsWith(FIELD)) {
					try {
						Object next = ((JSONObject) probe).get(s
								.substring(FIELD.length()));

						if (next instanceof JSONArray
								|| next instanceof JSONObject)
							probe = next;
						else if (next instanceof Double
								|| next instanceof Integer
								|| next instanceof String) {
							value = next;
							valueFound = true;
							// you have found your value
							break;
						}
					} catch (JSONException exp) {
						Log.d(Utilities.LOG_NAME,
								"Could not find "
										+ s.substring(FIELD.length(),
												s.length()));
						break;
					}
				} else if (s.startsWith(ARRAY)) {
					try {
						int arrayIndex = 0;
						int arrayLength = ((JSONArray) probe).length();
						if (s.length() > ARRAY.length()) {
							switch (s.substring(ARRAY.length())) {
								case ARRAY_LAST :
									arrayIndex = arrayLength - 1;
									break;
								default :
									try {
										arrayIndex = Integer.parseInt(s
												.substring(ARRAY.length()));
										if (!(arrayIndex < arrayLength))
											arrayIndex = arrayLength - 1;
									} catch (Exception exp) {
										Log.d(Utilities.LOG_NAME,
												"Invalid array index specified "
														+ s.substring(ARRAY
																.length()));
									}
									break;
							}
						}

						try {
							Object next;
							next = ((JSONArray) probe).get(arrayIndex);

							if (next instanceof JSONObject
									|| next instanceof JSONArray)
								probe = next;
							else if (next instanceof Double
									|| next instanceof Integer
									|| next instanceof String) {
								value = next;
								valueFound = true;
								break;
							}
							// the last case indicates the presence of the
							// terminal value
						} catch (Exception exp) {
							Log.d(Utilities.LOG_NAME,
									"The value couldn't be found for " + s);
						}
					} catch (Exception exp) {
						Log.d(Utilities.LOG_NAME,
								"Could not find "
										+ s.substring(ARRAY.length(),
												s.length()));
						break;
					}
				}
			}

			if (!valueFound)
				value = probe;

		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME, exp.toString());
		}

		return value;
	}

	private static Integer castInt(Object value) {
		if (value instanceof Integer)
			return (Integer) value;
		else if (value instanceof Double)
			return (Integer) ((Double) value).intValue();
		else
			return Integer.valueOf(0);
	}

	private static Double castDouble(Object value) {
		if (value instanceof Integer)
			return (Double) ((Integer) value).doubleValue();
		else if (value instanceof Double)
			return (Double) value;
		else
			return Double.valueOf(0);
	}

	private static String castString(Object value) {
		if (value instanceof String)
			return (String) value;
		else if (value instanceof Integer)
			return ((Integer) value).toString();
		else if (value instanceof Double)
			return ((Double) value).toString();
		else
			return "";
	}

	private static Boolean castBoolean(Object value) {
		if (value instanceof Boolean)
			return (Boolean) value;
		else if (value instanceof String) {
			String tempValue = (String) value;
			if (tempValue.equalsIgnoreCase("false"))
				return Boolean.FALSE;
			else if (tempValue.equalsIgnoreCase("true"))
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		} else
			return Boolean.FALSE;

	}

	public static JSONObjectParsed getJSONObject(String keyName,
			JSONObject config, JSONObject json) {

		JSONObject objectConfig = new JSONObject();
		JSONObject jsonObject = new JSONObject();

		try {
			String hierarchy[], s, path;

			if (config.has(keyName)) {
				JSONObject configData = config.getJSONObject(keyName);
				objectConfig = configData.getJSONObject(COMPOSITE_OBJECT_KEY);
				path = configData.getString(OBJECT_KEY);

				Object value = getValue(path, json);
				if (value instanceof JSONObject)
					jsonObject = (JSONObject) value;
			}
		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME, String.format(
					"The config for object entry %s is improper", keyName));
		}

		return new JSONObjectParsed(objectConfig, jsonObject);
	}

	public static JSONArrayParsed getArray(String keyName, JSONObject config,
			JSONObject json) {

		JSONArray array = new JSONArray();
		JSONObject arrayConfig = new JSONObject();

		try {
			String hierarchy[], s, path;

			if (config.has(keyName)) {
				JSONObject configData = config.getJSONObject(keyName);
				arrayConfig = configData.getJSONObject(COMPOSITE_OBJECT_KEY);
				path = configData.getString(ARRAY_KEY);

				if (path.contains("->")) {
					hierarchy = path.split("->");

					s = path.substring(0, path.lastIndexOf("->"));

					Object values = getValue(s, json);
					if (values instanceof JSONArray) {
						s = hierarchy[hierarchy.length - 1];

						String range[];
						if (s.contains(ARRAY_RANGE)) {
							range = s.split(ARRAY_RANGE_REGEX);
							if (range.length == 2) {
								int start, end;
								start = end = 0;
								for (int i = 0; i < 2; i++) {
									switch (range[i]) {
										case ARRAY_LAST :
											end = ((JSONArray) values).length() - 1;
											break;
										default :
											try {
												if (i == 0) {
													start = Integer
															.parseInt(range[i]
																	.substring(ARRAY
																			.length()));
												} else if (i == 1) {
													end = Integer
															.parseInt(range[i]);
												}
											} catch (Exception exp) {
												Log.d(Utilities.LOG_NAME,
														"Problem in converting a range value "
																+ range[i]);
											}

									}
								}

								if (start < end) {
									for (int i = start; i <= end; i++) {
										array.put(((JSONArray) values).get(i));
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME, String.format(
					"The config for array entry %s is improper", keyName));
		}

		return new JSONArrayParsed(array, arrayConfig);
	}

	public static void TestRig() {

		try {
			JSONObject config = new JSONObject(
					Utilities.Instance
							.readBundledFile("json/parserConfig3.txt"));

			JSONObject json = new JSONObject(
					Utilities.Instance
							.readBundledFile("json/runnerDetails1.txt"));

			/*
			 * Feeds feeds = new Feeds(); feeds.autoPopulateData(config, json);
			 */

			RunnerBean bean = new RunnerBean();
			bean.autoPopulateData(config, json);

			Log.d(Utilities.LOG_NAME, "Composite object successfully parsed");
			/*
			 * Log.d(Utilities.LOG_NAME, String.format("distance2 is %f",
			 * getDoubleValue(config.getString("distance2"), data)
			 * .doubleValue())); Log.d(Utilities.LOG_NAME,
			 * String.format("distance3 is %d",
			 * getIntegerValue(config.getString("distance3"), data)
			 * .intValue()));
			 * 
			 * Log.d(Utilities.LOG_NAME, String.format("trail name is %s",
			 * getStringValue(config.getString("trailname"), data)));
			 * Log.d(Utilities.LOG_NAME, String.format( "percentage is %d",
			 * getIntegerValue(config.getString("percentage"),
			 * data).intValue()));
			 */

		} catch (Exception exp) {
			Log.d(Utilities.LOG_NAME,
					"Exception occured when reading bundled file "
							+ exp.toString());
		}
	}
}
