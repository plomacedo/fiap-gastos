package com.fiap.webservices.Gastos.Repository;

import com.fiap.webservices.Gastos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
