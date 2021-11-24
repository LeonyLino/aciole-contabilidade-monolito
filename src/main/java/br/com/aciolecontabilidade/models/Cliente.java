package br.com.aciolecontabilidade.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "nome_cliente", nullable = false, length = 100)
	private String nome;

	@Column(name = "cpf_cliente", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column(name = "rg_cliente", nullable = false, length = 15, unique = true)
	private String rg;
	
	@Column(name = "titulo_eleitor_cliente", nullable = false, length = 12, unique = true)
	private String tituloEleitor;
	
	@Column(name = "num_contato_cliente", nullable = true, length = 11)
	private String numContato;

	@Column(name = "email_cliente", nullable = true, length = 100, unique = true)
	private String email;
	
	@Column(name = "dt_nascimento_cliente", nullable = false)
//	@Convert(converter = LocalDateConverter.class)
	private LocalDate dtNascimento;
	
	@Column(name = "ULTIMO_VALOR_COBRADO_CLIENTE", nullable = true)
	private BigDecimal ultimoValorCobrado;

}
