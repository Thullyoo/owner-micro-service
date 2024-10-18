package com.thullyooo.owner_micro_service.repository;

import com.thullyooo.owner_micro_service.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
