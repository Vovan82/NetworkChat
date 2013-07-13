package com.TronenkoVladimir.networkchat;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parser {

	public static AuthInfo auth(String jsonString)
			throws IllegalArgumentException {
		try {
			JSONObject json = new JSONObject(jsonString);
			if (json.getString("status").equals("ok")) {
				
			JSONArray arr=json.getJSONArray("rooms");	
				return new AuthInfo(json.getString("token"),
						json.getString("nick"));

			} else {
				throw new IllegalArgumentException(
						"email or pasworld is not valid");
			}

		} catch (JSONException e) {
			throw new IllegalArgumentException(e);
		}
	}

	static class ParserException extends Exception {
		public final int errCode;

		ParserException(int errCode) {
			this.errCode = errCode;

		}

		ParserException(String message) {
			super(message);
			errCode = -1;
		}

		ParserException(Throwable t) {
			super(t);
			errCode = -1;
		}
	}

	public static void getRooms(String jsonResp, List<Room> list) { //*****************
		// TODO Auto-generated method stub
		
	}

}
