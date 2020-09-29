package rs.ac.uns.ftn.composer.composerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.composer.composerservice.DTO.request.CreateProductRequestDTO;
import rs.ac.uns.ftn.composer.composerservice.DTO.response.ProductResponseDTO;
import rs.ac.uns.ftn.composer.composerservice.feignclient.ProductServiceProxy;
import rs.ac.uns.ftn.composer.composerservice.feignclient.StorageServiceProxy;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComposerController {

    @Autowired
    ProductServiceProxy productServiceProxy;

    @Autowired
    StorageServiceProxy storageServiceProxy;

    @RequestMapping(value = "product/new",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<ProductResponseDTO> createNewProduct(@RequestBody CreateProductRequestDTO requestDTO) {
        ProductResponseDTO responseDTO = productServiceProxy.createNewProduct(requestDTO).getBody();
        storageServiceProxy.createProductQuantityForNewProduct(responseDTO.getId());
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }
}
