<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>

<div class="container">

     <form action="<c:url value="/recepit"/>" method="post">
     
     <table clas="table table=bordered" width="50%" align="center">
     
     <tr class="success">
     <td colspan="2"><center>Payment Detail</center></td>
     </tr>
     
     
     <tr class="info">
     <td colspan="2">
     <cente>
     
        <input type="radio" name="rd" value="cc">Cerdit Card
        <input type="radio" name="rd"  value="cod">Cash On Delivery
     </cente>
     </td>
     </tr>
     
     
     <tr class="warning">
     <td>Card Number</td>
     <td><iput type="text" name="cardNo"/></td>
     </tr>
     
     <tr class="warning">
     <td>Vaild<iput type="text" name="Vaild"/></td>
     <td>CW<iput type="text" name="CW"/></td>
     </tr>
     
     <tr class="warning">
     <td><iput type="text" name="name"/></td>
     </tr>
     <tr class="success">
     <td colspan="2"><center><input type="submit" value="Pay" class="btn btn-success" /></center></td>
     </tr>
     
     
     </table>
  
     </form>



</div>


</body>
</html>