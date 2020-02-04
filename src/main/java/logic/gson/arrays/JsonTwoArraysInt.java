package logic.gson.arrays;

public class JsonTwoArraysInt {

	private int[] lista;
	private int[] listb;

	public JsonTwoArraysInt(int[] lista, int[] listb) {
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