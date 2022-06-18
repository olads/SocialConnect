package com.migia.socialconnect.service;

import com.migia.socialconnect.model.User;
import com.migia.socialconnect.repository.UserRepository;
import com.migia.socialconnect.security.UserDetailImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).
                orElseThrow(() -> {
                  return  new UsernameNotFoundException("User with username " + username + "not found");
                });
        return new UserDetailImpl(user);
    }


    public boolean saveUser(User user){
        if(user == null){
            return false;
        }
        Optional<User > optionalUser = userRepository.findByUsername(user.getUsername());

        if(optionalUser.isPresent()){
            logger.warn("User with username " + user.getUsername() + "already exists");
            return false;
        }
        logger.info("User with username " + user.getUsername() + "has been saved successfully");
        userRepository.save(user);
        return true;
    }


}
