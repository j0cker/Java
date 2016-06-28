package com.example.login;

import java.sql.*;

public class MySqlConnect {
	static String bd = "javaTest";
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + bd;
	Connection connection = null;

	public MySqlConnect() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connection = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}

	/** Permite retornar la conexión */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}
