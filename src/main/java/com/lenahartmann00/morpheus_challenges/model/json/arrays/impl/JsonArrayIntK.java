package com.lenahartmann00.morpheus_challenges.model.json.arrays.impl;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;

public class JsonArrayIntK implements JsonModel {

	private int k;
	private int[] list;

	public JsonArrayIntK(int k, int[] list) {
		this.k = k;
		this.list = list;
	}

	public int getK() {
		return k;
	}

	public int[] getList() {
		return list;
	}
}