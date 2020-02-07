package com.lenahartmann00.morpheus_challenges.logic.gson.lists;

import java.util.List;

public class JsonList<T> {

	private List<T> list;

	public JsonList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}
}
