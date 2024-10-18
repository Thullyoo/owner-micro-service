package com.thullyooo.owner_micro_service.security;

import com.thullyooo.owner_micro_service.domain.owner.Owner;
import com.thullyooo.owner_micro_service.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private OwnerRepository repository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Owner> owner = repository.findByName(username);
        if (owner.isEmpty()){
            throw new UsernameNotFoundException("Owner não encontrado");
        }
        return owner.get();

    }
}
