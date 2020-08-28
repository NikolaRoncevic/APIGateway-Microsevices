package rs.ac.uns.ftn.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.order.orderservice.model.ProductQuantityOrder;

import java.util.List;

public interface ProductQuantityOrderRepository extends JpaRepository<ProductQuantityOrder,Long> {

}
