package com.packt.webstore.exception;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -694354952032299587L;
	private String productId;
	public String getProductId() {
		return productId;
	}
	public ProductNotFoundException(String producId) {
		this.productId = producId;
	}
}
