package com.vacinas.repository;

import com.vacinas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
@Query("SELECT u FROM  User u JOIN FETCH u.roles WHERE u.username = :username")
    User finByUsernameFetchRoles(@Param("username") String username);
}
