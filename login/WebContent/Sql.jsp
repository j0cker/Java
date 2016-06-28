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
    include: Incluye el contenido de un fichero en la página mediante el atributo file.

    @ include file="cabecera.html"

     -->

	<!-- Directiva Importa clases y paquetes Java para ser utilizadas dentro del fichero JSP. 
	     ONE
	     page import="java.sql.*"
	     MORE THAN ONE
	     page import="java.sql.*, com.example.login.clase"
	-->

	<%@ page import="java.sql.*, com.example.login.MySqlConnect"%>

	<!-- Nos permiten declarar variables, funciones y datos estáticos. -->

	<%!static String bd = "javatest";
	static String login = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost/" + bd;
	Connection connection = null;%>

	<!-- Los scriptlets son partes de código Java incrustadas entre los elementos estáticos de la página. -->

	<%
		MySqlConnect mysqlConnect = new MySqlConnect();
		PreparedStatement consulta = mysqlConnect.getConnection()
				.prepareStatement("SELECT * FROM datos");
		ResultSet res = consulta.executeQuery();
		while (res.next()) {
	%>

	<!-- Las expresiones se evalúan dentro de la servlet. No deben acabar en ";". -->

	<%=res.getString("datos")%>

	<!-- Los scriptlets son partes de código Java incrustadas entre los elementos estáticos de la página. -->

	<%
		}
		res.close();
		consulta.close();
		mysqlConnect.desconectar();
	%>
</body>
</html>