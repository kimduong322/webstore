<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
				<p>All customers of Store</p>
			</div>
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 16px">
				<div class="thumbnail">
					<div class="caption">
						<h3><strong>ID</strong>: ${customer.customerId}</h3>
						<p>${customer.name}</p>
						<p><strong>Number of Orders Made</strong>: ${customer.noOfOrdersMade}</p>
						<p><strong>Address</strong>: ${customer.address}</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>