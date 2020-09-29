package rs.ac.uns.ftn.composer.composerservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.ac.uns.ftn.composer.composerservice.DTO.request.CreateProductRequestDTO;
import rs.ac.uns.ftn.composer.composerservice.DTO.response.ProductResponseDTO;

@FeignClient(name="product")
public interface ProductServiceProxy {

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponseDTO> createNewProduct(@RequestBody CreateProductRequestDTO requestDTO);
}
