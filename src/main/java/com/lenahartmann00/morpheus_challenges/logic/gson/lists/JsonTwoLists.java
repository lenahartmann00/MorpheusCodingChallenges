package com.lenahartmann00.morpheus_challenges.logic.gson.lists;

import java.util.List;

public class JsonTwoLists<T> {

	private List<T> lista;
	private List<T> listb;

	public JsonTwoLists(List<T> lista, List<T> listb) {
		this.lista = lista;
		this.listb = listb;
	}

	public List<T> getLista() {
		return lista;
	}

	public List<T> getListb() {
		return listb;
	}
}
