package com.thullyooo.owner_micro_service.repository;

import com.thullyooo.owner_micro_service.domain.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {

    Optional<Owner> findByName(String name);

}
