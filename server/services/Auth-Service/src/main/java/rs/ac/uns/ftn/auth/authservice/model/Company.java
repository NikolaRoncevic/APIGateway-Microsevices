package rs.ac.uns.ftn.auth.authservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("COMPANY")
public class Company extends BaseUser{
    @Column
    private String name;

    @Column
    private String pib;

    @Column
    private String bankAccount;
}
