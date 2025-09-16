package com.moha123live.gtk_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.User;
import com.moha123live.gtk_api.model.User.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    boolean existsByUsernameIgnoreCase(String username);
    boolean existsByEmailIgnoreCase(String email);
    List<User> findByRole(Role role);
    
}
