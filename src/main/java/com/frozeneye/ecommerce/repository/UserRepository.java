package com.frozeneye.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frozeneye.ecommerce.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

    public Users findByEmail(String email);

}
