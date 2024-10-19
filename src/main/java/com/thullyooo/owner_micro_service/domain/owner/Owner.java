package com.thullyooo.owner_micro_service.domain.owner;

import com.thullyooo.owner_micro_service.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_OWNERS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "owner_id")
    private UUID id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String document;

    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Address> addressesList;

}
