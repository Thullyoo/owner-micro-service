package com.thullyooo.owner_micro_service.service;

import com.thullyooo.owner_micro_service.domain.address.Address;
import com.thullyooo.owner_micro_service.domain.address.DTO.AddressRequestDTO;
import com.thullyooo.owner_micro_service.domain.owner.DTO.OwnerRequestDTO;
import com.thullyooo.owner_micro_service.domain.owner.DTO.OwnerResponseDTO;
import com.thullyooo.owner_micro_service.domain.owner.Owner;
import com.thullyooo.owner_micro_service.repository.AddressRepository;
import com.thullyooo.owner_micro_service.repository.OwnerRepository;
import com.thullyooo.owner_micro_service.security.JWTService;
import com.thullyooo.owner_micro_service.security.TokenResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private JWTService jwtService;

    @Transactional
    public OwnerResponseDTO register(OwnerRequestDTO dto){
        Owner owner = Owner.builder()
                .name(dto.name())
                .email(dto.email())
                .password(encoder.encode(dto.password()))
                .document(dto.document())
                .build();

        List<Address> addressList = new ArrayList<>();

        for (AddressRequestDTO address : dto.address()){
            Address addressNew = Address.builder()
                    .city(address.city())
                    .state(address.state())
                    .country(address.country())
                    .street(address.street())
                    .postalCode(address.postalCode())
                    .owner(owner)
                    .build();
            addressRepository.save(addressNew);
            addressList.add(addressNew);
        }

        owner.setAddressesList(addressList);

        ownerRepository.save(owner);

        return new OwnerResponseDTO(owner.getName(), owner.getEmail(), owner.getDocument(), owner.getPassword(), owner.getAddressesList());
    }

    public TokenResponseDTO login(Authentication authentication) {
        return new TokenResponseDTO(jwtService.generateToken(authentication), 3000L);
    }

}