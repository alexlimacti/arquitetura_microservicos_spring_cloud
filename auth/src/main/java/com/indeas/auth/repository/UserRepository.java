package com.indeas.auth.repository;

import com.indeas.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("FROM User u WHERE u.userName = :userName")
    User findByUserName(@Param("userName") String userName);

}
