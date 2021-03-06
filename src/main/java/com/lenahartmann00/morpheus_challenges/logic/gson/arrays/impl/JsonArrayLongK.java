package com.lenahartmann00.morpheus_challenges.logic.gson.arrays.impl;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonArrayLongK implements JsonModel {

	private long k;
	private long[] list;

	public JsonArrayLongK(long k, long[] list) {
		this.k = k;
		this.list = list;
	}

	public long getK() {
		return k;
	}

	public long[] getList() {
		return list;
	}
}