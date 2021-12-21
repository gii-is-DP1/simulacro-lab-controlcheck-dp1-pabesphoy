package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
//@Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
    @Query("SELECT p FROM ProductType p")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);

    @Query("SELECT p FROM ProductType p WHERE p.name = :typeName")
    Optional<ProductType> findProductTypeByName(@Param("typeName") String name);

    @Query("SELECT p FROM Product p WHERE p.price < :minPrice")
    List<Product> findByPriceLessThan(@Param("minPrice")Double minPrice);

    Product save(Product p);
}
