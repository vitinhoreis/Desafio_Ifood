<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Premiacao" 
    import="java.sql.Date"
    import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Premiacao - Dados</title>
</head>
<body>
<%
		String nome ="";
		String descricao ="";
		Date data = null;
		int classificacao=0;

if(request.getParameter("nome") != null)
{
	nome = request.getParameter("nome");
}

if(request.getParameter("data") != null)
{
	String result = request.getParameter("data");
	
	SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	 String reformattedStr = myFormat.format(fromUser.parse(result));
	
	 data = java.sql.Date.valueOf(reformattedStr); 
}

		if(request.getParameter("descricao") != null)
		{
			descricao = request.getParameter("descricao");
		}
		
		if(request.getParameter("classificacao") != null)
		{
			classificacao = Integer.parseInt(request.getParameter("classificacao"));
		}

		if((nome != "") && (data != null))
		{
			Premiacao premiacao = new Premiacao();
			premiacao.setDescricao(descricao);
			premiacao.setNome(nome);
			premiacao.setClassificacao(classificacao);
			premiacao.setDatapremio(data);
			
			session.setAttribute("premiacao", premiacao);
			
		}
		
		request.getRequestDispatcher("Finalizar.jsp").forward(request, response);
%>
</body>
</html>