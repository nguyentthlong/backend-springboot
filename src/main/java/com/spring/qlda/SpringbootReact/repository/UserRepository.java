package com.spring.qlda.SpringbootReact.repository;

import com.spring.qlda.SpringbootReact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long>{
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
