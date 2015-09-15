<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Code</th>
            <th>Item</th>
            <th>Quantity</th>
        </tr>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <c:forEach var="stk" items="${StockInfolist}">
            <tr>
                <td>${stk.Code}</td>
                <td>${stk.Item}</td>
                <td>${stk.Quantity}</td>
                
            </tr>
        </c:forEach>
    </table>
 
    <%--For displaying Previous link except for the 1st page --%>
    
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
        
    <%--For displaying Next link --%>
    
 
</body>
</html>