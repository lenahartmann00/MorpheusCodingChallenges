package com.lenahartmann00.morpheus_challenges.logic.gson.arrays.k;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

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