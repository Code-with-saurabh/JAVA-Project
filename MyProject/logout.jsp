<%@ page session="true" %>
<%
    
    HttpSession userSession = request.getSession(false);
    if (userSession != null) {
        userSession.invalidate();
    }
    
    response.sendRedirect("/MyProject/");
%>