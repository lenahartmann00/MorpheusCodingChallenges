package logic.gson.tokens;

import logic.gson.JsonModel;

public class JsonTokenInt implements JsonModel {

	private int token;

	public JsonTokenInt(int token) {
		this.token = token;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}
}