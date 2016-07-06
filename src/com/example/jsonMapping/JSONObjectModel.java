package com.example.jsonMapping;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import org.json.JSONObject;

import android.util.Log;

import com.example.jsonParsers.ParserInterpreterUtilities;
import com.example.utilities.Utilities;

//represents a basic JSON object to code model mapping
public class JSONObjectModel {

	public JSONObjectModel() {

	}

	public JSONObjectModel autoPopulateData(JSONObject config, JSONObject json) {

		// support data types
		// handle all conditions

		Class thisClass = this.getClass();
		Field[] thisFields = thisClass.getDeclaredFields();
		for (Field currentField : thisFields) {

			try {
				Class fieldClass = currentField.getType();
				String fieldName = currentField.getName();

				currentField.setAccessible(true);

				if (fieldClass == java.lang.Double.class) {
					currentField.set(this, ParserInterpreterUtilities
							.getDoubleValue(fieldName, config, json));
				} else if (fieldClass == double.class) {
					currentField.setDouble(this, ParserInterpreterUtilities
							.getDoubleValue(fieldName, config, json)
							.doubleValue());
				} else if (fieldClass == java.lang.Integer.class) {
					currentField.set(this, ParserInterpreterUtilities
							.getIntegerValue(fieldName, config, json));
				} else if (fieldClass == int.class) {
					currentField.setInt(this, ParserInterpreterUtilities
							.getIntegerValue(fieldName, config, json)
							.intValue());
				} else if (fieldClass == java.lang.String.class) {
					currentField.set(this, ParserInterpreterUtilities
							.getStringValue(fieldName, config, json));
				} else if (fieldClass == long.class) {
					currentField.setLong(this, ParserInterpreterUtilities
							.getIntegerValue(fieldName, config, json)
							.longValue());
				} else if (fieldClass == java.lang.Long.class) {
					currentField.set(this, Long
							.valueOf(ParserInterpreterUtilities
									.getIntegerValue(fieldName, config, json)
									.longValue()));
				} else if (fieldClass == float.class) {
					currentField.setFloat(this, ParserInterpreterUtilities
							.getDoubleValue(fieldName, config, json)
							.floatValue());
				} else if (fieldClass == java.lang.Float.class) {
					currentField.set(this, Float
							.valueOf(ParserInterpreterUtilities.getDoubleValue(
									fieldName, config, json).floatValue()));
				} else if (fieldClass == short.class) {
					currentField.setShort(this, ParserInterpreterUtilities
							.getIntegerValue(fieldName, config, json)
							.shortValue());
				} else if (fieldClass == java.lang.Short.class) {
					currentField.set(this, Short
							.valueOf(ParserInterpreterUtilities
									.getIntegerValue(fieldName, config, json)
									.shortValue()));
				} else if (fieldClass == boolean.class) {
					currentField.setBoolean(this, ParserInterpreterUtilities
							.getBooleanValue(fieldName, config, json)
							.booleanValue());
				} else if (fieldClass == java.lang.Boolean.class) {
					currentField.set(this, ParserInterpreterUtilities
							.getBooleanValue(fieldName, config, json));

				} else if (fieldClass == java.util.ArrayList.class) {

					// handles arraylist collections
					ParameterizedType listType = (ParameterizedType) currentField
							.getGenericType();
					Class collectionClassName = (Class) listType
							.getActualTypeArguments()[0];
					Object typeInstance = collectionClassName.newInstance();
					if (typeInstance instanceof JSONObjectModel) {
						JSONArrayParsed parsedCollection = ParserInterpreterUtilities
								.getArray(fieldName, config, json);

						ArrayList<JSONObjectModel> collection = new ArrayList<JSONObjectModel>(
								parsedCollection.getArray().length());

						try {
							for (int i = 0; i < parsedCollection.getArray()
									.length(); i++) {
								JSONObject object = (JSONObject) parsedCollection
										.getArray().get(i);

								collection
										.add(((JSONObjectModel) collectionClassName
												.newInstance())
												.autoPopulateData(
														parsedCollection
																.getConfig(),
														object));

							}

							currentField.set(this, collection);
						} catch (Exception exp) {

						}
					}

				} else if (fieldClass.newInstance() instanceof JSONObjectModel) {
					JSONObjectModel singleModelObject = (JSONObjectModel) fieldClass
							.newInstance();

					JSONObjectParsed parsedObject = ParserInterpreterUtilities
							.getJSONObject(fieldName, config, json);
					singleModelObject.autoPopulateData(
							parsedObject.getConfig(), parsedObject.getObject());

					currentField.set(this, singleModelObject);
				}

			} catch (Exception exp) {
				Log.d(Utilities.LOG_NAME, exp.toString());
			}

		}

		return this;
	}
}
