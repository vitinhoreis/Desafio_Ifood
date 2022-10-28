<%@ page language="java"
    import="br.com.innovationgroup.ec_ifood.bo.Cidade" 
    import="java.util.List" %>
<%   
int cod_UF= Integer.parseInt(request.getParameter("cod_UF"));
String buffer="<select name=''><option value='0'></option>"; 

Cidade cidadeDAO = new Cidade();
List<Cidade> cidades = cidadeDAO.ListarCidades(cod_UF);

for(int i = 0; i < cidades.size(); i++) {
   Cidade cidade = cidades.get(i);
    buffer=buffer+"<option value='"+cidade.getCodigo()+"'>"+cidade.getNome()+"</option>";  
}
   
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 %>
 
