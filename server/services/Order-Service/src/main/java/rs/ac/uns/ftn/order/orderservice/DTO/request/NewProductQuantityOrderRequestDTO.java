package rs.ac.uns.ftn.order.orderservice.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewProductQuantityOrderRequestDTO {
    private Long productId;
    private long quantity;
}
