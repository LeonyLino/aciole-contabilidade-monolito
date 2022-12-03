package br.com.aciolecontabilidade.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
public class Servico implements Serializable {

	private static final long serialVersionUID = -7155943837095051479L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_SERVICO_ID_SERVICO_SEQ")
	@Column(name = "ID_SERVICO", nullable = false)
	private Long id;

	@Column(name = "VALOR_SERVICO", nullable = false)
	private BigDecimal valor;

	@Column(name = "ANO_REFERENCIA_SERVICO", nullable = false)
	private String anoReferencia;
	
	@Column(name = "DATA_SERVICO", nullable = false)
	private LocalDate data;
	
	@Column(name = "OBSERVACOES_SERVICO")
	private String observacoes;

	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE", nullable = false)
	private Cliente cliente;

}
