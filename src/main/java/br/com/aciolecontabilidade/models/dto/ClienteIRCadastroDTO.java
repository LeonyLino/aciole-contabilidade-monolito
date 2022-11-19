package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIRCadastroDTO {

	private Long id;
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nomeIR;
	@CPF
	private String cpfIR;
	@CNPJ
	private String cnpjIR;
	@NotEmpty
	@Size(min = 3, max = 15)
	private String rgIR;
	@NotEmpty
	@Size(min = 3, max = 12)
	private String tituloIR;
	@NotEmpty
	@Size(max = 16)
	private String numContatoIR;
	@Email
	private String emailIR;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNascimentoIR;
	@NotEmpty
	@NotNull
	private String tipoIR;
	
	public TipoClienteEnum getTipoCliente() {
		for (TipoClienteEnum tce : TipoClienteEnum.values()) {
			if (tce.toString().equals(tipoIR)) {
				return tce;
			}
		}
		return null;
	}
}
