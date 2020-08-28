package rs.ac.uns.ftn.order.orderservice.service;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.order.orderservice.DTO.response.ProductQuantityOrderResponseDTO;
import rs.ac.uns.ftn.order.orderservice.model.ProductQuantityOrder;

@Service
public class ProductQuantityOrderService {

    public static ProductQuantityOrderResponseDTO mapToResponse(ProductQuantityOrder product) {
        ProductQuantityOrderResponseDTO response = new ProductQuantityOrderResponseDTO();
        response.setId(product.getId());
        response.setProductId(product.getProductId());
        response.setQuantity(product.getQuantity());
        return response;
    }
}
