package com.migia.socialconnect.model;


import com.migia.socialconnect.security.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Validated
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank(message="Username cannot be blank")
    @Size(min=3, message ="Size of username must be more than 3")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    @Size(min=5, message ="Size of password must be more than 5")
    private String password;

    @Email(message = "Please input a valid email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Post> posts;

    private Role role;

    public User(String username, String password, String email,Role role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        posts  = new HashSet<>();
    }


}
