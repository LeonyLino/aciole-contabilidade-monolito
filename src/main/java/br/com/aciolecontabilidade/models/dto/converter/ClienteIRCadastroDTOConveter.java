package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteIRCadastroDTO;

@Component
public class ClienteIRCadastroDTOConveter implements Converter<Cliente, ClienteIRCadastroDTO> {

	@Override
	public ClienteIRCadastroDTO convert(Cliente cliente) {
		return ClienteIRCadastroDTO.builder().id(cliente.getId()).nomeIR(cliente.getNome())
				.cpfIR(cliente.getTipo().equals(TipoClienteEnum.PF) ? cliente.getCpfCnpj() : null)
				.cnpjIR(cliente.getTipo().equals(TipoClienteEnum.PJ) ? cliente.getCpfCnpj() : null)
				.rgIR(cliente.getRg()).tituloIR(cliente.getTituloEleitor() != null ? cliente.getTituloEleitor() : "")
				.numContatoIR(cliente.getNumContato()).emailIR(cliente.getEmail())
				.dtNascimentoIR(cliente.getDtNascimento()).tipoIR(cliente.getTipo().toString()).build();
	}

}
