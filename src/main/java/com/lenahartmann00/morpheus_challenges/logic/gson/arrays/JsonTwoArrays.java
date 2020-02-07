package com.lenahartmann00.morpheus_challenges.logic.gson.arrays;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonTwoArrays<T> implements JsonModel {

	private T[] list;

	public JsonTwoArrays(T[] list) {
		this.list = list;
	}

	public T[] getList() {
		return list;
	}
}
