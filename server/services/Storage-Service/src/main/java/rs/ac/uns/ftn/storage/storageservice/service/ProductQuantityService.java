package rs.ac.uns.ftn.storage.storageservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.storage.storageservice.DTO.request.IncreaseProductsQuantityRequestDTO;
import rs.ac.uns.ftn.storage.storageservice.DTO.response.ProductQuantityResponseDTO;
import rs.ac.uns.ftn.storage.storageservice.model.ProductQuantity;
import rs.ac.uns.ftn.storage.storageservice.repository.ProductQuantityRepository;

@Service
public class ProductQuantityService {

    @Autowired
    private ProductQuantityRepository productQuantityRepository;

    public ProductQuantityResponseDTO getOneByProductId(Long id) {
        ProductQuantity productQuantity = productQuantityRepository.findOneByProductId(id);
        return mapToResponse(productQuantity);
    }
    public ProductQuantityResponseDTO save(ProductQuantity pq) {
        return mapToResponse(productQuantityRepository.save(pq));
    }
    public ProductQuantityResponseDTO createNewProductQuantity(Long productId) {
        ProductQuantity productQuantity = new ProductQuantity();
        productQuantity.setProductId(productId);
        return this.save(productQuantity);
    }
    public ProductQuantityResponseDTO increaseProductQuantity(IncreaseProductsQuantityRequestDTO requestDTO) {
        ProductQuantity productQuantity = productQuantityRepository.findOneByProductId(requestDTO.getProductId());
        productQuantity.setQuantity(productQuantity.getQuantity() + requestDTO.getQuantity());
        return this.save(productQuantity);
    }
    private ProductQuantityResponseDTO mapToResponse(ProductQuantity productQuantity){
        ProductQuantityResponseDTO responseDTO = new ProductQuantityResponseDTO();
        responseDTO.setId(productQuantity.getId());
        responseDTO.setProductId(productQuantity.getProductId());
        responseDTO.setQuantity(productQuantity.getQuantity());
        return responseDTO;
    }

}