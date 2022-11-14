package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteDTOOut;

@Component
public class ClienteDTOConverter implements Converter<Cliente, ClienteDTOOut> {

	@Override
	public ClienteDTOOut convert(Cliente cliente) {
		return ClienteDTOOut.builder().id(cliente.getId()).nomeCliente(cliente.getNome()).cpfCliente(cliente.getCpfCnpj())
				.rgCliente(cliente.getRg()).tituloEleitorCliente(cliente.getTituloEleitor())
				.numContato(cliente.getNumContato()).email(cliente.getEmail()).dtNascimento(cliente.getDtNascimento())
				.build();
	}

}
