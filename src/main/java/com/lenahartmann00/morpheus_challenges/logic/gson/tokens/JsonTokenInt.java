package com.lenahartmann00.morpheus_challenges.logic.gson.tokens;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

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