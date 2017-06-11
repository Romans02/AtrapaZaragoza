package es.romanos.atrapazaragoza.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import es.romanos.atrapazaragoza.utils.Constantes;

public class TVersion {
	public static String getVersion(){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		String version="";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(sURL,Constantes.USER,Constantes.PASSWORD);
			st = con.createStatement();
			rs =st.executeQuery("select * from version;");
			if(rs.next()){
				version = rs.getString(1);
			}else{
				version="error";
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			version = "error";
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
		return version;
	}
}
