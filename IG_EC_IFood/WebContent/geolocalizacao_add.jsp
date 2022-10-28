<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Geolocalizacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geolocalizacao - Dados</title>
</head>
<body>
<%
		String geoCode ="";
	    String compelemento="";

		if(request.getParameter("geoCode") != null)
		{
			geoCode = request.getParameter("geoCode");
		}

		if(request.getParameter("compelemento") != null)
		{
			compelemento = request.getParameter("compelemento");
		}

		if(geoCode != "")
		{
			Geolocalizacao geo = new Geolocalizacao();
			geo.setGeoCode(geoCode);
			geo.setComplemento(compelemento);
		
			session.setAttribute("geolocalizacao", geo);
		}
		
		request.getRequestDispatcher("Valores.jsp").forward(request, response);
%>
</body>
</html>