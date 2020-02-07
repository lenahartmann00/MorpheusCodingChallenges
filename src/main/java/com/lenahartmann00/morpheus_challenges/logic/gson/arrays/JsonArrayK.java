package com.lenahartmann00.morpheus_challenges.logic.gson.arrays;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonArrayK<T> implements JsonModel {

	private T k;
	private T[] list;

	public JsonArrayK(T k, T[] list) {
		this.k = k;
		this.list = list;
	}

	public T getK() {
		return k;
	}

	public void setK(T k) {
		this.k = k;
	}

	public T[] getList() {
		return list;
	}

	public void setList(T[] list) {
		this.list = list;
	}
}
