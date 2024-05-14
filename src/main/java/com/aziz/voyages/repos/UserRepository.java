package com.aziz.voyages.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aziz.voyages.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}