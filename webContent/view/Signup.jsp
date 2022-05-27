<!DOCTYPE html>
<html>

<head>
    <title>Signup Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Find used and new cars, real estate, jobs and other ads">
    <meta name="keywords" content="Find used, new, cars, real estate, jobs, ads">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/Signup.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<jsp:include page="include/commonHead.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="include/header.jsp" flush="true"></jsp:include>
    
    <section class="section3">
        <form method="post" action="<%= request.getContextPath()%>/register">
            <h3>Sign Up</h3>
            <div class="input-containertwo">
                <i class="fa fa-user-circle-o icontwo"></i>
                <input type="text" placeholder="First Name " name="first_name" class="signupData" required>
            </div>
            <div class="input-containertwo">
                <i class="fa fa-user-circle-o icontwo"></i>
                <input type="text" placeholder="Last Name " name="last_name" class="signupData" required>
            </div>
            <div class="input-containertwo">
                <i class="fa fa-envelope icontwo"></i>
                <input type="email" placeholder="Enter Your Email" name="email" class="signupData" required>
            </div>
            <div class="input-containertwo">
                <i class="fa fa-key icontwo"></i>
                <input type="password" placeholder="Enter Password" name="password" class="signupData" required>
            </div>
            <div class="input-containertwo">
                <i class="fa fa-key icontwo"></i>
                <input type="password" placeholder="Repeat  Password" name="repeated_password" class="signupData" required>
            </div>
            
            <label>
                <input type="checkbox" checked="checked" name="remember" class="remember"> Remember me
            </label>
          
            <div class="input-containertwo">
                <button type="submit" class="SignupBtn">Sign Up</button>
            </div>
        </form>
    </section>
	<jsp:include page="include/footer.jsp"></jsp:include>
    <script src="<%= request.getContextPath()%>/js/MarketTripMainPage.js"></script>
</body>

</html>