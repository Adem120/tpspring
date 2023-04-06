<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="windows-1256" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js" type="application/javascript"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h3 class="card-title">Liste des Produits</h3>
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Produit Id</th>
                        <th>NomProduit</th>
                        <th>PrixProduit</th>
                        <th>Date de Creation</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${produits}" var="product">
                        <tr>
                            <td>${product.Idproduit}</td>
                            <td>${product.NomProduit}</td>
                            <td>${product.PrixProduit}</td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${product.createat}"/></td>
                            <td><a href="supprimerproduit?productId=${product.Idproduit}">Supprimer</a></td>
                            <td><a href="pagemodifer?productId=${product.Idproduit}">Modifier</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>