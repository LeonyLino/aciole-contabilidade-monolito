package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.DetalharClienteDTO;

@Component
public class DetalharClienteDTOConverter implements Converter<Cliente, DetalharClienteDTO> {

	@Override
	public DetalharClienteDTO convert(Cliente cliente) {
		return DetalharClienteDTO.builder().id(cliente.getId()).nome(cliente.getNome())
				.nomeFantasia(cliente.getNomeFantasia()).cpf(cliente.getCpf()).cnpj(cliente.getCnpj())
				.rg(cliente.getRg()).tituloEleitor(cliente.getTituloEleitor())
				.numContato(cliente.getNumContato()).email(cliente.getEmail()).dtNascimento(cliente.getDtNascimento())
				.senhaGov(cliente.getSenhaGov()).ativo(cliente.getAtivo()).servicos(cliente.getServicos()).build();
	}

}
