<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Valor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Valores - Dados</title>
</head>
<body>
<%
		String descricao ="";

		if(request.getParameter("descricao") != null)
		{
			descricao = request.getParameter("descricao");
		}

		if((descricao != ""))
		{
			Valor valor = new Valor();
			valor.setDescricao(descricao);
				
			session.setAttribute("valores", valor);
			
		}
		
		request.getRequestDispatcher("Premiacao.jsp").forward(request, response);
%>
</body>
</html>