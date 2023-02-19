package com.vacinas.repository;

import com.vacinas.model.PatientModel;
import com.vacinas.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {

   /* UserModel findByUsername(String username);
@Query("SELECT u FROM  UserModel u JOIN FETCH u.roles WHERE u.username = :username")
UserModel finByUsernameFetchRoles(@Param("username") String username);*/
}
