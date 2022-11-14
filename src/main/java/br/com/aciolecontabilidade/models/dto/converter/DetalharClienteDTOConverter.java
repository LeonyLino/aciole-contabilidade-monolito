package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.DetalharClienteDTO;

@Component
public class DetalharClienteDTOConverter implements Converter<Cliente, DetalharClienteDTO> {

	@Override
	public DetalharClienteDTO convert(Cliente cliente) {
		return null;
	}

}
