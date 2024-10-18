package com.thullyooo.owner_micro_service.domain.address;

import com.thullyooo.owner_micro_service.domain.owner.Owner;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "TB_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    @ManyToOne
    @JoinColumn(
            name = "owner_id"
    )
    private Owner owner;

}