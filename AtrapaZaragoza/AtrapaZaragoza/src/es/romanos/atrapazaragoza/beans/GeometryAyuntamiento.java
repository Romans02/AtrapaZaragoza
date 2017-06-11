package es.romanos.atrapazaragoza.beans;

public class GeometryAyuntamiento {
	private String type;
	private double[] coordinates;
	public GeometryAyuntamiento(String type, double[] coordinates) {
		this.type = type;
		this.coordinates = coordinates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}
}
