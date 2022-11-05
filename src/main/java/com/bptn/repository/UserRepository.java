package com.bptn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bptn.jpa.UserID;

@Repository
public interface UserRepository extends JpaRepository<UserID, String> {

    @Query(value = "SELECT * FROM UserID u WHERE u.username = ?1", nativeQuery = true)

    abstract Optional<UserID> findByUsername(String username);

}
