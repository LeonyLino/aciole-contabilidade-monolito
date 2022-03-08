package br.com.aciolecontabilidade.models.dto;

import java.math.BigDecimal;

import br.com.aciolecontabilidade.enums.TipoServicoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastrarServicoDTO {
	
	private TipoServicoEnum tipo;
	private BigDecimal valor;
	private Long idCliente;

}
