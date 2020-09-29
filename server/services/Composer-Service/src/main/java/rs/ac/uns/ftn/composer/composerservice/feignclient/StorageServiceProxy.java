package rs.ac.uns.ftn.composer.composerservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="storage")
public interface StorageServiceProxy {

    @RequestMapping(value = "/{productId}", method = RequestMethod.POST)
    ResponseEntity<?> createProductQuantityForNewProduct(@PathVariable Long productId);
}
