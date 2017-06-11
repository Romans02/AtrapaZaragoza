package es.romanos.atrapazaragoza.beans;

public class Monumento {
	private int id;
	private String nombre;
	private String descripcion;//mas adelante convertirlo a array de bytes
	private int num_veces_visitado;
	private String imagen;
	private String audio;
	private String descripcion_corta;
	private double latitud;
	private double longitud;
	private String mas_info;
	public Monumento(int id, String nombre, String descripcion, int num_veces_visitado, String imagen, String audio,
			String descripcion_corta, double latitud, double longitud, String mas_info) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.num_veces_visitado = num_veces_visitado;
		this.imagen = imagen;
		this.audio = audio;
		this.descripcion_corta = descripcion_corta;
		this.latitud = latitud;
		this.longitud = longitud;
		this.mas_info = mas_info;
	}
	public Monumento(String nombre, String descripcion, int num_veces_visitado, String imagen,
			 double latitud, double longitud, String mas_info) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.num_veces_visitado = num_veces_visitado;
		this.imagen = imagen;
		this.latitud = latitud;
		this.longitud = longitud;
		this.mas_info = mas_info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNum_veces_visitado() {
		return num_veces_visitado;
	}
	public void setNum_veces_visitado(int num_veces_visitado) {
		this.num_veces_visitado = num_veces_visitado;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getDescripcion_corta() {
		return descripcion_corta;
	}
	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public String getMas_info() {
		return mas_info;
	}
	public void setMas_info(String mas_info) {
		this.mas_info = mas_info;
	}
}
