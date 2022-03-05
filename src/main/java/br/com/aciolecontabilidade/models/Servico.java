package br.com.aciolecontabilidade.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_SERVICO")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "TB_SERVICO_ID_SERVICO_SEQ", sequenceName = "TB_SERVICO_ID_SERVICO_SEQ", initialValue = 1, allocationSize = 1)
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_SERVICO_ID_SERVICO_SEQ")
	@Column(name = "ID_SERVICO", nullable = false)
	private Long id;
	
	@Column(name = "TIPO_SERVICO", nullable = false)
	private String tipo;
	
	@Column(name = "VALOR_SERVICO", nullable = false)
	private BigDecimal valorCobrado;
	
	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE")
	private Cliente cliente;
}
