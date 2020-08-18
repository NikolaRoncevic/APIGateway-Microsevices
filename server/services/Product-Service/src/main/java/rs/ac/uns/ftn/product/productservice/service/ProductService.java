package rs.ac.uns.ftn.product.productservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.product.productservice.DTO.request.CreateProductRequestDTO;
import rs.ac.uns.ftn.product.productservice.DTO.request.UpdateProductRequestDTO;
import rs.ac.uns.ftn.product.productservice.DTO.response.ProductResponseDTO;
import rs.ac.uns.ftn.product.productservice.model.Product;
import rs.ac.uns.ftn.product.productservice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductResponseDTO createNewProduct(CreateProductRequestDTO requestDTO) {
        Product p = new Product();
        p.setName(requestDTO.getName());
        p.setPrice(requestDTO.getPrice());
        productRepository.save(p);
        return mapProductToProductResponseDTO(p);
    }
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> response = new ArrayList<>();
        for(Product p : products){
            response.add(mapProductToProductResponseDTO(p));
        }
        return response;
    }
    public ProductResponseDTO updateProduct(UpdateProductRequestDTO requestDTO) {
        Product p = productRepository.findOneById(requestDTO.getId());
        p.setPrice(requestDTO.getPrice());
        p.setName(requestDTO.getName());
        productRepository.save(p);
        return mapProductToProductResponseDTO(p);
    }

    private ProductResponseDTO mapProductToProductResponseDTO(Product p) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(p.getId());
        responseDTO.setName(p.getName());
        responseDTO.setPrice(p.getPrice());
        return responseDTO;
    }

}
