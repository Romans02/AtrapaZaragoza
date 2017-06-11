package es.romanos.atrapazaragoza.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import es.romanos.atrapazaragoza.beans.Monumento;
import es.romanos.atrapazaragoza.utils.Constantes;

public class TUsuarios_has_Monumentos {
	public static void insert(int user, int monumento){
		Connection con = null;
		Statement st;
		ResultSet rs;
		String sURL = "jdbc:mysql://localhost:3306/atrapa_zaragoza";
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		try {
			con = (Connection) DriverManager.getConnection(sURL,Constantes.ADMIN,Constantes.PASSWORDADMIN);
			st = con.createStatement();
			st.executeUpdate("insert into usuarios_has_Monumentos (usuarios_id, descripcion, Monumentos_id, fecha_visita) values ('"+user+"', '"+monumento+"', "+currentTime+")");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
