<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- 
    include: Incluye el contenido de un fichero en la p�gina mediante el atributo file.

    @ include file="cabecera.html"

     -->

	<!-- Directiva Importa clases y paquetes Java para ser utilizadas dentro del fichero JSP. 
	     ONE
	     page import="java.sql.*"
	     MORE THAN ONE
	     page import="java.sql.*, com.example.login.clase"
	-->

	<%@ page import="java.sql.*, com.example.login.MySqlConnect"%>

	<!-- Nos permiten declarar variables, funciones y datos est�ticos. -->

	<%!static String bd = "javatest";
	static String login = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost/" + bd;
	Connection connection = null;%>

	<!-- Los scriptlets son partes de c�digo Java incrustadas entre los elementos est�ticos de la p�gina. -->

	<%
		MySqlConnect mysqlConnect = new MySqlConnect();
		PreparedStatement consulta = mysqlConnect.getConnection()
				.prepareStatement("SELECT * FROM datos");
		ResultSet res = consulta.executeQuery();
		while (res.next()) {
	%>

	<!-- Las expresiones se eval�an dentro de la servlet. No deben acabar en ";". -->

	<%=res.getString("datos")%>

	<!-- Los scriptlets son partes de c�digo Java incrustadas entre los elementos est�ticos de la p�gina. -->

	<%
		}
		res.close();
		consulta.close();
		mysqlConnect.desconectar();
	%>
</body>
</html>