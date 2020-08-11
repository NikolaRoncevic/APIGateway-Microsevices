package rs.ac.uns.ftn.auth.authservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.auth.authservice.DTO.request.LoginRequestDTO;
import rs.ac.uns.ftn.auth.authservice.DTO.response.LoginResponseDTO;
import rs.ac.uns.ftn.auth.authservice.controller.AuthenticationController;
import rs.ac.uns.ftn.auth.authservice.model.BaseUser;
import rs.ac.uns.ftn.auth.authservice.repository.BaseUserRepository;

@Service
public class AuthService {
    Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    BaseUserRepository baseUserRepository;

    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        BaseUser user = baseUserRepository.findOneByUsername(requestDTO.getUsername());
        LoginResponseDTO responseDTO = null;
        if(user != null) {
            if(user.getPassword().equals(requestDTO.getPassword())) {
                responseDTO =  mapToLoginResponseDTO(user);
            }
        }
        return responseDTO;

    }
    private  LoginResponseDTO mapToLoginResponseDTO(BaseUser user) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setType(user.getDicriminatorValue());
        return responseDTO;
    }

}
