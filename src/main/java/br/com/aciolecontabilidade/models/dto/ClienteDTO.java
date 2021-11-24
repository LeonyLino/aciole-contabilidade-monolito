package br.com.aciolecontabilidade.models.dto;

import java.math.BigDecimal;
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
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nomeCliente;
	@NotNull
	@NotEmpty
	@Size(min = 11, max = 14)
	@CPF
	private String cpfCliente;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 15)
	private String rgCliente;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 12)
	private String tituloEleitorCliente;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 11)
	private String numContato;
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNascimento;
	private BigDecimal ultimoValorCobrado;
}
