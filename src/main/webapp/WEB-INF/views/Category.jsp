<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<from action="<c:url value="/AddCategory"/>" method="post">
<table align = "center" class="table">
    <tr>
    <td colspan="2">
    <center><h3>Category</h3></center>
    </td> 
    </tr>

   <tr>
    <td>Category Name </td>
    <td><input type="text" name="catName"/></td> 
    </tr>
    
    <tr>
          
    <td>Category Desc</td>
    <td><input type="text" name="catDesc"/></td>
    </tr>
    
     <tr>
          
    <td colspan="2">
    <td><input type="submit" value="Add Category"/></td>
    </tr>
    
    
</table>
</from>



          <table class="table-bordered">
          <tr>
          <td> Category Id </td>
          <td> Category Name </td>
          <td> Category Descripton </td>
          <td> Operation</td>
          </tr>
          
         <c:forEach items="{listCategories}" var="category">
          <tr>
          <td>${category.categoryId}</td>
          <td>${category.categoryName}</td>
          <td>${category.categoryDesc}</td>
         
          <td><a href="<c:url vlaue="editCategory/${category.categoryId}"/>" class=" btn btn-success">EDIT</a></td>
          <td><a href="<c:url vlaue="\deleteCategory/${category.categoryId}"/>" class="btn btn-danger">DELETE</a></td>
           
          </tr>
         </c:forEach>
       </table>
