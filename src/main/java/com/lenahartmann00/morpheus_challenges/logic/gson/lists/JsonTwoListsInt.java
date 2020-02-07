package com.lenahartmann00.morpheus_challenges.logic.gson.lists;

public class JsonTwoListsInt {

	private int[] lista;
	private int[] listb;

	public JsonTwoListsInt(int[] lista, int[] listb) {
		this.lista = lista;
		this.listb = listb;
	}

	public int[] getLista() {
		return lista;
	}

	public int[] getListb() {
		return listb;
	}
}
