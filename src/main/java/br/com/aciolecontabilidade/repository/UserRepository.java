package br.com.aciolecontabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aciolecontabilidade.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
