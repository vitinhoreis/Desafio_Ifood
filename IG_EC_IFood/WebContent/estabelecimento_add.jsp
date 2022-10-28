<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Estabelecimento" 
    import="br.com.innovationgroup.ec_ifood.bo.UF"
    import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estabelecimento - Dados</title>
</head>
<body>
<%
String nome ="";
		String cnpj="";
		String nomecnpj="";
		String razaocnpj="";
		String telefone="";
		
		if(request.getParameter("cnpj") != null)
		{
			cnpj =  request.getParameter("cnpj").replaceAll("[^\\d ]","");			
		}
		
		if(request.getParameter("nomecnpj") != null)
		{
			nomecnpj = request.getParameter("nomecnpj");
		}
				
		if(request.getParameter("razaocnpj") != null)
		{
			razaocnpj = request.getParameter("razaocnpj");
		}

		if(request.getParameter("telefone") != null)
		{
           telefone =  request.getParameter("telefone").replaceAll("[\\-\\+\\.\\^:,]","");
		   //telefone = Double.parseDouble(request.getParameter("result"));
		}

		if((cnpj != "")  && (nomecnpj != "")  && (razaocnpj != ""))
		{
			Estabelecimento estab = new Estabelecimento();
			estab.setCnpj(cnpj);
			estab.setNome(nomecnpj);
			estab.setRazaoSocial(razaocnpj);
			estab.setTelefone(telefone);
			
			session.setAttribute("estab", estab);
		}
		
        UF uf = new UF();
        List<UF> lista = uf.Listar();
        
        session.setAttribute("estadosLista", lista);
        
		request.getRequestDispatcher("Responsavel.jsp").forward(request, response);
%>
</body>
</html>