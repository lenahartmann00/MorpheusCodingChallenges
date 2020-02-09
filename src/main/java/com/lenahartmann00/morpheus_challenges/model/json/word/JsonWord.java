package com.lenahartmann00.morpheus_challenges.model.json.word;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;

public class JsonWord<T> implements JsonModel {

	private T word;

	public JsonWord(T word) {
		this.word = word;
	}

	public T getWord() {
		return word;
	}

}
