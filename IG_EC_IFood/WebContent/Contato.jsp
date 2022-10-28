<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>IFood - Cadastro da loja</title>
      <%@ include file="header.jsp" %>
   </head>
   <body style="BACKGROUND-IMAGE: url(resources/images/imagemIfood.png);">
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Cadastre sua loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Entre e ganhe 1 mês de mensalidade grátis!</span>
               </h3>
            </div>
         </div>
         <form method="post" action="contato_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Nome completo</label>
                  <input name="nome" placeholder="João da Silva" autocomplete="off" aria-invalid="true" class="form-control form-input" required
                  
                  >
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Email</label>
                  <input type="email" class="form-control form-input" placeholder="seuemail@email.com" name="email" 
                  
                    required>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Celular (com DDD)</label>
                  <input type="text" class="form-control form-input" placeholder="(00) 00000-0000" required  maxlength="15" 
                   name="telefone" 
                   id="celular" 
                   data-mask="00 00000-0000" data-mask-reverse="true"
                   >
               </div>
            </div>
            <div class="form-row row">
               <button type="submit" class="btn form-buttonDefault btnIF">Cadastrar agora</button>
            </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>