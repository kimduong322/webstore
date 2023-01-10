package com.packt.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidation implements ConstraintValidator<CategoryValidator, String>{
	
	private List<String> allowedCategories;
	
	public CategoryValidation() {
		super();
		allowedCategories = new ArrayList<String>();
		allowedCategories.add("Smartphone");
		allowedCategories.add("Laptop");
		allowedCategories.add("Headphone");
		allowedCategories.add("Tablet");
		allowedCategories.add("Book");
	}

	@Override
	public void initialize(CategoryValidator constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(this.allowedCategories.contains(value)) {
			return true;
		} else return false;
	}

}
