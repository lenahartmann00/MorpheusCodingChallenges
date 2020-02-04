package logic.gson.lists;

import java.util.List;
import logic.gson.JsonModel;

public class JsonListString implements JsonModel {

	private int k;
	private List<String> list;

	public JsonListString(int k, List<String> list) {
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
