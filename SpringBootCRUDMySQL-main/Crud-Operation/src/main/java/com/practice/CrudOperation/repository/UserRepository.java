package com.practice.CrudOperation.repository;

import com.practice.CrudOperation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
