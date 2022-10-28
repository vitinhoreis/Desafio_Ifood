<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Contato"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contato - Dados</title>
</head>
<body>
<%
		String nome ="";
		String telefone="";
		String email="";
		int idContato = 0;

		if(request.getParameter("nome") != null)
		{
		   nome = request.getParameter("nome");
		}

		if(request.getParameter("telefone") != null)
		{
			telefone =  request.getParameter("telefone").replaceAll("[^\\d ]","");		
			telefone =  telefone.replaceAll("\\s+","");
		}

		if(request.getParameter("email") != null)
		{
		   email = request.getParameter("email");
		}

		if((nome != "")  && (email != "") & (telefone != ""))
		{
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setTelefone(telefone);
			contato.setEmail(email);
			
			idContato = contato.AdicionaContato();
							
			session.setAttribute("idContato", idContato);
			session.setAttribute("contato", contato);
			
		}
		
		request.getRequestDispatcher("Estabelecimento.jsp").forward(request, response);
%>
</body>
</html>