<%@page language="java" contentType="text/html"%>

<%@include file="Header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<br><br>


<form action="<c:url value="/addTocart/${product.productId}"/>">

<table class="table-bordered">

     <tr>
     <td rowspan="8">
     <img src=" <c:url value="/resources/images/ ${product.productId}.jpg"/> "height="300" alt= "Generic placeholder thumbnail">
     </td>
     
     <td>Product Id</td>
     <td> ${product.productName}</td>
     </tr>
     
     <td>Product Name</td>
     <td> ${product.productPrice}</td>
     </tr>
     
     
     <td>Price</td>
     <td> LKR ${product.productPrice}</td>
     </tr>
     
     <td>Stock</td>
     <td> ${product.productStock}</td>
     </tr>
     

     <td>Category Id</td>
     <td> ${product.categoryId}</td>
     </tr>
    
    
      <td>Supplier Id</td>
     <td> ${product.supplierId}</td>
     </tr>
     
     <td>Description</td>
     <td> ${product.productDesc}</td>
     </tr>
     
     
     <tr>
     
     
     <td> Quantity
	     
	    <select name="quantity">
	    <option value="1"> 1</option>
	    <option value="2"> 2</option>
	    <option value="3"> 3</option>
	    <option value="4"> 4</option>
	    <option value="5"> 5</option>
	    </select>
   </td> 
    
    <td><input type="submit" value="BUY" class="btn btn-success"></td>
    
</table>


</form>