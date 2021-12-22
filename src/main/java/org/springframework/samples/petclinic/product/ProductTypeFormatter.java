package org.springframework.samples.petclinic.product;

import java.text.ParseException;
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
    	return ps.getProductType(text);
    	
		//throw new ParseException("type not found: " + text, 0);
    }
    
}
