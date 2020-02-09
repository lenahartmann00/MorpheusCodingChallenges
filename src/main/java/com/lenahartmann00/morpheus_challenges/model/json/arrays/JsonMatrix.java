package com.lenahartmann00.morpheus_challenges.model.json.arrays;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;

public class JsonMatrix<T> implements JsonModel {

	private T[][] list;

	public JsonMatrix(T[][] list) {
		this.list = list;
	}

	public T[][] getList() {
		return list;
	}

	public void setList(T[][] list) {
		this.list = list;
	}
}
