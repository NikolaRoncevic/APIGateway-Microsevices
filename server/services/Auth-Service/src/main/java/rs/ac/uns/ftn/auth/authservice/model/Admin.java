package rs.ac.uns.ftn.auth.authservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("ADMIN")
public class Admin extends BaseUser {

}
