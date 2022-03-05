package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private Long id;
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nomeCliente;
	@Size(max = 200)
	private String nomeFantasia;
	@NotEmpty
	@CPF
	private String cpfCliente;
//	@CNPJ
	private String cnpj;
	@NotEmpty
	@Size(min = 3, max = 15)
	private String rgCliente;
	@NotEmpty
	@Size(min = 3, max = 12)
	private String tituloEleitorCliente;
	@NotEmpty
	@Size(max = 16)
	private String numContato;
	@Email
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNascimento;
	@Size(min = 4, max = 50)
	private String senhaGov;
}
