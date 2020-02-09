package com.lenahartmann00.morpheus_challenges.model.json.arrays;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;

public class JsonTwoArrays<T> implements JsonModel {

	private T[] list;

	public JsonTwoArrays(T[] list) {
		this.list = list;
	}

	public T[] getList() {
		return list;
	}
}
