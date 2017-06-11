package es.romanos.atrapazaragoza.beans;

public class Monumentos {
	private double totalCount,start,rows;
	MonumentoAyuntamiento[] result;
	public double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public double getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public double getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public MonumentoAyuntamiento[] getResult() {
		return result;
	}
	public void setResult(MonumentoAyuntamiento[] result) {
		this.result = result;
	}
	public Monumentos(MonumentoAyuntamiento[] result) {
		this.result = result;
	}
}
