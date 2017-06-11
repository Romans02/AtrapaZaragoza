package es.romanos.atrapazaragoza.beans;

public class MonumentoAyuntamiento {
	private int id;
	private String title;
	private String description;
	private String estilo;
	private String address;
	private String horario;
	private String phone,datacion,pois,datos,price,visita,image,top,foursquare,lastUpdated;
	private GeometryAyuntamiento geometry;
	public MonumentoAyuntamiento(int id, String title, String description, String estilo, String address,
			String horario, String phone, String datacion, String pois, String datos, String price, String visita,
			String image, String top, String foursquare, String lastUpdated, GeometryAyuntamiento geometry) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.estilo = estilo;
		this.address = address;
		this.horario = horario;
		this.phone = phone;
		this.datacion = datacion;
		this.pois = pois;
		this.datos = datos;
		this.price = price;
		this.visita = visita;
		this.image = image;
		this.top = top;
		this.foursquare = foursquare;
		this.lastUpdated = lastUpdated;
		this.geometry = geometry;
	}
	public Monumento toMonumento(){
		GeometryAyuntamiento g = this.geometry;
		return new Monumento(this.title,this.description,0,this.image,g.getCoordinates()[1],g.getCoordinates()[0],this.description);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDatacion() {
		return datacion;
	}
	public void setDatacion(String datacion) {
		this.datacion = datacion;
	}
	public String getPois() {
		return pois;
	}
	public void setPois(String pois) {
		this.pois = pois;
	}
	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getVisita() {
		return visita;
	}
	public void setVisita(String visita) {
		this.visita = visita;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getFoursquare() {
		return foursquare;
	}
	public void setFoursquare(String foursquare) {
		this.foursquare = foursquare;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public GeometryAyuntamiento getGeometry() {
		return geometry;
	}
	public void setGeometry(GeometryAyuntamiento geometry) {
		this.geometry = geometry;
	}
}
