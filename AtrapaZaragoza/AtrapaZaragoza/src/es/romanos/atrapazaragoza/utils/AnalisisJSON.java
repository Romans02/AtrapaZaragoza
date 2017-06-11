package es.romanos.atrapazaragoza.utils;

import es.romanos.atrapazaragoza.dao.TUser;
import es.romanos.atrapazaragoza.dao.TUsuarios_has_Monumentos;
import es.romanos.atrapazaragoza.dao.TVersion;

import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import es.romanos.atrapazaragoza.beans.JSONObject;
import es.romanos.atrapazaragoza.beans.Monumento;
import es.romanos.atrapazaragoza.dao.TMonumentos;

public class AnalisisJSON {
	public static String analizaJson(JSONObject json){
		String cadenaResultado;
		if(json == null){
			json = new JSONObject();
			json.setRequest("getMonumentos");
		}
		switch (json.getRequest()){
		case "login":
			cadenaResultado = login(json.getDatos());
			break;
		case "register":
			cadenaResultado = register(json.getDatos());
			break;
		case "getMonumentos":
			cadenaResultado = getMonumentos();
			break;
		case "setVisita":
			cadenaResultado="";
			setVisita(json.getDatos());
		case "getVersion":
			cadenaResultado = getVersion();
		default:
			cadenaResultado = "{'Error':'Consulta no reconocida'}";
		}
		
		return cadenaResultado;
	}
	
	private static void setVisita(String[] datos){
		TUser.monumentoVisitado(datos[0]);
		TMonumentos.monumentoVisitado(datos[1]);
		TUsuarios_has_Monumentos.insert(TUser.getId(datos[0]), TMonumentos.getId(datos[1]));
	}
	
	private static String getVersion(){
		String resultado;
		
		resultado = TVersion.getVersion();
		
		return resultado;
	}
	
	private static String register(String[] datos){
		String usuario = datos[0];
		String pass = datos[1];
		String email = datos[2];
		
		return TUser.register(usuario,pass,email);
		
	}
	
	private static String login(String[] datos){
		String resultado;
		String pass = datos[1];
		String email = datos[0];
		
		if(TUser.compruebaLogin(email,pass)){
			resultado = "{'Logued':true}";
		}else{
			resultado = "{'Logued':false}";
		}
		
		return resultado;
	}
	
	private static String getMonumentos(){
		Gson gson = new Gson();
		
		return gson.toJson(TMonumentos.getMonumentos());
	}
}
