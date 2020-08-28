package rs.ac.uns.ftn.order.orderservice.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityOrderResponseDTO {
    private Long id;
    private Long productId;
    private long quantity;
}
