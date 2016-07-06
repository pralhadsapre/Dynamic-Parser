package com.example.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class Utilities {
	private Context context;

	public static final String LOG_NAME = "Novice";
	public static Utilities Instance;

	public Utilities(Context context) {
		this.context = context;
	}

	public String readBundledFile(String name) {
		AssetManager assetManager = context.getAssets();
		StringBuilder builder = new StringBuilder(50);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					assetManager.open(name)));
			String s;
			while ((s = br.readLine()) != null) {
				builder.append(s);
			}
			return builder.toString();

		} catch (Exception e) {
			Log.d(Utilities.LOG_NAME,
					"Exception occured when reading bundled file "
							+ e.toString());
			return "";
		}
	}

	public String readRemoteFile(String url) {

		return "";
	}
}
