package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    
	List<Product> findAll();
    
    @Query("SELECT ptype FROM ProductType ptype ORDER BY ptype.name")
    List<ProductType> findAllProductTypes() throws DataAccessException;
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    
    @Query("SELECT p FROM Product p WHERE p.price<?1")
    List<Product> findByPriceLessThan(double price);
    
    @Query("SELECT ptype FROM ProductType ptype WHERE ptype.name=?1")
    Optional<ProductType> getProductType(String name);
    
}
