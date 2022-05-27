<%@page import="beans.User"%>
<!DOCTYPE html>
<html>

<head>
    <title>Account Settings</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Find used and new cars, real estate, jobs and other ads">
    <meta name="keywords" content="Find used, new, cars, real estate, jobs, ads">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/SettingsStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<jsp:include page="include/commonHead.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="include/header.jsp" flush="true"></jsp:include>
    <section class="section4">
        <form method="post">
            <h3>Account Settings</h3>
            <div class="input-containerthree">
                <i class="fa fa-user-circle-o iconthree"></i>
                <input type="text" name="first_name" placeholder="Your First Name  " class="settingsData" value="<%=((User)session.getAttribute("user")).getFirstName() %>" required>
            </div>

            <div class="input-containerthree">
                <i class="fa fa-envelope iconthree"></i>
                <input type="email" placeholder="Your Email " name="email" class="settingsData" value="<%=((User)session.getAttribute("user")).getEmail() %>" required>
            </div>

            <div class="input-containerthree">
                <i class="fa fa-home iconthree"></i>
                <input type="text" placeholder="Street Address or Postal Code " name="address" class="settingsData" value="<%=(((User)session.getAttribute("user")).getAddress() == null ? "" : ((User)session.getAttribute("user")).getAddress())%>">
            </div>

            <div class="input-containerthree">
                <i class="fa fa-phone iconthree"></i>
                <input type="number" placeholder="Enter Your Phone Number " name="phone_number" class="settingsData" value="<%=(((User)session.getAttribute("user")).getPhoneNumber() == null ? "" : ((User)session.getAttribute("user")).getPhoneNumber())%>">
            </div>

                <div class="PSW">
                    <button type="button" class="changesPswBtn" onclick="window.location.href='<%=request.getContextPath()%>/user/change_password'">Change Password</button>
                    <button type="button" onclick="document.location.reload();" class="cancelbtn">Cancel</button>
                </div>

                <div class="clearfix ">
                    <button type="submit" class="changesBtn">Save Changes</button>
                </div>
            </div>
        </form>

    </section>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <script src="<%= request.getContextPath()%>/js/SettingsScript.js "></script>
</body>

</html>