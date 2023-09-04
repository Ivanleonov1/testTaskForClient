package com.example.testtaskforclient.repository;

import com.example.testtaskforclient.entitys.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
