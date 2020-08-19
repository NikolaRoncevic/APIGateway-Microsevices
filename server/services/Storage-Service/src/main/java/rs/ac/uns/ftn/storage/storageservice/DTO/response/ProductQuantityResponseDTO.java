package rs.ac.uns.ftn.storage.storageservice.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityResponseDTO {
    private Long id;
    private Long productId;
    private long quantity;
}
