package es.romanos.atrapazaragoza.beans;
import java.util.LinkedList;
import java.util.List;

public class JSONObject {
	private String request;
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String[] getDatos() {
		return datos;
	}
	public void setDatos(String[] datos) {
		this.datos = datos;
	}
	private String datos[];

    
    public JSONObject(){}
    public JSONObject(String r, String[] d){
    	this.request=r;
    	this.datos=d;
    }
    
}
