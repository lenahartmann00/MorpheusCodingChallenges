package logic.gson.arrays.k;

import logic.gson.JsonModel;

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