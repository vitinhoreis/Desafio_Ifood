<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"
    import="br.com.innovationgroup.ec_ifood.bo.Contato"
    import="br.com.innovationgroup.ec_ifood.bo.Estabelecimento"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>IFood - Cadastro da loja</title>
      <%@ include file="header.jsp" %>
   </head>
   <body style="BACKGROUND-IMAGE: url(resources/images/sucesso.jpeg);">
     <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Parabéns!!!</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                 <p>Seja bem vindo ao iFood <% Contato contato= (Contato)session.getAttribute("contato");
                 contato.getNome();%>.
                 </p>
                 <p>A sua loja <% Estabelecimento estab= (Estabelecimento)session.getAttribute("estab");
                 estab.getNome();%> será um sucesso. Conte conosco!
                 </p>
               </h3>
            </div>
         </div>
      <%@ include file="footer.jsp" %>
    </body>
</html>