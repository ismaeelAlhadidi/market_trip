<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="<%= request.getContextPath()%>/js/default.js"></script>
<% if(request.getAttribute("error") != null) { %>
<script>
	let temp = () => {
		location = location.href;
	};
	showAlert(`<%=(String)request.getAttribute("error")%>`, temp, temp);
</script>
<% request.setAttribute("error", null); %>
<% } %>