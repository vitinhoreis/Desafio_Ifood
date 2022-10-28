<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Responsavel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reponsável - Dados</title>
</head>
<body>
<%
		String nome ="";
		String cpf="";
		String rg="";

		if(request.getParameter("nome") != null)
		{
		   nome = request.getParameter("nome");
		}

		if(request.getParameter("cpf") != null)
		{
			cpf = request.getParameter("cpf");
		}

		if(request.getParameter("rg") != null)
		{
		   rg = request.getParameter("rg");
		}

		if((nome != "")  && (cpf != "") && (rg != ""))
		{
			Responsavel responsavel = new Responsavel();
			responsavel.setNome(nome);
			responsavel.setCpf(cpf);
			responsavel.setRg(rg);
								
			session.setAttribute("responsavel", responsavel);
		}
		
		request.getRequestDispatcher("Localizacao.jsp").forward(request, response);
%>
</body>
</html>