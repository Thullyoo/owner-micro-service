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
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repository.findByName(name)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("Owner não encotrado"));

    }
}
