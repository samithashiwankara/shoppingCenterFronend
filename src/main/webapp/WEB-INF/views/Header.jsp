<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html> 
<head>
<meta charest="ISO-8859-1">
<title>${pageinfo}-Fashion</title>
<meta name=viewport content="width=device-width ,intial-scole=1">
<link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://ajax/googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script src="http://maxcdn.bootstrapcdn.com/bootsrap/3.3.1/js/bootstrap.min.js" ></script>


</head>
<body>

<div class="cantainer">


    <nav class="navbar navbar-inverse">
       <div class="cantainer-fluid">
         <div class="navbar-header">
            <a class="navbar-brand" href="#">Fashion world </a>  
         </div>
       
        <c:if test="${sessionScope.loggedIn}">
        <ul class="nav navbar-nav">
         <li><a href="<c:url value='/Login'/>">LOGIN </a></li>
           <li><a href="<c:url value='/register'/>">REGISTER </a></li>
           <li><a href="<c:url value='/Contact us'/>">Contact US </a></li>
           <li><a href="<c:url value='/about us'/>">About US </a></li>
         </ul>
        </c:if>
       
    <c:if test="${sessionScope.loggedIn }">
        <c:if test="{sessionScope.role=='Role_Admin'}">
          
          <li><a href="<c:url value='/adminHome'/>"> Home</a></li>
          <li><a href="<c:url value='/product'/>"> Manage Product</a></li>
          <li><a href="<c:url value='/category'/>">Manage Category</a></li>
          <li><a href="<c:url value='/productDisplay'/>">Product Catalog</a></li>
          <li><a href="<c:url value='/cart'/>">Cart</a></li>
         </ul>
      </c:if>
      
      
      
        <c:if test="{sessionScope.role=='Role_USER'}"> 
       		 <ul class="dropdown-menu">
      
           		<li><a href="<c:url value='/userHome'/>">Home</a></li>
           		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">CATEGORY<span class="caret"></span></a>
      
          <ul class="dropdown-menu">
           
          		 <li><a herf="<c:url value='/mens'/">Men's</a></li>
	     		  <li><a herf="<c:url value='/productDiplay'/">Women's</a></li>
	      		 <li><a herf="<c:url value='/productDispaly'/">Kid's</a></li>
          </ul>
      		</li>
     		 </ul>
     
      
    
			       <li> <a href="<c:url value ='/about us'/>" > About US </a></li>
			       <li> <a href="<c:url value='/Contact us'/>">Contact US </a></li>
			       <li> <a href="<c:url value='/cart'/>">Cart </a></li>
       

    </c:if>
    </c:if>s
        
    
       <c:if test="${sessionScope.logged }">
       <div class="nav navbar-nav navbar-right">
       <font color="white" face="calibri" size="2"> Welcome:${sessionScope.username} </font>
       <a href="<c:url='/perform_Logout'/>" class="btn btn-danger">LOGOUT</a>
       
       </div>
      </c:if>
       
        
    
   </div>
 </nav>
</div>
</body>
</html>