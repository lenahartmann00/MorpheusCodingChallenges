package com.lenahartmann00.morpheus_challenges.model.json.tokens;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;

public class JsonToken<T> implements JsonModel {

	private T token;

	public JsonToken(T token) {
		this.token = token;
	}

	public T getToken() {
		return token;
	}

	public void setToken(T token) {
		this.token = token;
	}
}

