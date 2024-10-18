package com.thullyooo.owner_micro_service.domain.owner.DTO;

import java.util.List;

public record OwnerRequestDTO(String name, String email, String document, String password, List<AddressRequestDTO>) {
}
