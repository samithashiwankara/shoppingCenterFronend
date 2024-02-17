<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<br><br>


<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form.data">
<table align="center" class ="table.bordered">

    <tr>
    <td colspan="2"><center>Product Info</center></td>
    </tr>
    
    <tr>
    <td>Product Name</td>
    <td><form:input path="productName"/></td>
    </tr>
    
   <tr>
   <td>Price</td>
    <td><form:input path="productPrice"/></td>
    </tr>
    
    <tr>
    <td>Stock</td>
    <td><form:input path="productStock"/></td>
    </tr>

  <tr>
  <td>Category</td>
  <td>
  <form:select path="categoryId">
  <form:option value="0" label="------Select list------"/>
  <form:options items="${categoryList }"/>
  </form:select>
 
  </td>
  </tr>
  
 <tr>
 <td>Supplier</td>
 <td><form:input path="supplierId"/></td>
 </tr>
 
 <tr>
 <td>Product Description</td>
 <td><from:input path="productDesc"/></td>
 </tr>
 
 <tr>
 <td>Product Image</td>
 <td><from:input type="file" path="pimage"/></td>
 </tr>

<tr>
<td colspan="2"> <center><input type="submit" value="Insert Product"/></center></td>
</tr>

</table>
</form:form>

<table class="table-bordered">
    <tr>
    <td>Product Id</td>
    <td>Product Name</td>
    <td>Price</td>
    <td>Stock</td>
    <td>Supplier</td>
    <td>Operations</td>
    </tr>
    
    
    <c:forEach items ="${productList }" var="product">
    <tr>
    <td>${product.productId}</td>
    <td>${product.productName}</td>
    <td>${product.productPrice}</td>
    <td>${product.productStock}</td>
    <td>${product.supplierId}</td>
    
    
 <td>
 <a href="<c:url vlaue="editCategory/${category.categoryId}"/>" class="btn btn-success">EDIT</a>
 <a href="<c:url vlaue="\deleteCategory/${category.categoryId}"/>" class="btn btn-danger">DELETE</a>
</td>
</tr>
</c:forEach>




</table>
