package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.DetalharClienteIRDTO;

@Component
public class DetalharClienteDTOConverter implements Converter<Cliente, DetalharClienteIRDTO> {

	@Override
	public DetalharClienteIRDTO convert(Cliente cliente) {
		return DetalharClienteIRDTO.builder().id(cliente.getId()).nome(cliente.getNome()).cpfCnpj(cliente.getCpfCnpj()).rg(cliente.getRg())
				.tituloEleitor(cliente.getTituloEleitor()).numContato(cliente.getNumContato()).email(cliente.getEmail())
				.dtNascimento(cliente.getDtNascimento()).tipo(cliente.getTipo()).servicos(cliente.getServicos()).build();
	}

}
