package com.packt.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.validator.ProductValidator;

@Controller
@RequestMapping("market")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;
	
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products";
	}
	@RequestMapping("products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory ) {
		List<Product> products = productService.getProductsByCategory(productCategory);
		
		if(products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}
	@RequestMapping("products/filter/{params}/{specification}")
	public String filter(@MatrixVariable(pathVar = "params") Map<String, List<String>> criteriaFilter, 
						 @MatrixVariable(pathVar = "specification") Map<String, List<String>> specFilter,
						Model model) {
		model.addAttribute("products", productService.getProductsByFilter(criteriaFilter));
		return "products";
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productID, Model model) {
		model.addAttribute("product", productService.getProductById(productID));
		return "product";
	}
	
	@RequestMapping(value="/products/{category}/{price}", method = RequestMethod.GET)
	public String filterProducts(@PathVariable String category, 
			@MatrixVariable(pathVar = "price") Map<String, String> price_band, 
			@RequestParam("brand") String productBrand, 
			Model model) {
		model.addAttribute("products", productService.filterProduct(category, price_band, productBrand));
		return "products";
	}
	
	@RequestMapping(value="/products/add", method=RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	@RequestMapping(value="/products/add", method=RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, 
			HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attemping to bind disallowed fields: " + 
		StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"resources/images/"+ newProduct.getProductId() + ".png"));
			}catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		
		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}
	
	@InitBinder
	public void initilizeBinder(WebDataBinder binder) {
		binder.setValidator(productValidator);
		
		binder.setAllowedFields("productId",
				"name",
				"unitPrice",
				"description",
				"manufacturer",
				"category",
				"unitsInStock",
				"condition",
				"productImage",
				"language");
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
	@RequestMapping("/products/invalidPromoCode")
	public String invalidPromoCode() {
		
		return "invalidPromoCode";
	}
}
