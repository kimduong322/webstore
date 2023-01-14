<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 16px;">
				<div class="thumbnail">
					<img src="<c:url value="/img/${product.productId}.png"/>" alt="image" style = "width:100%; height:250px;"/>
					<div class="caption">
						<h3>${product.name}</h3>
						<p style="overflow: hidden; height: 60px; text-overflow: ellipsis;">${product.description}</p>
						<p>$${product.unitPrice}</p>
						<p>Available ${product.unitsInStock} units in stock</p>
					
						<p>
						<a href="<spring:url value="/market/product?id=${product.productId}"/>" class = "btn btn-primary">
							<span class="glyphicon-info-sign glyphicon"></span>Details
						</a>
						</p>
					</div>
				</div>
				</div>
			</c:forEach>
		</div>
	</section>