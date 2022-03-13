package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.aciolecontabilidade.models.Servico;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalharClienteDTO {

	private Long id;
	private String nome;
	private String nomeFantasia;
	private String cpf;
	private String cnpj;
	private String rg;
	private String tituloEleitor;
	private String numContato;
	private String email;
	private LocalDate dtNascimento;
	private String senhaGov;
	private boolean ativo;
	private List<Servico> servicos;
}
