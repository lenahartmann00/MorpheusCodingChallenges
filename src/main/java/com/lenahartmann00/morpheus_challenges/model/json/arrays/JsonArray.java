package com.lenahartmann00.morpheus_challenges.model.json.arrays;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;

public class JsonArray<T> implements JsonModel {

	private T[] list;

	public JsonArray(T[] list) {
		this.list = list;
	}

	public T[] getList() {
		return list;
	}

	public void setList(T[] list) {
		this.list = list;
	}
}
