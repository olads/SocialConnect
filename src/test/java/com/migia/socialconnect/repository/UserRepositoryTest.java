package com.migia.socialconnect.repository;

import com.migia.socialconnect.model.User;
import com.migia.socialconnect.security.Role;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSave(){
        User newUser = new User("MiGiA", "stephen", "migia@gmail.com", Role.USER);
        User newUser1 = new User("Stephen", "stephen", "stephen@gmail.com", Role.ADMIN);

       userRepository.save(newUser);
       userRepository.save(newUser1);
    }


}
