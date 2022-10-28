      <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="resources/js/jquery.mask.js"></script>
      <script>
      function goBack(){
    	  window.history.back();
   	  }</script>
   	    	  
   	  <script>  
      var xmlHttp;  
      var xmlHttp;
       function showState(str){

         if (typeof XMLHttpRequest!= "undefined") {
         xmlHttp = new XMLHttpRequest ();
         }
         if (xmlHttp == null) {
         alert ("O navegador não oferece suporte a solicitação XMLHTTP")
         Retorna;
         } 
         var url = "uf_consulta.jsp";
         url +="?cod_UF=" + str;
         xmlHttp.onreadystatechange = stateChange;
         xmlHttp.open("GET", url, true);
         xmlHttp.send(null);
         }
         
         function stateChange() {   
         if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {   
         document.getElementById ("listaCidades"). innerHTML = xmlHttp.responseText   
         }   
         }
      </script>
  <script>
  $(document).ready(function(){
	  $('.data').mask('00/00/0000');
	  $('.time').mask('00:00:00');
	  $('.date_time').mask('00/00/0000 00:00:00');
	  $('.cep').mask('00000-000');
	  $('.phone').mask('0000-0000');
	  $('.celular').mask('(00) 00000-0000');
	  $('.phone_us').mask('(000) 000-0000');
	  $('.mixed').mask('AAA 000-S0S');
	  $('.cpf').mask('000.000.000-00', {reverse: true});
	  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
	  $('.money').mask('000.000.000.000.000,00', {reverse: true});
	  $('.money2').mask("#.##0,00", {reverse: true});
	  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
	    translation: {
	      'Z': {
	        pattern: /[0-9]/, optional: true
	      }
	    }
	  });
	  $('.ip_address').mask('099.099.099.099');
	  $('.percent').mask('##0,00%', {reverse: true});
	  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
	  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
	  $('.fallback').mask("00r00r0000", {
	      translation: {
	        'r': {
	          pattern: /[\/]/,
	          fallback: '/'
	        },
	        placeholder: "__/__/____"
	      }
	    });
	  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});
	});
  </script>
      