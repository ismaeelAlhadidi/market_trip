<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
    <div class="image">
        <img class="img" src="<%= request.getContextPath()%>/images/Logo2.jpeg" alt="Logo">
    </div>
    <div class="TopBar">
    	<% if(session.getAttribute("user") != null) { %>
    		<div class="settingDiv">
                <img src="<%= request.getContextPath()%>/images/Avatari.png" class="settingImg">
               	<select name="Settings" class="SettingsList" onchange="location = this.value;">
               		<option value="<%=request.getContextPath()%>" selected style="display:none"></option>
                	<option value="<%=request.getContextPath()%>/user/post">Add Post</option>
                	<option value="<%=request.getContextPath()%>/user/posts">My Posts</option>
                	<option value="<%=request.getContextPath()%>/user/settings">Account Settings</option>
                	<option value="<%= request.getContextPath()%>/logout">Log Out</option>
           		</select>
            </div>
        <% } else { %>
        <div class="registerdiv">
            <button type="button" id="registerbtn" class="Registerbtn" onclick="window.location.href='<%= request.getContextPath()%>/register'">Register</button>
            <button type="button" id="loginbtn" class="Loginbtn" onclick="window.location.href='<%= request.getContextPath()%>/login'">Log in</button>
        </div>
        <% } %>
        <div class="categoriesBtnDiv">
            <div class="listcontainer">
                <button type="button" onclick="myFunction()" class="btns">Buy & Sell</button>
                <div id="myDropdown" class="dropdown-content">
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Cars">Cars</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Bikes">Bikes</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Clothing">Clothing</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Computers">Computers</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Phones">Phones</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=FreexStuff">Free stuff</a>
                </div>
            </div>
            <div class="listcontainer">
                <button type="button" onclick="myFunction2()" class="btns">Vehicles</button>
                <div id="myDropdown2" class="dropdown-content">
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Carsx_xTrucks">Cars & Trucks</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=ClassicxCars">Classic Cars</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=VehiclexParts,xTiresx_xAccessories">Vehicle Parts, Tires, & Accessories</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=AutomotivexServices">Automotive Services</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Motorcycles">Motorcycles</a>
                </div>
            </div>
            <div class="listcontainer">
                <button type="button" onclick="myFunction3()" class="btns">Real Estate</button>
                <div id="myDropdown3" class="dropdown-content">
                    <a href="<%=request.getContextPath()%>/posts?sub_category=ForxRent">For Rent</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=ForxSale">For Sale</a>
                </div>
            </div>
            <div class="listcontainer">
                <button type="button" onclick="myFunction4()" class="btns">Jobs</button>
                <div id="myDropdown4" class="dropdown-content">
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Accountingx_xManagement">Accounting & Management</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Foodx_xHospitality">Food & Hospitality</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Cleaningx_xHousekeeping">Cleaning & Housekeeping</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=CustomerxService">Customer Service</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Constructionx_xTrades">Construction & Trades</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Graphicx_xWebxDesign">Graphic & Web Design</a>
                </div>
            </div>
            <div class="listcontainer">
                <button type="button" onclick="myFunction5()" class="btns">Services</button>
                <div id="myDropdown5" class="dropdown-content">
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Childcarex_xNanny">Childcare & Nanny</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Cleanersx_xCleaning">Cleaners & Cleaning</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Entertainment">Entertainment</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=MusicxLessons">Music Lessons/a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Fitnessx_xPersonalxTrainer">Fitness & Personal Trainer</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Photographyx_xVideo">Photography & Video</a>
                </div>
            </div>
            <div class="listcontainer">
                <button type="button" onclick="myFunction6()" class="btns">Pets</button>
                <div id="myDropdown6" class="dropdown-content">
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Animalx_xPetxServices">Animal & Pet Services</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Catsx_xKittensxforxRehoming">Cats & Kittens for Rehoming</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Dogsx_xPuppiesxforxRehoming">Dogs & Puppies for Rehoming</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=FishxforxRehoming">Fish for Rehoming</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=Hoursesx_xPoniesxforxRehoming">Horses & Ponies for Rehoming</a>
                    <a href="<%=request.getContextPath()%>/posts?sub_category=PetsxAccessories">Pets Accessories</a>
                </div>
            </div>
        </div>
    </div>
</header>