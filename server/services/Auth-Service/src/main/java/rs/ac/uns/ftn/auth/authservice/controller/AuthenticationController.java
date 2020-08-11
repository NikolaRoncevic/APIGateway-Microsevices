package rs.ac.uns.ftn.auth.authservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.auth.authservice.DTO.request.LoginRequestDTO;
import rs.ac.uns.ftn.auth.authservice.DTO.response.LoginResponseDTO;
import rs.ac.uns.ftn.auth.authservice.service.AuthService;


@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthService authService;

    @RequestMapping(consumes = "application/json", value = "login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO requestDTO) {
        LoginResponseDTO responseDTO = authService.login(requestDTO);

        if(responseDTO == null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }
}
