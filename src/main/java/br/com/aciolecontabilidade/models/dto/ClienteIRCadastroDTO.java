package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIRCadastroDTO {

	private Long id;
	@NotEmpty(message = "*Campo Obrigatório!")
	@Size(min = 3, max = 100, message = "*Deve ter o tamanho entre 3 e 100 caracteres.")
	private String nomeIR;
	@CPF(message = "CPF Inválido!")
	private String cpfIR;
	@CNPJ(message = "CNPJ Inválido!")
	private String cnpjIR;
	@Size(max = 15, message = "Tamanho máximo de 15 caracteres.")
	private String rgIR;
	@TituloEleitoral(message = "Titulo Eleitoral Inválido!")
	private String tituloIR;
	@NotEmpty(message = "*Campo Obrigatório!")
	@Size(min = 16, max = 16, message = "*Número tem que ser formado por: (DDD) '9' 0000-0000")
	private String numContatoIR;
	@Email
	private String emailIR;
	@NotNull(message = "Campo Obrigatório!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNascimentoIR;
	@NotEmpty(message = "Campo Obrigatório!")
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
