package com.practice.CrudOperation.repository;

import com.practice.CrudOperation.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
