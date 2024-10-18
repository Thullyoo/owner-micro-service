package com.thullyooo.owner_micro_service.domain.owner;

import com.thullyooo.owner_micro_service.domain.address.Address;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_OWNERS")
public class Owner implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "owner_id")
    private UUID id;

    private String name;

    private String email;

    private String document;

    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Address> addressesList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

}
