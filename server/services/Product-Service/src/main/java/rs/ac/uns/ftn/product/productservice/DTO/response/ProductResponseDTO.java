package rs.ac.uns.ftn.product.productservice.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private long price;
}
