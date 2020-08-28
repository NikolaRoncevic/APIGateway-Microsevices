package rs.ac.uns.ftn.order.orderservice.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderRequestDTO {
    private Long ownerId;
    private ArrayList<NewProductQuantityOrderRequestDTO> products = new ArrayList<>();
}
