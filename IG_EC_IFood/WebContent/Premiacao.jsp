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
      <div class="bar" style="width: 90%;"></div>
   </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Premiações da loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Nós do iFood honramos sua história e suas conquistas. Caso sua loja tenha recebido algum prêmio de qualidade você pode informar nessa tela</span>
               </h3>
            </div>
         </div>
         <form method="post" action="premiacao_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Nome da Premiação</label>
                  <input type="text" name="nome" placeholder="Melhor pastel de São Paulo 24ª Edição" 
                  autocomplete="off" aria-invalid="true" class="form-control form-input" required>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Data</label>
                  <input type="text" name="data" placeholder="01/05/2021"
                   autocomplete="off" aria-invalid="true" class="form-control form-input"
                   data-mask="00/00/0000" data-mask-reverse="true" maxlenght="10"
                   required id="data">
               </div>
            
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Posição no ranking</label>
                  <input type="number" name="classificacao" placeholder="1" autocomplete="off" aria-invalid="true" class="form-control form-input" required>
               </div>
            </div>
            
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Complemento (opcional)</label>
                  <textarea rows="3" class="form-control"  maxlength="300" placeholder="Ganhamos essa premiação em nosso...." name="descricao"></textarea>
               </div>
            </div>
            <div class="form-row row">
               <a href="Finalizar.jsp" class="btn btn-secondary">Pular</a>
               <button type="submit" class="btn form-buttonDefault btnIF">Continuar</button>
            </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>