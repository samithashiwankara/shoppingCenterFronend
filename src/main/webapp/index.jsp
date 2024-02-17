<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<BODY>

<div class="container">

<h2>HOME Page</h2>
    <div id="myCarousel" calss="carousel slide" data-ride-"carousel">
        <!-- Indicators -->
        <ol class ="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
         <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2" ></li>
        
        </ol>
        <!-- Wrapper for slides-->
        
        <div class="carousel-inner">
        
        <div class="item active">
                 <img  src="<c:url value='resources/images/image.jpg'/>"alt="Los Angeles" style="width:100%;">
        </div>
        
        <div class="item ">
                 <img  src="<c:url value='resources/images/wc.banner.jpg'/>"alt="Chicago" style="width:100%;">
        </div>
        
        <div class="item ">
                 <img  src="<c:url value='resources/images/winter ware.jpg'/>"alt="Chicago" style="width:100%;">
        </div>
        
        <div class="item ">
                 <img  src="<c:url value='resources/images/mobile.jpg'/>" alt="Chicago" style="width:100%;">
        </div>
        
        <div class="item ">
                 <img  src="<c:url value='resources/images/Big bazoar.jpg'/>"alt="New york" style="width:100%;">
        </div>
        
        </div>
        
        <!-- Left and right controls -->
        
        <a class="left carousel-control" href="#myCaousel" data-silde="prev">
        <span class="glyphicon glyphicom-chevron-Left"></span>
        <span class="sr-only">Previous</span>
        </a>
        
        
       <a class="right carousel-control" href="#myCaousel" data-silde="prev">
        <span class="glyphicon glyphicom-chevron-right"></span>
        <span class="sr-only">Next</span>
        </a> 
        
    
    
    
    
    </div>


</div>
<h3>Home Page!</h3>
</BODY>
</HTML>