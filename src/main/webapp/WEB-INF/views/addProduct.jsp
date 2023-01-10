<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="addProduct.pageTitle"/></title>
</head>
<body>
	<section>
		<div class="pull-right" style="padding-right:50px">
			<a href="?language=en">English</a> | <a href="?language=nl">Dutch</a> | <a href="?language=fr">France</a>
		</div>
		<div class="pull-left" style="padding-left:50px">
			<a href="<c:url value="/logout"/>">Logout</a>		
		</div>
	</section>
	
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="addProduct.intro.title"/></h1>
				<p><spring:message code="addProduct.intro.subTitle"/></p>
			</div>
		</div>
	</section>
	
	<section class="container">
		<form:form method="POST" modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>	
			<fieldset>
				<legend><spring:message code="addProduct.form.legend"/></legend>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="productId">
						<spring:message htmlEscape="false" code="addProduct.form.productId.lable"/>
					</label>
					<div class="col-sm-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						<form:errors path="productId" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="Name">
						<spring:message htmlEscape="false" code="addProduct.form.name.label"/>
					</label>
					<div class="col-sm-10">
						<form:input id="Name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="unit_price">
						<spring:message htmlEscape="false" code="addProduct.form.unitPrice.label"/>	
					</label>
					<div class="col-sm-10">
						<form:input id="unit_price" path="unitPrice" type="text" class="form:input-large"/>
						<form:errors path="unitPrice" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="manufacturer">
						<spring:message code="addProduct.form.manufacturer.label"/>
							
					</label>
					<div class="col-sm-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
						<form:errors path="manufacturer" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="category">
						<spring:message htmlEscape="false" code="addProduct.form.category.label"/>
					</label>
					<div class="col-sm-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
						<form:errors path="category" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="unitsInStock">
						<spring:message code="addProduct.form.unitsInStock.label"/>
					</label>
					<div class="col-sm-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
						<form:errors path="unitsInStock" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="description">
						<spring:message htmlEscape="false" code="addProduct.form.description.label"/>
					</label>
					<div class="col-sm-10">
						<form:textarea id="description" path="description" rows="2"/>
						<form:errors path="description" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-form-label" for="condition">
						<spring:message htmlEscape="false" code="addProduct.form.condition.label"/>
					</label>
					<div class="col-sm-10">
						<form:radiobutton path="condition" value="New"/><spring:message code="addProduct.form.conditon.option.new"/>
						<form:radiobutton path="condition" value="Old"/><spring:message code="addProduct.form.conditon.option.old"/>
						<form:radiobutton path="condition" value="Refurbished"/><spring:message code="addProduct.form.conditon.option.refurbished"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="productImage">
						<spring:message htmlEscape="false" code="addProduct.form.productImage.lable"/>
					</label>
					<div class="col-sm-10">
						<form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
						<form:errors path="productImage" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="addProduct.form.submitBtn.content"/>"/>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>