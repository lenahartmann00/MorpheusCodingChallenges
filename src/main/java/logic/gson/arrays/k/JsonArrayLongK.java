package logic.gson.arrays.k;

import logic.gson.JsonModel;

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