<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Endereco"
    import="br.com.innovationgroup.ec_ifood.bo.Geolocalizacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Localizacao</title>
</head>
<body>
<%
String nome ="";
		long cep=0;
		String logradouro="";
		String endereco="";
		int cidade=0;
		String complemento="";
		
				
		if(request.getParameter("logradouro") != null)
		{
		   logradouro = request.getParameter("logradouro");
		}
		
		if(request.getParameter("endereco") != null)
		{
		   endereco = request.getParameter("endereco");
		}
		

		if(request.getParameter("complemento") != null)
		{
			complemento = request.getParameter("complemento");
		}
		
		if(request.getParameter("listaCidades") != null)
		{
			cidade = Integer.parseInt(request.getParameter("listaCidades"));
		}

		if(request.getParameter("cep") != null)
		{
		  String result =  request.getParameter("cep").replaceAll("[\\-\\+\\.\\^:,]","");
		  cep = Long.parseLong(result);
		}
		
		if((logradouro != "") && (cidade != 0)  && (cep != 0))
		{	
			Endereco local = new Endereco();
			local.setLogradouro(logradouro);
			local.setCidade(cidade);
			
			session.setAttribute("endereco", local);
		}
		
		request.getRequestDispatcher("Geolocalizacao.jsp").forward(request, response);
%>
</body>
</html>