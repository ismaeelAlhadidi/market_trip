<%@page import="java.util.Set" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.HashSet" %>
<%@page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<%
	HashMap<String, Set<String>> categories = (HashMap<String, Set<String>>)request.getSession().getAttribute("categories");
	if(categories == null) {
		categories = new HashMap<String, Set<String>>();
	}
%>
<head>
    <title>Add Post Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Find used and new cars, real estate, jobs and other ads">
    <meta name="keywords" content="Find used, new, cars, real estate, jobs, ads">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Post.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/8e09765b30.js" crossorigin="anonymous"></script>
	<jsp:include page="include/commonHead.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="include/header.jsp" flush="true"></jsp:include>

    <section class="section4">
        <form id="addPostForm" class="form-one" method="post" action="../user">
            <h3 class="title-post">Post Your Ad</h3>
            <div class="input-containertwo">
                <i class="fas fa-ad icontwo "></i>
                <input id="content" type="text" placeholder="Tell People About Your Ad! " name="post-Info" class="signupData" required>
            </div>
            <div class="Picture-container">
                <!-- <img class="Picture-added" src="shopping9.jpg" alt="Shopping" style="width:100%"> -->
                <div class="upload">
                    <img src="<%=request.getContextPath()%>/images/shopping9.jpg" width=1 00 height=1 00 alt="">
                    <div class="round">
                        <input id="image" type="file">
                        <i class="fa fa-camera" style="color: #fff;"></i>
                    </div>
                </div>
            </div>
        </form>
        <hr>
		<div>
        	<section class="categories-box">
	        	<h3>Select Category</h3>
	        	<% for(Map.Entry<String, Set<String>> pair : categories.entrySet()) { %>
			       	<div class="categories">
		                <input class="main-category" type="radio" value="<%=(String)pair.getKey()%>" name="main">
		                <label class="categories-s"><%=(String)pair.getKey()%></label><br><br>
		            </div>
				<% } %>
			</section>
	       	<% for(Map.Entry<String, Set<String>> pair : categories.entrySet()) { %>
	       			<section id="<%=(String)pair.getKey()%>" class="sub-categories-section categories-box">
	       				<h3><%=(String)pair.getKey()%></h3>
		       		<% for(String subCategory : (Set<String>)pair.getValue()) {%>
		       			<div class="categories">
		                    <input name="sub" type="radio" value="<%=subCategory%>">
		                    <label class="categories-s"><%=subCategory%></label><br><br>
		                </div>
		       		<% } %>
		       		</section>
			<% } %>
        </div>
        <hr>
        <form class="form-two" method="post">
            <h3>Select Price</h3>
            <div class="price-div">
                <input type="radio" name="price" id="price" value="Price">
                <label style="font-size:large;" class="categories-s">$ <input id="priceValue" type="text" id="forPrice"></label><br>
                <input type="radio" name="price" id="price" value="Free">
                <label style="font-size:large;" class="categories-s">Free</label><br>
                <input type="radio" name="price" id="price" value="Contact">
                <label style="font-size:large;" class="categories-s">Please Contact</label>
            </div>
        </form>

        <hr>

        <form class="form-three" method="post">
            <h3>Contact Information</h3>
            <div class="contact-div">
                <div class="input-containertwo">
                    <i class="fa fa-envelope icontwo"></i>
                    <input id="email" type="email" placeholder="Enter Your Email" name="uname" class="signupData" required>
                </div>
                <div class="input-containertwo">
                    <i class="fa fa-envelope icontwo"></i>
                    <input id="phoneNumber" type="text" placeholder="Your Phone Number" name="phone-number" class="signupData" required>
                </div>
            </div>

        </form>
        <div class="submit-container">
            <button id="AddPostButton" type="button" class="add-Post-Btn">Add Post</button>
        </div>
    </section>
    <script type="text/javascript">
    	var AddPostUrl = "<%= request.getContextPath()%>/user/post";
    </script>
	<jsp:include page="include/footer.jsp"></jsp:include>
    <script src="<%=request.getContextPath()%>/js/Post.js"></script>
</body>

</html>