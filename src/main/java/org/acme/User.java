package org.acme;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class User extends PanacheEntity {
    @Column public String username;
    @Column public String email;
    @Column public String password;

    public User() {
        super();
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }    

    public static Optional<User> findUserByUsername(String username) {
        return find("username", username).firstResultOptional();
    }

}
