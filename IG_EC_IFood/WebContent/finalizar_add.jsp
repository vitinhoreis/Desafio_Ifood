<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Contato" 
    import="br.com.innovationgroup.ec_ifood.bo.Estabelecimento" 
    import="br.com.innovationgroup.ec_ifood.bo.Endereco" 
    import="br.com.innovationgroup.ec_ifood.bo.Geolocalizacao" 
    import="br.com.innovationgroup.ec_ifood.bo.Valor" 
    import="br.com.innovationgroup.ec_ifood.bo.Premiacao" 
    import="br.com.innovationgroup.ec_ifood.bo.Responsavel" 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finalizacao - Dados</title>
</head>
<body>
<%
		
		int idContato = 0;
		Estabelecimento estab = null;
		Endereco endereco = null;
		Geolocalizacao geolocalizacao = null;
		Valor valor = null;
		Premiacao premiacao = null;
		Responsavel responsavel = null;
		
		int idEstab = 0;

		if(session.getAttribute("idContato") != null)
		{
			idContato = (int) session.getAttribute("idContato");
		}
		
		if(session.getAttribute("estab") != null)
		{
			estab = (Estabelecimento)session.getAttribute("estab");
		
			estab.setCodigoUsuarioCriacao(idContato);
			
			idEstab = estab.AdicionaEstabelecimento();
		}
		
		if(session.getAttribute("valores") != null)
		{
			valor = (Valor)session.getAttribute("valores");
			valor.setCodigoEstabelecimento(idEstab);
			
			valor.AdicionaValor();
		}
		
		if(session.getAttribute("premiacao") != null)
		{
			premiacao = (Premiacao)session.getAttribute("premiacao");
			premiacao.setCodigoEstabelecimento(idEstab);
			
			premiacao.AdicionaPremiacao();
		}
		
		if(session.getAttribute("responsavel") != null)
		{
			responsavel = (Responsavel)session.getAttribute("responsavel");
			responsavel.setCodigoEstabelecimento(idEstab);
			
			responsavel.AdicionaResponsavel();
		}
		
		if(session.getAttribute("geolocalizacao") != null)
		{
			geolocalizacao = (Geolocalizacao)session.getAttribute("geolocalizacao");
			geolocalizacao.setCodigoEstabelecimento(idEstab);
			
			geolocalizacao.AdicionaGeolocalizacao();
		}
		
		if(session.getAttribute("endereco") != null)
		{
			endereco = (Endereco)session.getAttribute("endereco");
			endereco.setCodigoEstabelecimento(idEstab);
			
			endereco.AdicionaEndereco();
		}
		
		request.getRequestDispatcher("Sucesso.jsp").forward(request, response);
%>
</body>
</html>