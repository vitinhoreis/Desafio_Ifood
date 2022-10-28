<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"
   
   import="br.com.innovationgroup.ec_ifood.bo.UF"
   import="br.com.innovationgroup.ec_ifood.bo.Cidade"
   import="java.util.List"
   %>
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
         <div class="bar" style="width: 20%;"></div>
      </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Localização da loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle">
                  <span>Preencha as informações de endereço da sua loja.</span>
                  <br/><br/>
                  <span>Caso não tenha um endereço com CEP, você pode usar uma localização geográfica é só clique no botão <strong>Informar GeoCódigo</strong></span>
               </h3>
            </div>
         </div>
         <form  method="post" action="localizacao_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Logradouro</label>
                  <input name="logradouro" type="text" class="form-control form-input" placeholder="Rua da Vila Nova"  required>
               </div>
            </div>
             <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Número (opcional)</label>
                  <input name="numero" type="text" class="form-control form-input" placeholder="15"  >
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Estado</label>
                  <select name="estados" onchange="showState(this.value)">
                   <option value="0"></option> 
                     <% 
                        List<UF> lista = (List<UF>)session.getAttribute("estadosLista");
                     for(int i = 0; i < lista.size(); i++) {
                           UF iestado = lista.get(i);
                        %>
                     <option value=<%=iestado.getCodigo()%>> <%=iestado.getNome()%> </option>
                     <% }  %>
                  </select>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Cidade</label>
                  <select name="listaCidades" id="listaCidades">
                   <option value=''></option> 
                  </select>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">CEP</label>
                  <input type="text" class="form-control form-input" placeholder="00000-000" required  maxlength="9"  
                  name="cep" 
                  id="cep" required
                   data-mask="0000-000" data-mask-reverse="true">
               </div>
            </div>
             <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Complemento (opcional)</label>
                   <textarea rows="3" class="form-control" placeholder="Quiosque 15...." name="complemento"></textarea>
               </div>
            </div>
            <div class="form-row row">
               <a href="Geolocalizacao.jsp" class="btn btn-secondary">Informar GeoCódigo</a>
               <button type="submit" class="btn form-buttonDefault btnIF">Continuar</button>
            </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
     
   </body>
</html>