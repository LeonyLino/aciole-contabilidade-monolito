package br.com.aciolecontabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.aciolecontabilidade.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

	boolean existsByCpfCnpj(String cpf);

	boolean existsByRg(String rg);

	boolean existsByTituloEleitor(String tituloEleitor);

	boolean existsByEmail(String email);
	
}
