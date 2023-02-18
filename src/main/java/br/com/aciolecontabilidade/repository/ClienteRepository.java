package br.com.aciolecontabilidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.aciolecontabilidade.enums.FlagExcluidoEnum;
import br.com.aciolecontabilidade.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

	boolean existsByCpfCnpj(String cpfCnpj);

	boolean existsByRg(String rg);

	boolean existsByTituloEleitor(String tituloEleitor);

	boolean existsByEmail(String email);

	List<Cliente> findAllByFlagExcluidoIs(FlagExcluidoEnum flagExcluidoEnum);

}
