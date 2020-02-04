package logic.gson.tokens;

import logic.gson.JsonModel;

public class JsonTokenString implements JsonModel {

	private String token;

	public JsonTokenString(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}