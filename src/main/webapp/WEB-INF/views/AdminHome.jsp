<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>


<h3></h3>
<div class="row">
   <c:forEach items ="${productList }" var="product">
   <div class ="col-sm-4col-md-3">
     <a href ="<c:url value="/totalProductDiplay/${product.productId}"/>" class ="thumbnail">
      <img src=" <c:url value="/resources/images/ ${product.productId}.png"/>" alt = "Generic placeholder thumbnail">
     
     </a>
  
       <p align="center">${product.productName}</p>
       <p align="center">Price :INR ${product.productPrice}/-</p>
       <p align="center">Stock :${product.productStock}</p>
  
  
  </div>
   </c:forEach>

</div>
</body>
</html>