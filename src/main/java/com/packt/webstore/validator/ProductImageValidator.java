package com.packt.webstore.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.Product;

public class ProductImageValidator implements Validator {
	
	private long allowedSize;
	
	public long getAllowedSize() {
		return allowedSize;
	}

	public void setAllowedSize(long allowedSize) {
		this.allowedSize = allowedSize;
	}
	public ProductImageValidator(long allowedSize) {
		super();
		this.allowedSize = allowedSize;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if(product.getProductImage().getSize() > allowedSize) {
			errors.rejectValue("productImage","com.packt.webstore.validator.ProductImageValidator.message");
		}
	}

}
