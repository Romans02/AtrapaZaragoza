package es.romanos.atrapazaragoza.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import es.romanos.atrapazaragoza.beans.MonumentoAyuntamiento;
import es.romanos.atrapazaragoza.beans.Monumentos;
import es.romanos.atrapazaragoza.dao.TMonumentos;
import es.romanos.atrapazaragoza.beans.Monumento;

public class Actualizar {

	public static void actualizaBD() {

		URL url;
		Gson gson = new Gson();
		String json="";
		Monumentos monumentos;
		List<Monumento> listaMonumentos;
		MonumentoAyuntamiento[] ma;
		Monumento mo;
		int j;
		boolean existe;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			url = new URL("http://www.zaragoza.es/api/recurso/turismo/monumento.json?rf=html&results_only=true&srsname=wgs84");
			URLConnection urlCon = url.openConnection();
			Scanner scanner = new Scanner(urlCon.getInputStream());

			while(scanner.hasNext()){
				json+=scanner.nextLine();
			}
			
			ma = gson.fromJson(json, MonumentoAyuntamiento[].class);
			listaMonumentos = TMonumentos.getMonumentos();
			for(int i =0; i<ma.length;i++){
				mo = ma[i].toMonumento();
				j=0;
				existe=false;
				if(listaMonumentos.size()>0){
					while(j<listaMonumentos.size() && !existe){
						//optimizar
						if(listaMonumentos.get(j).getNombre().equals(mo.getNombre())){
							existe=true;							
						}
					}
					if(!existe){
						TMonumentos.insert(mo);
					}else{
						TMonumentos.update(mo);
					}
				}else{
					TMonumentos.insert(mo);
				}
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
	}
}
