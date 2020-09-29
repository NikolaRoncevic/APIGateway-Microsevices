package rs.ac.uns.ftn.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.order.orderservice.model.OrderRequest;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderRequest,Long> {
    List<OrderRequest> findAllByOwnerId(Long ownerId);


}
