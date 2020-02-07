package com.lenahartmann00.morpheus_challenges.logic.gson.tokens;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonTokenString implements JsonModel {

	private String token;

	public JsonTokenString(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}