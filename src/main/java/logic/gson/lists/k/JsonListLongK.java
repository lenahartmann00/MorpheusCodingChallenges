package logic.gson.lists.k;

import java.util.List;
import logic.gson.JsonModel;

public class JsonListLongK implements JsonModel {

	private long k;
	private List<Long> list;

	public JsonListLongK(int k, List<Long> list) {
		this.k = k;
		this.list = list;
	}

	public long getK() {
		return k;
	}

	public List<Long> getList() {
		return list;
	}
}
