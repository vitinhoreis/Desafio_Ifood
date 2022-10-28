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
         <div class="bar" style="width: 60%;"></div>
      </div>
      <div class="register-form container border border-light">
         <div class="row">
            <div class="col-xs-12">
               <h2 class="page-title ">
                  <span>Valor que reprensenta sua loja</span>
               </h2>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-12">
               <h3 class="page-subtitle ">
                  <span>Os valores da sua loja são suas motivações, 
                  as diretrizes que a guia e faz com que se mantenha ativa no mercado todos os dia. Pode-se dizer também que servem como filosofia da loja, 
                  que deve ser respeitada e seguida por todos os funcionários da loja.</span>
               </h3>
            </div>
         </div>
         <form method="post" action="valores_add.jsp">
            <div class="form-row row">
               <div class="form-group">
                  <label class="form-inputLabel">Valor</label>
                  <textarea  rows="3" name="descricao" class="form-control form-input" required></textarea>
               </div>
            </div>
            <div class="form-row row">
               <div class="form-group">
                  <label>Exemplos pra você se inspirar:</label>
                  <div class="row">
                     <div class="col-11">
                        <input type="text" class="form-control-plaintext" value="Resaturante feito por mulheres comprometido em entregar uma comida com amor e sabor" readonly id="valor1" />
                     </div>
                     <div class="col-1">
                        <img src="resources/images/copy_icon.png" alt="Copiar" title="Copiar Sugestão" onclick="myFunction('valor1')">
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-11">
                        <input type="text" class="form-control-plaintext" value="Fornecer o melhor hamburger da cidade, preparado por ribeirinhos" readonly id="valor2" />
                     </div>
                     <div class="col-1">
                        <img src="resources/images/copy_icon.png" alt="Copiar" title="Copiar Sugestão" onclick="myFunction('valor2')">
                     </div>
                  </div>
                   <div class="row">
                     <div class="col-11">
                        <input type="text" class="form-control-plaintext" value="Ser referência em cozinha de inclusão para a comunidade LGBTQI+" readonly id="valor3" />
                     </div>
                     <div class="col-1">
                        <img src="resources/images/copy_icon.png" alt="Copiar" title="Copiar Sugestão" onclick="myFunction('valor3')">
                     </div>
                  </div>
               </div>
            </div>
            <div class="form-row row">
               <a href="Premiacao.jsp" class="btn btn-secondary">Pular</a>
               <button type="submit" class="btn form-buttonDefault btnIF">Continuar</button>
            </div>
         </form>
      </div>
      <%@ include file="footer.jsp" %>
      <script>
         function myFunction(str) {
           /* Get the text field */
           var copyText = document.getElementById(str);
         
           /* Select the text field */
           copyText.select();
           copyText.setSelectionRange(0, 99999); /* For mobile devices */
         
           /* Copy the text inside the text field */
           navigator.clipboard.writeText(copyText.value);
           
           /* Alert the copied text */
           alert("Sugestão copiada!");
         }
      </script>
   </body>
</html>