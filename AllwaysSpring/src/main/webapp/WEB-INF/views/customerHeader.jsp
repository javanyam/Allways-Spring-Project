<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
	
	
<meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="Free HTML Templates" name="keywords">
  <meta content="Free HTML Templates" name="description">

   <!-- Favicon -->
<link href="../img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="../lib/animate/animate.min.css" rel="stylesheet">
<link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="../lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="../css/style.css" rel="stylesheet">

<style type="text/css">

  #center {
		padding: 30px 15px;
		font-weight: 400;
		letter-spacing: 1px;
		color: #FF8888;
		outline: none;
		font-family: 'Baloo Tammudu 2';
		font-style: normal;
		font-weight: 400;
		font-size: 19px;
		line-height: 69px;
		display: flex;
   }
  
  #Line{
		position: absolute;
		width: 1337px;
		height: 0px;
		border: 2px solid #FECACA;

	}
  
  .dropdown-toggle::after {
  display: inline-block;
  margin-left: 0.255em;
  vertical-align: 0.255em;
  content: "";
  margin-top: 25px;
  border-top: 0.3em;
  border-right: 0.3em solid transparent;
  border-bottom: 0;
  border-left: 0.3em transparent;
}

.dropdown-item:hover, .dropdown-item:focus {
  color: #F9A392;
  text-decoration: none;
  background-color: #f8f9fa;
}
 
.dropdown-menu {
position: absolute;
  top: 100%;
  left: 0;
  z-index: 1000;
  display: none;
  float: left;
  min-width: 10rem;
  padding: 0.5rem 0;
  margin: 0.125rem 0 0;
  font-size: 1rem;
  color: #757575;
  text-align: center;
  list-style: none;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px rgba(0, 0, 0, 0.15);
}

 
 </style>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="../lib/easing/easing.min.js"></script>
<script src="../lib/waypoints/waypoints.min.js"></script>
<script src="../lib/counterup/counterup.min.js"></script>
<script src="../lib/owlcarousel/owl.carousel.min.js"></script>
<script src="../lib/tempusdominus/js/moment.min.js"></script>
<script src="../lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="../lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Contact Javascript File -->
<script src="../mail/jqBootstrapValidation.min.js"></script>
<script src="../mail/contact.js"></script>

<!-- Template Javascript -->
<script src="../js/main.js"></script>
    
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function logout() {
		var form = document.loginokay;
		form.action = "customerLogout";
		form.submit();
	}
	
</script>

<script type="text/javascript">
function signup() {
	var form=document.loginbtn;
	form.action="http://localhost:8080/Allways/Customer/customerJoin";
	form.submit();
}</script>


</head>
<body>
	<c:if test="${ID == null}">
	<form name="nullcustomer">
	  <div class="container-fluid bg-light d-none d-lg-block">
        <div class="row py-2 px-lg-5">
            <div class="col-lg-6 text-left mb-2 mb-lg-0">
                <div class="d-inline-flex align-items-center">
                    <small><i class="fa fa-phone-alt mr-2"></i>0507 1234 5678</small>
                    <small class="px-3">|</small>
                    <small><i class="fa fa-envelope mr-2"></i>allwayscake@example.com</small>
                </div>
            </div>
            <div class="col-lg-6 text-right">
                <div class="d-inline-flex align-items-center">
                	<a class="text-primary pl-2" href="customerJoinPage">
                        <i class="text-primary pl-2">JOIN</i>
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;
                	<a class="text-primary pl-2" href="customerLoginPage">
                        <i class="text-primary pl-2">LOGIN</i>
                    </a>
                </div>
            </div>
        </div>
    </div>
    
	
	<div class="container-fluid p-0">
	    <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0 px-lg-5">
	       <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse">
	            <div class="navbar-nav m-auto py-0">
		            <a href="customerAboutPage" class="navbar-brand ml-lg-3">
		       			 <img src="./images/HeaderLogo.png"><!-- style="padding-left: 90px;" -->
		        	</a>
	                <a href="customerAboutPage" id="center" class="nav-item nav-link active">HOME</a>
	                <a href="customerCakeList" id="center" class="nav-item nav-link active">CAKE</a>
	                <a href="customerBoardList" id="center" class="nav-item nav-link">BOARD</a>
	                <a href="customerLocationPage" id="center" class="nav-item nav-link">LOCATION</a>
	          		<!--   <a href="" id="center" class="nav-item nav-link" style="width: 300px;"></a> -->
	                <a href="customerCartList" id="center" class="nav-item nav-link">CART</a>
	                
	                
	            </div>
	        </div>
	    </nav>
					 <hr id="Line" style="right: 0px; left: 40px; margin-top: 0px;">
	</div>
	</form>
	</c:if>
	
	<c:if test="${ID!=null}">
	<form name="loginokay">
	  <div class="container-fluid bg-light d-none d-lg-block">
        <div class="row py-2 px-lg-5">
            <div class="col-lg-6 text-left mb-2 mb-lg-0">
                <div class="d-inline-flex align-items-center">
                    <small><i class="fa fa-phone-alt mr-2"></i>0507 1234 5678</small>
                    <small class="px-3">|</small>
                    <small><i class="fa fa-envelope mr-2"></i>allwayscake@example.com</small>
                </div>
            </div>
            <div class="col-lg-6 text-right">
                <div class="d-inline-flex align-items-center">
                    <a class="text-primary pl-2" href="customerMypagePage">
                        <i class="">${NAME}님 환영합니다!&nbsp;&nbsp;&nbsp;</i>
                    </a>
                    <input type="button" class="text-primary pl-2" onclick="logout()" value="LOGOUT">
                </div>
            </div>
        </div>
    </div>
	
	<div class="container-fluid p-0">
	    <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0 px-lg-5">
	       <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	       	 	<div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse">
	            <div class="navbar-nav m-auto py-0">
		            <a href="customerAboutPage" class="navbar-brand ml-lg-3">
		       			 <img src="./images/HeaderLogo.png">
		        	</a>
	                <a href="customerAboutPage" id="center" class="nav-item nav-link active">HOME</a>
	                <a href="customerCakeList" id="center" class="nav-item nav-link active">CAKE</a>
	                <a href="customerBoardList" id="center" class="nav-item nav-link">BOARD</a>
	                <a href="customerLocationPage" id="center" class="nav-item nav-link" >LOCATION</a>
	                <a href="customerCartList" id="center" class="nav-item nav-link">CART</a>
	                
	              
	            </div>
	        </div>
	    </nav>
		 <hr id="Line" style="right: 0px; left: 40px; margin-top: 0px;">
	</div>
	</form>
	</c:if>


</body>
