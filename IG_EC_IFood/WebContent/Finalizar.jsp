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
         <div class="bar" style="width: 100%;"></div>
      </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Última etapa</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Estamos muito felizes que você chegou até aqui. Agora só é preciso ler e aceitar os termos e clicar em Finalizar</span>
               </h3>
            </div>
         </div>
         <form method="post" action="finalizar_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                <p><input type="checkbox" name="terms" required onclick="checkTerms()"> Eu aceito os Termos e Condições</p>
               </div>
            </div>
           <div class="form-row row">
            <button type="submit" class="btn form-buttonDefault btnIF">Finalizar</button>
            </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
      <script>

  let form = document.querySelector("#form");
  let submitForm = document.querySelector("#submit");

  function checkTerms() {
    submitForm.style.cursor = form.terms.checked? "pointer": "not-allowed";
  }

  function checkForm() {
    if(form.terms.checked) {
        form.submit();
      }
    else {
      alert("Por favor, indique que aceita os Termos e Condições");
      form.terms.focus();
    }
  }

</script>
   </body>
</html>