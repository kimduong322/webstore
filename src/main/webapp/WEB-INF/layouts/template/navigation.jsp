<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<li>
	<a href="<spring:url value="/market/products"/>">Home</a>
</li>
<li>
	<a href="<spring:url value="/market/products/"/>">Products</a>
</li>
<li>
	<a href="<spring:url value="/market/products/add"/>">Add Product</a>
</li>
<li>
	<a href="<spring:url value="/cart/"/>">Cart</a>
</li>