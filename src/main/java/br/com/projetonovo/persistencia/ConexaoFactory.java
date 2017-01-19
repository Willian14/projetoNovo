package br.com.projetonovo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConnection(){
		 			try {
		 				Class.forName("org.postgresql.Driver");
		 				return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoproj3","postgres","210100");
		 			} catch (SQLException e) {
		 				// TODO Auto-generated catch block
		 				throw new RuntimeException(e);
		 			} catch (ClassNotFoundException e) {
		 				// TODO Auto-generated catch block
		 				throw new RuntimeException(e);
		 			}
		 	}

}
