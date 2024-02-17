<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="<c:url value ="/UpdateCategory"/>"method="post">
 <table align="center" class"table">
 
   <tr>
   <td colspan="2"><h2><center>Category</center></h2></td>
   </tr>
 
 
    <tr>
    <td>Category Id</td>
    <td><input type="text" name="catId" value="${category.categoryId }" readonly></td>
    </tr>
    
 
     <tr>
    <td>Category Name</td>
    <td><input type="text" name="catName" value="${category.categoryName }" ></td>
    </tr>
    
     <tr>
    <td>Category Description</td>
    <td><input type="text" name="catDesc" value="${category.categoryDesc }"></td>
    </tr>
    
   <tr>
   <td colspn="2"><center><intput type="submit" value="UPDATE CATEGORY"/></center></td>
   </tr>
 
 
 
 
 </table>







</form>