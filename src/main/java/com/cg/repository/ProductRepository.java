package com.cg.repository;

import com.cg.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(nativeQuery = true,
            value = "select * from products order by id desc")
    List<Product> findAll();

    List<Product> findAllByNameContaining(String name);

    @Query(nativeQuery = true,
            value = "select * from products where brand_id = :id order by id desc")
    List<Product> findAllByBrandId(@Param(value = "id") Long id);
    @Query(nativeQuery = true,
            value = "select * from products where company_id = :id order by id desc")
    List<Product> findAllByCompanyId(@Param(value = "id") Long id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM products p" +
                    " INNER JOIN categories_products cp ON p.id = cp.products_id " +
                    "INNER JOIN categories ON cp.categories_id = categories.id" +
                    " WHERE categories.id = :id order by p.id desc")
    List<Product> findAllByCategories(@Param(value = "id") Long id);

}
