<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>IFood - Cadastro da loja</title>
      <%@ include file="header.jsp" %>
   </head>
   <body style="BACKGROUND-IMAGE: url(resources/images/imagemIfood.png);">
   <%@ include file="progressheader.jsp" %>
   <div class="progress-bar">
      <div class="bar" style="width: 0%;"></div>
   </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Informações da loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Preencha abaixo as informações sobre sua futura loja no iFood com os dados do seu negócio</span>
               </h3>
            </div>
         </div>
         <form  method="post" action="estabelecimento_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Razão social</label>
                  <input name="razaocnpj" placeholder="Restaurante SA" autocomplete="off" aria-invalid="true" class="form-control form-input" required>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">CNPJ</label>
                  <input type="text" class="form-control form-input" placeholder="00.000.000/0000-00" required  maxlength="18" 
                   name="cnpj"
                   data-mask="00.000.000/0000-00" 
                   data-mask-reverse="true">
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Nome estabelecimento</label>
                  <input name="nomecnpj" placeholder="Restaurante SA" autocomplete="off" aria-invalid="true" class="form-control form-input" required>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Celular (com DDD):</label>
                  <input type="text" class="form-control form-input"
                   placeholder="(00) 00000-0000" required  maxlength="13"  name="telefone"
                   data-mask="00 00000-0000"
                   id="celular">
               </div>
            </div>
            <div class="form-row row">
               <button type="submit" class="btn form-buttonDefault btnIF">Continuar</button>
            </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>