package com.indeas.auth.repository;

import com.indeas.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {

    @Query("FROM Permission p WHERE p.description = :description")
    Permission findByDescription(@Param("description") String description);

}
