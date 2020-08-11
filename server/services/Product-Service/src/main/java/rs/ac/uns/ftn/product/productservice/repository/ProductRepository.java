package rs.ac.uns.ftn.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.product.productservice.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
    Product findOneById(Long id);
    Product findOneByName(String name);
}
