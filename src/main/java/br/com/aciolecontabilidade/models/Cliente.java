package br.com.aciolecontabilidade.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
@NoArgsConstructor
@SequenceGenerator(name = "TB_CLIENTE_ID_CLIENTE_SEQ", sequenceName = "TB_CLIENTE_ID_CLIENTE_SEQ", initialValue = 1, allocationSize = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 902775680493951647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_CLIENTE_ID_CLIENTE_SEQ")
	@Column(name = "ID_CLIENTE", nullable = false)
	private Long id;

	@Column(name = "NOME_CLIENTE", nullable = false, length = 100)
	private String nome;

	@Column(name = "NOME_FANTASIA_CLIENTE", nullable = true, length = 200)
	private String nomeFantasia;

	@Column(name = "CPF_CLIENTE", nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(name = "CNPJ_CLIENTE", nullable = true, length = 14)
	private String cnpj;

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

	@Column(name = "SENHA_GOV_CLIENTE", nullable = true, length = 50)
	private String senhaGov;

	@Column(name = "ATIVO_CLIENTE", nullable = false, length = 1)
	private Character ativo;

	@OneToMany(mappedBy = "cliente")
	private List<Servico> servicos;

	public Cliente(String nome, String nomeFantasia, String cpf, String cnpj, String rg, String tituloEleitor,
			String numContato, String email, LocalDate dtNascimento, String senhaGov, Character ativo) {
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.rg = rg;
		this.tituloEleitor = tituloEleitor;
		this.numContato = numContato;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.senhaGov = senhaGov;
		this.ativo = ativo;
	}

	public Cliente(Long id) {
		this.id = id;
	}

}
