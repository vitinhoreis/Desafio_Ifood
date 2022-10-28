<%@ page language="java"%>
<%
	Thread.sleep(20000); // sleep 5 seconds
    session.invalidate(); 
    response.sendRedirect(request.getContextPath() + "/Contato.jsp"); 
            
%>