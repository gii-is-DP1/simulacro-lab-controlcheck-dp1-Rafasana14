package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	
	private final ProductService ps;

	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.ps = productService;
	}

	@Override
	public String print(ProductType productType, Locale locale) {
		return productType.getName();
	}



    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	System.out.println(text);
    	List<ProductType> findProductTypes = this.ps.findAllProductTypes();
    	System.out.println(findProductTypes);
		for (ProductType type : findProductTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
    }
    
}
