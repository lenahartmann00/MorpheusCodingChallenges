package com.lenahartmann00.morpheus_challenges.logic.gson.arrays.impl;

import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonArrayStringK implements JsonModel {

	private long k;
	private String[] list;

	public JsonArrayStringK(long k, String[] list) {
		this.k = k;
		this.list = list;
	}

	public long getK() {
		return k;
	}

	public String[] getList() {
		return list;
	}
}
