<!DOCTYPE html>
<html>

<head>
    <title>Change Password Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Find used and new cars, real estate, jobs and other ads">
    <meta name="keywords" content="Find used, new, cars, real estate, jobs, ads">
    <link rel="stylesheet" href="../css/changePSW.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<jsp:include page="include/commonHead.jsp"></jsp:include>
</head>

<body>

	<jsp:include page="include/header.jsp" flush="true">
    	<jsp:param name="prefixUrl" value="../"/>
    	<jsp:param name="isAuth" value="yes"/>
    </jsp:include>

    <section class="section5">
        <form method="post">
            <h3>Change Password</h3>
            <div class="input-containerfour">
                <i class="fa fa-key iconfour"></i>
                <input type="password" name="old_password" placeholder="Old Password" class="new-password-data">
            </div>

            <div class="input-containerfour">
                <i class="fa fa-key iconfour"></i>
                <input type="password" name="new_password" placeholder="New Password" class="new-password-data">
            </div>

                <div class="PSW">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/user/settings'" class="cancelbtn">Cancel</button>
                </div>

                <div class="clearfix ">
                    <button type="submit" class="changesBtn">Save Changes</button>
                </div>
            </div>
        </form>
    </section>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <script src="<%= request.getContextPath()%>/js/changePSW.js "></script>
 </body>
 </html>