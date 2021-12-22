package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
	
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	private static final String WELCOME = "welcome";
    
	
	private final ProductService ps;
	
	
	@Autowired
	public ProductController(ProductService productService) {
		this.ps = productService;
	}
	
	@ModelAttribute("types")
	public List<ProductType> populateProductTypes() {
		List<ProductType> types = this.ps.findAllProductTypes();
		return types;
	}
	
	@GetMapping(value = "/product/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
		model.put("product", product);
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result,  ModelMap model) {
		if (result.hasErrors()) {
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.ps.save(product);
			System.out.println(product +  "...............................................");
			return WELCOME;
		}
	}
	
}
