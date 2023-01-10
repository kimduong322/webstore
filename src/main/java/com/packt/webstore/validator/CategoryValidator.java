package com.packt.webstore.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Constraint(validatedBy = CategoryValidation.class)
public @interface CategoryValidator {
	String message() default "{com.packt.webstore.validator.Category.message}";
	
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}
