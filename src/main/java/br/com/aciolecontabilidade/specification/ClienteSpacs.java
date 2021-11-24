package br.com.aciolecontabilidade.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.aciolecontabilidade.models.Cliente;

public class ClienteSpacs {

	public static Specification<Cliente> nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"), nome);
	}
	
	public static Specification<Cliente> cpf(String cpf) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Cliente> rg(String rg) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("rg"), rg);
	}
	
	public static Specification<Cliente> tituloEleitor(String tituloEleitor) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("tituloEleitor"), tituloEleitor);
	}
	
	public static Specification<Cliente> numContato(String numContato) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("numContato"), numContato);
	}
	
	public static Specification<Cliente> email(String email) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
	}

}
