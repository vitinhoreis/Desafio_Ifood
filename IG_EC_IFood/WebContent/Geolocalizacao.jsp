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
      <div class="bar" style="width: 30%;"></div>
   </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Localiza��o da loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Um geoc�digo � um c�digo que representa uma localiza��o geogr�fica, voc� pode usa-lo para informar uma localiza��o que n�o possui CEP, por exemplo.</span>
                  <br/><br/>
                  <span>Caso voc� tenha informado um endere�o na p�gina anterior e n�o quiser informar o GeoC�digo, clique no bot�o <strong>Pular</strong></span>
               </h3>
            </div>
         </div>
         <form  method="post" action="geolocalizacao_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">GeoC�digo</label>
                  <a href="https://support.google.com/maps/answer/7047426?hl=pt-BR&co=GENIE.Platform%3DAndroid"
                  target="_blank">Como conseguir um GeoC�digo?</a>
                  <input name="geoCode" placeholder="8F9R+RQ Campeche, Florian�polis - SC" autocomplete="off" aria-invalid="true" class="form-control form-input" required>
               </div>
            </div>
                        <div class="form-row row">
                        </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Complemento</label>
                   <textarea rows="3" class="form-control" placeholder="Quiosque do pastel" name="complemento"></textarea> 
               </div>
            </div>
           <div class="form-row row">
            <a href="Responsavel.jsp" class="btn btn-secondary">Pular</a>
            <button type="submit" class="btn form-buttonDefault btnIF">Continuar</button>
           </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>