package com.thullyooo.owner_micro_service.domain.owner.DTO;

import com.thullyooo.owner_micro_service.domain.address.Address;

import java.util.List;

public record OwnerResponseDTO(String name, String email, String document, String password, List<Address> addressList) {
}
