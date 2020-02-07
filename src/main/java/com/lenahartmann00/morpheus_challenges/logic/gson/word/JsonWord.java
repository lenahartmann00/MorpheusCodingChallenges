package com.lenahartmann00.morpheus_challenges.logic.gson.word;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonWord<T> implements JsonModel {

	private T word;

	public JsonWord(T word) {
		this.word = word;
	}

	public T getWord() {
		return word;
	}

}
