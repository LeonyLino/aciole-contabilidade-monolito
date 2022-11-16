package br.com.aciolecontabilidade.models.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePFDTO {

	private Long id;
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nomePF;
	@NotEmpty
	@CPF
	private String cpfCnpjPF;
	@NotEmpty
	@Size(min = 3, max = 15)
	private String rgPF;
	@NotEmpty
	@Size(min = 3, max = 12)
	private String tituloPF;
	@NotEmpty
	@Size(max = 16)
	private String numContatoPF;
	@Email
	private String emailPF;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNascimentoPF;
	@NotEmpty
	@NotNull
	private String tipo;
	
	public TipoClienteEnum getTipoServico() {
		for (TipoClienteEnum tce : TipoClienteEnum.values()) {
			if (tce.toString().equals(tipo)) {
				return tce;
			}
		}
		return null;
	}
}
