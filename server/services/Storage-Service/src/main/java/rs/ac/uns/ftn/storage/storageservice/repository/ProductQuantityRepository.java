package rs.ac.uns.ftn.storage.storageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.storage.storageservice.model.ProductQuantity;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity,Long> {

    ProductQuantity findOneByProductId(Long productId);





}
