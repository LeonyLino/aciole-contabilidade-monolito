package br.com.aciolecontabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aciolecontabilidade.models.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

}
