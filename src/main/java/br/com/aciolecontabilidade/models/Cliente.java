package br.com.aciolecontabilidade.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "TB_CLIENTE_ID_CLIENTE_SEQ", sequenceName = "TB_CLIENTE_ID_CLIENTE_SEQ", initialValue = 1, allocationSize = 1)
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_CLIENTE_ID_CLIENTE_SEQ")
	@Column(name = "ID_CLIENTE", nullable = false)
	private Long id;
	
	@Column(name = "NOME_CLIENTE", nullable = false, length = 100)
	private String nome;

	@Column(name = "CPF_CLIENTE", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column(name = "RG_CLIENTE", nullable = false, length = 15, unique = true)
	private String rg;
	
	@Column(name = "TITULO_ELEITOR_CLIENTE", nullable = false, length = 12, unique = true)
	private String tituloEleitor;
	
	@Column(name = "NUM_CONTATO_CLIENTE", nullable = true, length = 11)
	private String numContato;

	@Column(name = "EMAIL_CLIENTE", nullable = true, length = 100, unique = true)
	private String email;
	
	@Column(name = "DT_NASCIMENTO_CLIENTE", nullable = false)
//	@Convert(converter = LocalDateConverter.class)
	private LocalDate dtNascimento;
	
	@Column(name = "ULTIMO_VALOR_COBRADO_CLIENTE", nullable = true)
	private BigDecimal ultimoValorCobrado;

}
