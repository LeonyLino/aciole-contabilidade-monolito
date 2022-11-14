package br.com.aciolecontabilidade.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.aciolecontabilidade.enums.PortalEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_ACESSO_PORTAL")
@NoArgsConstructor
@SequenceGenerator(name = "TB_ACESSO_PORTAL_ID_CLIENTE_SEQ", sequenceName = "TB_ACESSO_PORTAL_ID_CLIENTE_SEQ", initialValue = 1, allocationSize = 1)
public class AcessoPortal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TB_ACESSO_PORTAL_ID_CLIENTE_SEQ")
	@Column(name = "ID_ACESSO", nullable = false)
	private Long id;
	
	@Column(name = "DS_ACESSO", nullable = false)
	private PortalEnum descricao;

	@Column(name = "COD_ACESSO", nullable = false)
	private String codigoAcesso;

	@Column(name = "SENHA_ACESSO", nullable = false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE", nullable = false)
	private Cliente cliente;

}
