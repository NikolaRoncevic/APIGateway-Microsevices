package rs.ac.uns.ftn.order.orderservice.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Long Id;
    private Long ownerId;
    private ArrayList<ProductQuantityOrderResponseDTO> products = new ArrayList<>();
}
