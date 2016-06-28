package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
// extends siempre debe de estar si no marcara error aunque no aparezca en java
public class Time extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("hoy es " + new Date());
		out.println("</body>");
		out.println("</html>");
	}
}
