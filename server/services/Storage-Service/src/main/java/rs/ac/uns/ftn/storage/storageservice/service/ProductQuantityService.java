package rs.ac.uns.ftn.storage.storageservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.storage.storageservice.DTO.request.IncreaseProductsQuantityRequestDTO;
import rs.ac.uns.ftn.storage.storageservice.DTO.response.ProductQuantityResponseDTO;
import rs.ac.uns.ftn.storage.storageservice.model.ProductQuantity;
import rs.ac.uns.ftn.storage.storageservice.repository.ProductQuantityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductQuantityService {

    @Autowired
    private ProductQuantityRepository productQuantityRepository;

    public ProductQuantityResponseDTO findOneByProductId(Long id) {
        ProductQuantity productQuantity = productQuantityRepository.findOneByProductId(id);
        return mapToResponse(productQuantity);
    }
    public List<ProductQuantityResponseDTO> findAll() {
        List<ProductQuantity> productQuantitys = productQuantityRepository.findAll();
        List<ProductQuantityResponseDTO> ret = new ArrayList<>();
        for(ProductQuantity p : productQuantitys) {
            ret.add(mapToResponse(p));
        }
        return ret;

    }
    public ProductQuantityResponseDTO save(ProductQuantity pq) {
        return mapToResponse(productQuantityRepository.save(pq));
    }
    public ProductQuantityResponseDTO createNewProductQuantity(Long productId) {
        ProductQuantity productQuantity = new ProductQuantity();
        productQuantity.setProductId(productId);
        productQuantity.setQuantity(0);
        return this.save(productQuantity);
    }
    public ProductQuantityResponseDTO increaseProductQuantity(IncreaseProductsQuantityRequestDTO requestDTO) {
        ProductQuantity productQuantity = productQuantityRepository.findOneByProductId(requestDTO.getProductId());
        System.out.println("Current: " + productQuantity.getQuantity());
        System.out.print("New :" + requestDTO.getQuantity());
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