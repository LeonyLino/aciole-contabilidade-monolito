package br.com.aciolecontabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aciolecontabilidade.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

}
