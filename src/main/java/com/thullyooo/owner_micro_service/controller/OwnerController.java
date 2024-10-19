package com.thullyooo.owner_micro_service.controller;

import com.thullyooo.owner_micro_service.domain.owner.DTO.OwnerRequestDTO;
import com.thullyooo.owner_micro_service.domain.owner.DTO.OwnerResponseDTO;
import com.thullyooo.owner_micro_service.security.TokenResponseDTO;
import com.thullyooo.owner_micro_service.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/register")
    public ResponseEntity<OwnerResponseDTO> register(@RequestBody OwnerRequestDTO ownerRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.register(ownerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(Authentication authentication) {
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.login(authentication));
    }
}
