package br.com.aciolecontabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aciolecontabilidade.models.AcessoPortal;

@Repository
public interface AcessoPortalRepository extends JpaRepository<AcessoPortal, Long> {

}
