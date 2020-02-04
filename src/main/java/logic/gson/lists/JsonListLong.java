package logic.gson.lists;

import java.util.List;
import logic.gson.JsonModel;

public class JsonListLong implements JsonModel {

	private long k;
	private List<Long> list;

	public JsonListLong(long k, List<Long> list) {
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
