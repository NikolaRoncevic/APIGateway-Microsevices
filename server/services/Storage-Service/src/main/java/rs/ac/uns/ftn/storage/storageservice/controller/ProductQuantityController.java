package rs.ac.uns.ftn.storage.storageservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.storage.storageservice.DTO.request.IncreaseProductsQuantityRequestDTO;
import rs.ac.uns.ftn.storage.storageservice.service.ProductQuantityService;

@RestController
@RequestMapping(value = "",produces = "application/json")
public class ProductQuantityController {

    @Autowired
    private ProductQuantityService productQuantityService;

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<?> createProductQuantityForNewProduct(@PathVariable Long productId) {
            return new ResponseEntity<>(productQuantityService.createNewProductQuantity(productId), HttpStatus.CREATED);
    }
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes = "application/json")
    public ResponseEntity<?> increaseQuantity(@RequestBody IncreaseProductsQuantityRequestDTO requestDTO) {
        return new ResponseEntity<>(productQuantityService.increaseProductQuantity(requestDTO),HttpStatus.ACCEPTED);
    }

    /**
     * Samo prebacimo vrednost u negativnu i onda saljemo zahtev kao da je povecavanje
     * @param requestDTO
     * @return
     */
    @RequestMapping(value = "sell",method = RequestMethod.PUT,consumes = "application/json")
    public ResponseEntity<?> decreaseQuantity(@RequestBody IncreaseProductsQuantityRequestDTO requestDTO) {
        requestDTO.setQuantity(-requestDTO.getQuantity());
        return new ResponseEntity<>(productQuantityService.increaseProductQuantity(requestDTO),HttpStatus.ACCEPTED);

    }
}
