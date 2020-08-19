package rs.ac.uns.ftn.storage.storageservice.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncreaseProductsQuantityRequestDTO {
    private Long productId;
    private long quantity;
}
