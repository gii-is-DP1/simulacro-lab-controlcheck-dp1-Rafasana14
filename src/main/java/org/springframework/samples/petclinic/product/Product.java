package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity {
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String name;
	
	@NotNull
	@Min(value=0, message="El precio debe ser positivo")
	//@PositiveOrZero(message="El precio debe ser positivo")
    double price;
	
	@ManyToOne()
	@JoinColumn(name = "product_type_id", referencedColumnName="id")
    private ProductType productType;
}
