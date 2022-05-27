<%@page import="java.util.List"%>
<%@page import="beans.Post"%>
<%@page import="java.util.ArrayList" %>
<%@page import="helpers.URL" %>
<!DOCTYPE html>
<html>

<head>
    <title>Posts Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Find used and new cars, real estate, jobs and other ads">
    <meta name="keywords" content="Find used, new, cars, real estate, jobs, ads">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/AdsPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<jsp:include page="include/commonHead.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="include/header.jsp" flush="true"></jsp:include>
    <div id="postContainer">
    	<% if(request.getParameter("sub_category") != null) { %>
        <div class="Typ">
            <h2><%=URL.fixTheSearchQuery(request.getParameter("sub_category"))%></h2>
        </div>
        <% }
        List<Post> posts = (List<Post>)request.getAttribute("posts");
        if(posts != null) for(Post post : posts) { %>
        	<div Class="contentContainer">
            <div class="postDiv">
                <p class="postP"><%=post.getContent()%></p>
                <img src="<%=post.getImage()%>" alt="car" class="imgP">
                <p><span style="display: block;">price</span> <%=post.getEmail()%> <%=post.getPhoneNumber()%> <span style="display: block;"><%=post.getSubCategory()%></span></p class="contactP">
            </div>
        <% } %>
    </div>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <script src="<%= request.getContextPath()%>/js/SettingsScript.js"></script>
</body>