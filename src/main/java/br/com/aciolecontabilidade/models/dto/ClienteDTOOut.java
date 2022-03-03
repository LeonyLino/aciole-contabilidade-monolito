package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTOOut {

	private Long id;
	private String nomeCliente;
	private String cpfCliente;
	private String rgCliente;
	private String tituloEleitorCliente;
	private String numContato;
	private String email;
	private LocalDate dtNascimento;
}
