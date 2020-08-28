package rs.ac.uns.ftn.order.orderservice.service;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.order.orderservice.DTO.request.NewOrderRequestDTO;
import rs.ac.uns.ftn.order.orderservice.DTO.request.NewProductQuantityOrderRequestDTO;
import rs.ac.uns.ftn.order.orderservice.DTO.response.OrderResponseDTO;
import rs.ac.uns.ftn.order.orderservice.DTO.response.ProductQuantityOrderResponseDTO;
import rs.ac.uns.ftn.order.orderservice.model.Order;
import rs.ac.uns.ftn.order.orderservice.model.ProductQuantityOrder;
import rs.ac.uns.ftn.order.orderservice.repository.OrderRepository;
import rs.ac.uns.ftn.order.orderservice.repository.ProductQuantityOrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductQuantityOrderRepository productQuantityOrderRepository;

    public OrderService(OrderRepository orderRepository, ProductQuantityOrderRepository productQuantityOrderRepository) {
        this.orderRepository = orderRepository;
        this.productQuantityOrderRepository = productQuantityOrderRepository;
    }

    private List<OrderResponseDTO> findAllByOwnerId(Long ownerId) {
            List<Order> orders = orderRepository.findAllByOwnerId(ownerId);
            List<OrderResponseDTO> response = new ArrayList<>();
            for(Order o : orders){
                response.add(mapToResponse(o));
            }
            return response;
    }
    private OrderResponseDTO createNewOrder(NewOrderRequestDTO requestDTO) {
        Order o = new Order();
        o.setOwnerId(requestDTO.getOwnerId());
        for(NewProductQuantityOrderRequestDTO productQuantityRequest : requestDTO.getProducts()){
            ProductQuantityOrder product = new ProductQuantityOrder();
            product.setProductId(productQuantityRequest.getProductId());
            product.setQuantity(productQuantityRequest.getQuantity());
            product = productQuantityOrderRepository.save(product);
            o.getProducts().add(product);
        }
        return mapToResponse(orderRepository.save(o));
    }

    private OrderResponseDTO mapToResponse(Order o) {
        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(o.getId());
        response.setOwnerId(o.getOwnerId());
        ArrayList<ProductQuantityOrderResponseDTO> products = new ArrayList<>();
        for(ProductQuantityOrder p : o.getProducts()){
            products.add(ProductQuantityOrderService.mapToResponse(p));
        }
        response.setProducts(products);
        return response;

    }
}
