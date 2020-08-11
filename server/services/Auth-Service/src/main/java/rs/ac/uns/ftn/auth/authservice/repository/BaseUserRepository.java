package rs.ac.uns.ftn.auth.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.auth.authservice.model.BaseUser;

import java.util.List;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {
    List<BaseUser> findAll();
    BaseUser findOneById(Long id);
    BaseUser findOneByUsername(String username);
}
