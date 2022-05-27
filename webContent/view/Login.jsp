<!DOCTYPE html>
<html>

<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Find used and new cars, real estate, jobs and other ads">
    <meta name="keywords" content="Find used, new, cars, real estate, jobs, ads">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<jsp:include page="include/commonHead.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="include/header.jsp" flush="true"></jsp:include>
    
    <section class="section2">
        <form method="post">
            <h3>Sign In</h3>
            <div class="input-container">
                <i class="fa fa-envelope icon"></i>
                <input class="input-field" type="text" placeholder="Email" name="email">
            </div>

            <div class="input-container">
                <i class="fa fa-key icon"></i>
                <input class="input-field" type="password" placeholder="Password" name="password">
            </div>

            <button type="submit" class="btn">Log in</button>
        </form>
    </section>
	<jsp:include page="include/footer.jsp"></jsp:include>
    <script src="<%= request.getContextPath()%>/js/login.js"></script>
</body>

</html>