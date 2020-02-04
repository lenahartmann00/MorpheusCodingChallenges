package logic.gson.lists.k;

import java.util.List;
import logic.gson.JsonModel;

public class JsonListIntK implements JsonModel {

	private int k;
	private List<Integer> list;

	public JsonListIntK(int k, List<Integer> list) {
		this.k = k;
		this.list = list;
	}

	public long getK() {
		return k;
	}

	public List<Integer> getList() {
		return list;
	}
}
