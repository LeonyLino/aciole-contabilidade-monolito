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
import javax.validation.constraints.NotNull;

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
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

	public Cliente(Object object, String nomePF, String cpfCnpjPF, String rgPF, String tituloPF, String numContatoPF,
			String emailPF, @NotNull LocalDate dtNascimentoPF, Object object2, Character chave, Object object3) {
	}

	private static final long serialVersionUID = 902775680493951647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_CLIENTE_ID_CLIENTE_SEQ")
	@Column(name = "ID_CLIENTE", nullable = false)
	private Long id;

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

}
