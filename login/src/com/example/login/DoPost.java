package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

//para este método POST es necesario incluir DoGet
@SuppressWarnings("serial")
public class DoPost extends HttpServlet {
	static String bd = "javatest";
	static String login = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost/" + bd;
	Connection connection = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		try {
			MySqlConnect mysqlConnect = new MySqlConnect();

			// INSERT, UPDATE, DELETE
			// Statement estatuto =
			// mysqlConnect.getConnection().createStatement();
			// estatuto.executeUpdate("INSERT INTO datos (datos) VALUES ('1')");
			// estatuto.close();
			// mysqlConnect.desconectar();

			// SELECT
			PreparedStatement consulta = mysqlConnect.getConnection()
			.prepareStatement("SELECT * FROM datos");
			ResultSet res = consulta.executeQuery();
			PrintWriter out = resp.getWriter();
			while (res.next()) {
			//out.println(res.getString("datos"));
			}
			res.close();
			consulta.close();
			mysqlConnect.desconectar();
		} catch (Exception e) {
			e.printStackTrace();

		}
		if ("java".equals(user) && "java".equals(pass)) {
			response(resp, "login ok");
		} else {
			response(resp, "invalid login");
		}

	}

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>" + "  <body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
