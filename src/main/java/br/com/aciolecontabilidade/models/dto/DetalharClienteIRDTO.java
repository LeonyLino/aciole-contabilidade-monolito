package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import br.com.aciolecontabilidade.models.AcessoPortal;
import br.com.aciolecontabilidade.models.Servico;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalharClienteIRDTO {

	private Long id;
	private String nome;
	private String cpfCnpj;
	private String rg;
	private String tituloEleitor;
	private String numContato;
	private String email;
	private LocalDate dtNascimento;
	private List<Servico> servicos;
	private List<AcessoPortal> acessos;
	private TipoClienteEnum tipo;
}
