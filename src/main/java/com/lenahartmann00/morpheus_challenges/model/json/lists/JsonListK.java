package com.lenahartmann00.morpheus_challenges.model.json.lists;

import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;
import java.util.List;

public class JsonListK<T> implements JsonModel {

	private T k;
	private List<T> list;

	public JsonListK(T k, List<T> list) {
		this.k = k;
		this.list = list;
	}

	public T getK() {
		return k;
	}

	public List<T> getList() {
		return list;
	}
}
