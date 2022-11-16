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

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "TB_CLIENTE_ID_CLIENTE_SEQ", sequenceName = "TB_CLIENTE_ID_CLIENTE_SEQ", initialValue = 1, allocationSize = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 902775680493951647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_CLIENTE_ID_CLIENTE_SEQ")
	@Column(name = "ID_CLIENTE", nullable = false)
	private Long id;

	@Column(name = "NOME_FANTASIA", nullable = true, length = 100, unique = true)
	private String nomeFantasia;

	@Column(name = "NOME_CLIENTE", nullable = false, length = 100)
	private String nome;

	@Column(name = "CPF_CNPJ_CLIENTE", nullable = false, length = 14, unique = true)
	private String cpfCnpj;

	@Column(name = "RG_CLIENTE", nullable = true, length = 15, unique = true)
	private String rg;

	@Column(name = "TITULO_ELEITOR_CLIENTE", nullable = true, length = 12, unique = true)
	private String tituloEleitor;

	@Column(name = "NUM_CONTATO_CLIENTE", nullable = true, length = 11)
	private String numContato;

	@Column(name = "EMAIL_CLIENTE", nullable = true, length = 100, unique = true)
	private String email;

	@Column(name = "DT_NASCIMENTO_CLIENTE", nullable = false)
//	@Convert(converter = LocalDateConverter.class)
	private LocalDate dtNascimento;

	@OneToMany(mappedBy = "cliente")
	private List<AcessoPortal> senhas;

	@Column(name = "FIXO_CLIENTE", nullable = false, length = 1)
	private Character fixo;

	@Column(name = "TIPO_CLIENTE", nullable = true, length = 4)
	private TipoClienteEnum tipo;

	@OneToMany(mappedBy = "cliente")
	private List<Servico> servicos;

//	public Cliente(String nome, String cpfString, String rg, String tituloEleitor, String numContato, String email,
//			LocalDate dtNascimento, TipoClienteEnum tipo) {
//		nome = this.nome;
//		cpfString = this.cpfCnpj;
//		rg = this.rg;
//		tituloEleitor = this.tituloEleitor;
//		numContato = this.numContato;
//		email = this.email;
//		dtNascimento = this.dtNascimento;
//		tipo = this.tipo;
//	}

}
