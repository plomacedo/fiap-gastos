package com.fiap.webservices.Gastos.Repository;

import com.fiap.webservices.Gastos.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
