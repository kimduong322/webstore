<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<section class="container" ng-app="cartApp">
		<div class="row">
			<div class="col-md-5">
				<img src="<c:url value="/img/${product.productId}.png">
				</c:url>" alt="image" style = "width:100%"/>
			</div>
			
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>
						<spring:message code="productDetail.detail.productId"/>:
					</strong>
					<span class="label label-warning">
						${product.productId}
					</span>
				</p>
				<p>
					<strong><spring:message code="productDetail.detail.manufacturer"/></strong> 
					: ${product.manufacturer}
				</p>
				<p>
					<strong><spring:message code="productDetail.detail.category"/></strong> 
					: ${product.category}
				</p>
				<p>
					<strong><spring:message code="productDetail.detail.unitsInStock"/></strong> 
					: ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice} USD</h4>
				<p ng-controller="cartCtrl">
					<a href="<spring:url value="/market/products" />" class="btn btn-default">
						<span class="glyphicon glyphicon-hand-left"></span>back
					</a>
					<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
						<span class="glyphicon-shopping-cart glyphicon"></span> 
						Order Now
					</a>
					
					<a href="<spring:url value="/cart" />" class="btn btn-default">
						<span class="glyphicon-hand-right glyphicon"></span>View Cart
					</a>
				</p>
			</div>
		</div>
	</section>