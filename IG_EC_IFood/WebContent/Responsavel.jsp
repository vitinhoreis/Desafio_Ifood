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
      <div class="bar" style="width: 50%;"></div>
   </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Responsável legal da loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Informe os dados da pessoa que tem o nome no contrato social da empresa, seja como dona, sócia ou sócia administrativa</span>
               </h3>
            </div>
         </div>
         <form method="post" action="responsavel_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Nome completo</label>
                  <input name="nome" placeholder="João da Silva" autocomplete="off" aria-invalid="true" class="form-control form-input" required>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">CPF</label>
                  <input type="text" class="form-control form-input" placeholder="000.000.000-00"  maxlength="14"   name="cpf" id="cpf" required
                   data-mask="000.000.000-00"
                   data-mask-reverse="true"
                  >
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">RG</label>
                  <input type="text" class="form-control form-input" placeholder="00000000000" required name="rg" required>
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