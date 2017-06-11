package es.romanos.atrapazaragoza.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import es.romanos.atrapazaragoza.beans.Monumento;
import es.romanos.atrapazaragoza.utils.Constantes;

public class TMonumentos {
	public static List<Monumento> getMonumentos(){
		Connection con = null;
		List<Monumento> listaMonumentos = new ArrayList<Monumento>();;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			rs =st.executeQuery("SELECT * FROM `monumentos`");
			while(rs.next()){
				listaMonumentos.add(new Monumento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10)));
			}
			con.close();
		} catch (SQLException e) {
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
		return listaMonumentos;
	}
	public static void update(Monumento mo){
		//TO-DO
	}
	public static int getId(String monumento){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		int id=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			rs =st.executeQuery("select * from Monumentos where nombre = '"+monumento+"';");
			if(rs.next()){
				id = rs.getInt(1);
			}
			con.close();
		} catch (SQLException e) {
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
		return id;
	}
	public static void monumentoVisitado(String monumento){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			st.executeUpdate("UPDATE Monumentos SET num_veces_visitado   = (SELECT num_veces_visitado FROM Monumentos where nombre='"+monumento+"')+1 where nombre='"+monumento+"';");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insert(Monumento mo){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		try {
			con = (Connection) DriverManager.getConnection(sURL,Constantes.ADMIN,Constantes.PASSWORDADMIN);
			st = con.createStatement();
			st.executeUpdate("insert into Monumentos (nombre, descripcion, num_veces_visitado, imagen, latitud, longitud) values ('"+mo.getNombre()+"', '"+mo.getDescripcion()+"', "+mo.getNum_veces_visitado()+", '"+mo.getImagen()+"', "+mo.getLatitud()+", "+mo.getLongitud()+")");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
