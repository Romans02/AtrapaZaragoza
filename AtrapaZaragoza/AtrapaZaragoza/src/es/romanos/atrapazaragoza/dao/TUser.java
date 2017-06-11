package es.romanos.atrapazaragoza.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import es.romanos.atrapazaragoza.utils.Constantes;

public class TUser {
	public static boolean compruebaLogin(String email, String pass){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		boolean logueado=false;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			rs =st.executeQuery("select * from usuarios where email = '"+email+"';");
			if(rs.next()){
				if(rs.getString(3).equals(pass)){
					logueado = true;
				}
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
		return logueado;
	}
	public static int getId(String user){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		int id=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			rs =st.executeQuery("select * from usuarios where nombre = '"+user+"';");
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
	public static void monumentoVisitado(String user){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			st.executeUpdate("UPDATE usuarios SET num_monumentos_visitados   = (SELECT num_monumentos_visitados FROM usuarios where nombre='"+user+"')+1 where nombre='"+user+"';");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String register(String user, String pass, String email){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		String resultado;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			st.executeUpdate("insert into usuarios (Nombre, password, num_monumentos_visitados, email) values ('"+user+"', '"+pass+"', "+0+", '"+email+"'");
			con.close();
			resultado = "{'Register':true}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = "{'Register':false}";
		}
		return resultado;
		
	}
	
}
