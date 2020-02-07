package com.lenahartmann00.morpheus_challenges.logic.gson.lists.k;

import java.util.List;
import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;

public class JsonListStringK implements JsonModel {

	private int k;
	private List<String> list;

	public JsonListStringK(int k, List<String> list) {
		this.k = k;
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public int getK() {
		return k;
	}
}
