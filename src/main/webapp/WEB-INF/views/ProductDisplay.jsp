<%@page language="java" contentType="text/html"%>

<%@include file="/WEB-INF/views/Header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class ="row">

<c:forEach items=" ${productList}" var="product">

<div class ="col-sm-4 col-md-3">

   <a href ="<c:url value="/totalProductDisplay/${product.productId }"/> " class="thumbnail">
 
   <img src=" <c:url value="/resources/images/ ${product.productId}.jpg"/>" alt = "Generic placeholder thumbnail">
 
    </a>   

       <p align="center"> ${product.productName}</p>
       <p align="center"> ${product.productPrice}</p>
       <p align="center"> ${product.productStock}</p>

</div>
</c:forEach>
</div>
